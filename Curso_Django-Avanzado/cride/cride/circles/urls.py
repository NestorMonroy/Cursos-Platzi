"""Circles URLs module."""

from django.urls import path, include
from cride.circles.views import list_circles, create_circle

urlpatterns = [
    path('circles/', list_circles),
    path('circles/create/', create_circle)
] 
