"""User serializers """
# Django
from django.contrib.auth import authenticate
from django.utils import timezone

# Django REST Framework
from rest_framework import serializers
from rest_framework.authtoken.models import Token

# Models
from cride.users.models import User


class UserModelSerializer(serializers.ModelSerializer):
    """User model serializer"""
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
