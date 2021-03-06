""" Django models utilities """
from django.db import models


class CRideModel(models.Model):
    """  Comparte Ride base model 

        CRideModel acts as an abstract base class from witch every
        other model in the project willl inherit. This class provides
        every table with the following atributes:
            + created  (DateTime): store the datetime the object was created
            + modified (DateTime): Storre the last datetime the object was modified
    """

    created = models.DateTimeField(
        'created att',
        auto_now_add=True,
        help_text='Date time on which the object was created.'

    )

    modified = models.DateTimeField(
        'modified att',
        auto_now_add=True,
        help_text='Date time on which the object was modified.'

    )

    class Meta:
        """Meta option."""

        abstract = True

        get_latest_by = 'created'
        ordering = ['-created', '-modified']


"""
Ejemplo de clase proxi

class Person(models.Model):
    fist_name = models.ChardField()
    last_name = models.ChardField()



class MyPerson(Person):
    class Meta:
        proxy = True

    def say_hello(name):
        pass



MyPerson.objects.all()
nestor = MyPerson.objects.get(pk=1)
nestor.say_hello('Joel') => esto es posible ya que agrega la funcionalidad


rulo = Person.objects.get(pk=2)
rulo.say_hello('Joel') => no es posible ya que say_hello solo vive dentro de MyPerson

https://coffeebytes.dev/herencia-en-modelos-de-django/

"""
