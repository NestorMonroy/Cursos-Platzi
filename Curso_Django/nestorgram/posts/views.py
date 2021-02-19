from datetime import datetime
from django.urls import reverse_lazy
from django.contrib.auth.decorators import login_required
from django.contrib.auth.mixins import LoginRequiredMixin
from django.views.generic import ListView, DetailView, CreateView
from .models import Post

from .forms import PostForm

# Create your views here.


class PostDetailView(LoginRequiredMixin, DetailView):
    template_name = 'posts/details.html'
    slug_field = 'id'
    slug_url_kwarg = 'post_id'
    queryset = Post.objects.all()


class PostsFeddView(LoginRequiredMixin, ListView):

    template_name = 'posts/feed.html'
    model = Post
    ordering = ('-created')
    paginate_by = 2
    context_object_name = 'posts'


class CreatePostView(LoginRequiredMixin, CreateView):

    template_name = 'posts/create.html'
    form_class = PostForm
    success_url = reverse_lazy('posts:feed')

    def get_context_data(self, **kwargs):
        ctx = super().get_context_data(**kwargs)
        ctx['user'] = self.request.user
        ctx['profile'] = self.request.user.profile
        return ctx

