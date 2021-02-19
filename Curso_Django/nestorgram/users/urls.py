from django.urls import path
from . import views

urlpatterns = [

    path('login/', views.LoginView.as_view(), name='login'),
    path('logout/', views.LogoutView.as_view(), name='logout'),
    path('signup/', views.SignupView.as_view(), name='signup'),
    path('me/profile', views.UpdateProfileUpdateView.as_view(), name='update_profile'),
    #Posts
    path('<str:username>/',views.UserDetailView.as_view() , name='detail' ),

]
