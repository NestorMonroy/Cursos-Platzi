"""User serializers """
# Django
from django.conf import settings
from django.contrib.auth import authenticate, password_validation
from django.utils import timezone
from django.core.validators import RegexValidator
from django.core.mail import EmailMultiAlternatives
from django.template.loader import render_to_string
# Django REST Framework
from rest_framework import serializers
from rest_framework.authtoken.models import Token
from rest_framework.validators import UniqueValidator

# Models
from cride.users.models import User, Profile

# Serializers
from cride.users.serializers.profiles import ProfileModelSerializer

# Tasks
from cride.taskapp.tasks import send_confirmation_email

# Utilities
# https://pyjwt.readthedocs.io/en/stable/usage.html#encoding-decoding-tokens-with-hs256
import jwt
from datetime import timedelta


class UserModelSerializer(serializers.ModelSerializer):
    """User model serializer"""
    profile = ProfileModelSerializer(read_only=True)

    class Meta:
        model = User
        fields = (
            'username',
            'first_name',
            'last_name',
            'email',
            'phone_number',
            'profile'
        )


class UserSignUpSerializer(serializers.Serializer):
    """User signup serializer
        handle sign up validation and user/profile creation
    """

    email = serializers.EmailField(
        validators=[UniqueValidator(queryset=User.objects.all())]
    )
    username = serializers.CharField(
        min_length=4,
        max_length=50,
        validators=[UniqueValidator(queryset=User.objects.all())]
    )
    phone_regex = RegexValidator(
        regex=r'\+?1?\d{9,15}$',
        message="Phone number must be entered in the format: +1234567890 Up to 15 digits allowed."
    )
    phone_number = serializers.CharField(
        validators=[phone_regex]
    )

    password = serializers.CharField(min_length=8, max_length=64)
    password_confirmation = serializers.CharField(min_length=8, max_length=64)

    first_name = serializers.CharField(min_length=2, max_length=30)
    last_name = serializers.CharField(min_length=2, max_length=30)

    def validate(self, data):

        passwd = data['password']
        passwd_conf = data['password_confirmation']

        if passwd != passwd_conf:
            raise serializers.ValidationError('Passwords dont match')
        password_validation.validate_password(passwd)
        return data

    def create(self, data):
        """Handle User and creation"""

        data.pop('password_confirmation')
        user = User.objects.create_user(**data, is_verified=False, is_client = True)
        Profile.objects.create(user=user)
        send_confirmation_email.delay(user_pk=user.pk)
        return user



class UserLoginSerializer(serializers.Serializer):

    """ User login serializer.
        Handle the login request data
    """
    email = serializers.EmailField()
    password = serializers.CharField(min_length=8, max_length=64)

    def validate(self, data):
        """Check credentials."""

        # validate, corre despues de las validaciones de cada campo
        user = authenticate(username=data['email'], password=data['password'])
        if not user:
            raise serializers.ValidationError('Invalid credentials')
        if not user.is_verified:
            raise serializers.ValidationError('Account is not active :( ')
        self.context['user'] = user  # todos los serializers comparten el context => es un atributo de clase
        return data

    def create(self, data):
        ''' Create token for identificate the user and update the last login date'''
        token, created_token = Token.objects.get_or_create(user=self.context['user'])

        user = self.context['user']
        if created_token:
            user.last_login = timezone.now()
            user.save(update_fields=['last_login'])
        return user, token.key


class AccountVerificationSerializer(serializers.Serializer):
    """Account verification Serializer"""

    token = serializers.CharField()

    def validate_token(self, data):
        """Verify token is valid
            https://pyjwt.readthedocs.io/en/stable/api.html#exceptions
        """

        try:
            payload = jwt.decode(data, settings.SECRET_KEY, algorithms=['HS256'])
        except jwt.ExpiredSignatureError:
            raise serializers.ValidationError('Verification link has expired')
        except jwt.PyJWTError:
            raise serializers.ValidationError('Invalid token')
        if payload['type'] != 'email_confirmation':
            raise serializers.ValidationError('Invalid token')
        self.context['payload'] = payload
        return data

    # create regresa la instancia de un objecto
    # en este caso usamos save
    def save(self):
        """Update users verified status"""

        payload = self.context['payload']
        user = User.objects.get(username=payload['user'])
        user.is_verified = True
        user.save()
