from django.shortcuts import render
from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.decorators import login_required
from django.contrib.auth.mixins import LoginRequiredMixin
from django.contrib.auth import views as auth_views
from django.shortcuts import redirect, render
from django.urls import reverse, reverse_lazy
from django.views.generic import DetailView, FormView, UpdateView

from django.db.utils import IntegrityError

from django.contrib.auth.models import User
from .models import Profile
from posts.models import Post
from .forms import ProfileForm, SignupForm


class UserDetailView(LoginRequiredMixin, DetailView):

    template_name = 'users/detail.html'
    slug_field = 'username'
    slug_url_kwarg = 'username'
    queryset = User.objects.all()
    context_object_name = 'user'

    def get_context_data(self, **kwargs):
        """Add user's posts to context."""
        context = super().get_context_data(**kwargs)
        user = self.get_object()
        context['posts'] = Post.objects.filter(user=user).order_by('-created')
        return context


class LoginView(auth_views.LoginView):
    template_name = 'users/login.html'
    redirect_authenticated_user = True


@login_required
def logout_view(request):
    logout(request)
    return redirect('users:login')


class LogoutView(auth_views.LogoutView):
    """Vista de logout"""
    pass


class SignupView(FormView):
    template_name = 'users/signup.html'
    form_class = SignupForm
    success_url = reverse_lazy('posts:feed')
    """ Siempre en FormView se tiene que usar el form_valid """

    def form_valid(self, form):
        form.save()

        username = form['username'].value()
        password = form['password'].value()

        user = authenticate(
            self.request, username=username, password=password)

        login(self.request, user)

        return super().form_valid(form)


def signup(request):
    #import pdb; pdb.set_trace()
    if request.method == 'POST':
        form = SignupForm(request.POST)
        if form.is_valid():
            form.save()

            #import pdb; pdb.set_trace()
            username = request.POST.get('username')
            password = request.POST.get('password')
            user = authenticate(request, username=username, password=password)
            login(request, user)

            return redirect('posts:feed')

    else:
        form = SignupForm()

    ctx = {
        'form': form
    }
    return render(request, 'users/signup.html', ctx)


class UpdateProfileUpdateView(LoginRequiredMixin, UpdateView):

    template_name = 'users/update_profile.html'
    model = Profile
    form_class = ProfileForm

    def get_object(self):
        """ Return user's profile """
        return self.request.user.profile

    def get_success_url(self):
        """ Return to user's profile """
        username = self.object.user.username
        return reverse('users:detail', kwargs={'username': username})


@login_required
def update_profile(request):
    profile = request.user.profile

    if request.method == 'POST':
        form = ProfileForm(request.POST, request.FILES)
        if form.is_valid():
            # print(form.cleaned_data)
            data = form.cleaned_data
            profile.website = data['website']
            profile.phone_number = data['phone_number']
            profile.biography = data['biography']
            profile.picture = data['picture']
            profile.save()

            url = reverse('users:detail', kwargs={
                          'username': request.user.username})
            return redirect(url)

    else:
        form = ProfileForm()

    ctx = {
        'profile': profile,
        'user': request.user,
        'form': form,
    }
    return render(request, 'users/update_profile.html', ctx)
