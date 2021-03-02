"""Circles views"""
from django.http import JsonResponse
from rest_framework.decorators import api_view
from rest_framework.response import Response
from cride.circles.models import Circle


@api_view(['GET'])
def list_circles(request):
    circles = Circle.objects.filter(is_public=True)
    data = [circle.name for circle in circles]


    return Response(data)


@api_view(['POST'])
def create_circle(request):
    name = request.data['name']
    slug_name = request.data['slug_name']
    about = request.data.get('about', '')

    circle = Circle.objects.create(name=name, slug_name=slug_name, about=about)

    data = {
        'name': circle.name,
        'slug_name': circle.slug_name,
    }

    return Response(data)
    