""" Django models utilities """
from django.db import models


class CrideModel(models.Model):
    """  Comparte Ride base model 

        CrideModel acts as an abstract base class from witch every
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
