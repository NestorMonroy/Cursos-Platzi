from django.http import HttpResponse, JsonResponse

from datetime import datetime
import json


def hello(request):

    return HttpResponse('Oh, H! courrent server time is {now} '.format(now=datetime.now().strftime('%b %dth, %Y - %H:%M:%S ')))


def sorted_integers(request):
    """Return  JSON response with sorted integers """
    #import pdb; pdb.set_trace()
    # ?numbers=10,96,50
    numbers = [int(i) for i in request.GET['numbers'].split(',')]
    sorted_ints = sorted(numbers)

    data = {
        'status': 'ok',
        'numbers': sorted_ints,
        'message': 'Ok'
    }

    #response = JsonResponse([sorted_ints], safe=False)
    # print()
    return HttpResponse(
        json.dumps(data, indent=4),
        content_type='application/json'
    )


def say_hi(request, name, age):
    """ Retrun a greeting """
    if age < 12:
        message = f'sorry {name}, you are not allowed here'
    else:
        message = f'Hola {name}'

    return HttpResponse(message)
