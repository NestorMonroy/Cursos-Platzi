from datetime import datetime
from django.shortcuts import redirect, render
from django.contrib.auth.decorators import login_required
from .models import Post

from .forms import PostForm

# Create your views here.

@login_required
def list_posts(request):
    """ List existing post """
    posts = Post.objects.all().order_by('-created')

    return render(request, 'posts/feed.html', {'posts': posts})


@login_required
def create_posts(request):
    if request.method == 'POST':
        form = PostForm(request.POST, request.FILES)
        if form.is_valid():
            form.save()
            return redirect('feed')
    else:
        form = PostForm()

    ctx = {
        'form': form,
        'user': request.user,
        'profile': request.user.profile
    }

    return render(request, 'posts/create.html', ctx)
