from django.urls import path
from . import views

urlpatterns = [

    path('', views.PostsFeddView.as_view(), name='feed'),
    path('posts/new/',views.create_posts, name='create'),
    path('posts/<int:post_id>/',views.PostDetailView.as_view(), name='detail'),


]

