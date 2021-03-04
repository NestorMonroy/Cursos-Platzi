"""Circle views."""

# Django REST Framework
from rest_framework import viewsets, mixins

# Serializers
from cride.circles.serializers import CircleModelSerializer

# Permissions
from rest_framework.permissions import IsAuthenticated
from cride.circles.permissions.circles import IsCircleAdmin

# Models
from cride.circles.models import Circle, Membership


class CircleViewSet(mixins.CreateModelMixin,
                    mixins.RetrieveModelMixin,
                    mixins.UpdateModelMixin,
                    mixins.ListModelMixin,
                    viewsets.GenericViewSet):
    """Circle view set."""

    serializer_class = CircleModelSerializer
    lookup_field = 'slug_name'
    
    def get_queryset(self):
        """Restric list to public-only"""
        queryset = Circle.objects.all()
        if self.action == 'list':
            return queryset.filter(is_public=True)
        return queryset

    #https://www.django-rest-framework.org/tutorial/4-authentication-and-permissions/#associating-snippets-with-users
    def perform_create(self, serializer):
        """Assign circle admin."""
        circle = serializer.save()
        user = self.request.user
        profile = user.profile
        Membership.objects.create(
            user=user,
            profile=profile,
            circle=circle,
            is_admin=True,
            remaining_invitations=10
        )

    # https://www.django-rest-framework.org/api-guide/viewsets/#introspecting-viewset-actions
    def get_permissions(self):
        """Assign permissions based on action."""
        permissions = [IsAuthenticated]
        if self.action in ['update', 'partial_update']:
            permissions.append(IsCircleAdmin)
        return [permission() for permission in permissions]

# """Circles views"""
# from django.http import JsonResponse
# from rest_framework.decorators import api_view
# from rest_framework.response import Response
# #Models
# from cride.circles.models import Circle
# #Serializer
# from cride.circles.serializers import CircleSerializer, CreateCircleSerializer


# @api_view(['GET'])
# def list_circles(request):
#     circles = Circle.objects.filter(is_public=True)
#     serializer = CircleSerializer(circles, many=True)
#     return Response(serializer.data)


# @api_view(['POST'])
# def create_circle(request):
#     serializer = CreateCircleSerializer(data= request.data)
#     serializer.is_valid(raise_exception=True)

#     circle = serializer.save()

#     return Response(CircleSerializer(circle).data)
