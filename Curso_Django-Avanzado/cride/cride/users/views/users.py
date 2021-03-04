"""Users views
    http://www.cdrf.co/
"""

# Django REST Framework
from rest_framework import status, viewsets, mixins
from rest_framework.decorators import action
from rest_framework.response import Response
from rest_framework.views import APIView

# Serializers
from cride.users.serializers import (
    UserLoginSerializer,
    UserModelSerializer,
    UserSignUpSerializer,
    AccountVerificationSerializer
)



class UserViewSet(viewsets.GenericViewSet):
    """User view set.
        Handle sign up, login and account verification.
    """

    @action(detail=False, methods=['post'])
    def login(self, request):
        """User sign in."""
        serializer = UserLoginSerializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        user, token = serializer.save()
        data = {
            'user': UserModelSerializer(user).data,
            'access_token': token
        }
        return Response(data, status=status.HTTP_201_CREATED)


    @action(detail=False, methods=['post'])
    def signup(self, request):
        """User sign up."""
        serializer = UserSignUpSerializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        user = serializer.save()
        data = UserModelSerializer(user).data
        return Response(data, status=status.HTTP_201_CREATED)

    @action(detail=False, methods=['post'])
    def verify(self, request):
        """Account verification."""
        serializer = AccountVerificationSerializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        serializer.save()
        data = {'message': 'Congratulation, now go share some rides!'}
        return Response(data, status=status.HTTP_200_OK)



# class UserLoginAPIView(APIView):
#     """User Login API View"""

#     def post(self, request, *args, **kwargs):
#         """Hande HTTP POST request """
#         serializer = UserLoginSerializer(data=request.data)
#         serializer.is_valid(raise_exception=True)
#         user, token = serializer.save()

#         data = {
#             'user': UserModelSerializer(user).data,
#             'access_token': token
#         }

#         return Response(data, status=status.HTTP_201_CREATED)


# class UserSignUpAPIView(APIView):
#     """ User sing up API view"""

#     def post(self, request, *args, **kwargs):
#         """Hande HTTP POST request """
#         serializer = UserSignUpSerializer(data=request.data)
#         serializer.is_valid(raise_exception=True)
#         user = serializer.save()

#         data =  UserModelSerializer(user).data

#         return Response(data, status=status.HTTP_201_CREATED)




# class AccountVerificationAPIView(APIView):
#     """ Account verification API view"""

#     def post(self, request, *args, **kwargs):
#         """Hande HTTP POST request """
#         serializer = AccountVerificationSerializer(data=request.data)
#         serializer.is_valid(raise_exception=True)
#         serializer.save()
#         data = {'message':'Congratulations, now go share some rides!'}
#         return Response(data, status=status.HTTP_200_OK)

