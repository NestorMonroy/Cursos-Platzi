"""Circles URLs module."""

from django.urls import path, include
from cride.circles.views import list_circles

urlpatterns = [
    path('circles/', list_circles)
] 
