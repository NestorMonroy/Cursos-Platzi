from django.shortcuts import render
from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.decorators import login_required
from django.shortcuts import redirect, render

from django.db.utils import IntegrityError

from django.contrib.auth.models import User
from users.models import Profile
# Create your views here.


def login_view(request):
    
    #import pdb; pdb.set_trace()
    if request.method == 'POST':
        
        username = request.POST.get('username')
        password = request.POST.get('password')
        
        user = authenticate(request, username=username, password=password)
        if user:
            login(request, user)
            return redirect('feed')
        else:
            return render(request, 'users/login.html', {'error' : 'Invalid usdername and password'})

    return render(request, 'users/login.html')



@login_required
def logout_view(request):
    logout(request)
    return redirect('login')



def signup(request):
    #import pdb; pdb.set_trace()

    if request.method == 'POST':
        username = request.POST.get('username')
        password = request.POST.get('password')
        password_confirmation = request.POST.get('password_confirmation')

        if password != password_confirmation:
            return render(request, 'users/signup.html', {'error': 'Password confirmation is incorrect'})
    
        try:
            user = User.objects.create_user(username=username, password=password)   
        except IntegrityError:
            return render(request, 'users/signup.html', {'error': 'Username is already in use'})
        
        user.first_name = request.POST['first_name']
        user.last_name = request.POST['last_name']
        user.email = request.POST['email']
        
        user.save()
        profile = Profile(user=user)
        profile.save()
        #return redirect('login')
        login(request, user)
        return redirect('feed')

    return render(request, 'users/signup.html')
