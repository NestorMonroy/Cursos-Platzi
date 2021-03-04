# """Circle serializers."""
# Django REST Framework
from rest_framework import serializers

# Model
from cride.circles.models import Circle


class CircleModelSerializer(serializers.ModelSerializer):
    """Circle model serializer"""

    class Meta:

        model = Circle
        fields = (
            'name', 'slug_name',
            'about', 'picture',
            'rides_offered', 'rides_taken',
            'verified', 'is_public',
            'is_limited', 'members_limit'
        )
        read_only_fields = (
            'is_public',
            'verified',
            'rides_offered',
            'rides_taken',
        )


# # Django REST Framework
# from rest_framework import serializers
# from rest_framework.validators import UniqueValidator

# # Model
# from cride.circles.models import Circle

# class CircleSerializer(serializers.Serializer):
#     """Circle model serializer."""

#     name = serializers.CharField()
#     slug_name = serializers.SlugField()
#     rides_taken = serializers.IntegerField()
#     rides_offered = serializers.IntegerField()
#     members_limit = serializers.IntegerField()


# class CreateCircleSerializer(serializers.Serializer):
#     """Circle create serializer."""

#     name = serializers.CharField(max_length=140)
#     slug_name = serializers.SlugField(
#         max_length=40,
#         validators=[UniqueValidator(queryset=Circle.objects.all())]
#     )

#     about = serializers.CharField(max_length=255, required=False)

#     def create(self, data):

#         return Circle.objects.create(**data)
