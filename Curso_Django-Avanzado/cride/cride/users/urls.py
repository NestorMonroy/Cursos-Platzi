"""Circles URLs module."""

from django.urls import path, include
from cride.users.views import UserLoginAPIView

urlpatterns = [
    path('users/login/', UserLoginAPIView.as_view(), name='login'),
] 
