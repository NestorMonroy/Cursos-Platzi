"""Rides admin."""

# Django
from django.contrib import admin

# Model
from cride.rides.models import Ride



admin.site.register(Ride)