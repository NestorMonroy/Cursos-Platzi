"""Circles views"""

from django.http import JsonResponse
from cride.circles.models import Circle

def list_circles(request):
    circles = Circle.objects.filter(is_public=True)
    data = [circle.name for circle in circles]


    return JsonResponse(data, safe=False)
