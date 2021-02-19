from datetime import datetime
from django.shortcuts import redirect, render
from django.contrib.auth.decorators import login_required
from django.contrib.auth.mixins import LoginRequiredMixin
from django.views.generic import ListView, DetailView
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



# @login_required
# def list_posts(request):
#     """ List existing post """
#     posts = Post.objects.all().order_by('-created')

#     return render(request, 'posts/feed.html', {'posts': posts})


@login_required
def create_posts(request):
    if request.method == 'POST':
        form = PostForm(request.POST, request.FILES)
        if form.is_valid():
            form.save()
            return redirect('posts:feed')
    else:
        form = PostForm()

    ctx = {
        'form': form,
        'user': request.user,
        'profile': request.user.profile
    }

    return render(request, 'posts/create.html', ctx)
