from django.urls import path
from django.contrib import admin

from django.conf.urls.static import static
from django.conf import settings

from nestorgram import views as local_views
from posts import views as posts_views

urlpatterns = [
    path('admin/', admin.site.urls),
    path('hello/', local_views.hello),
    path('sorted/', local_views.sorted_integers),
    path('hi/<str:name>/<int:age>/', local_views.say_hi),

    path('posts/',posts_views.list_posts),

] + static(settings.MEDIA_URL, document_root = settings.MEDIA_ROOT)

