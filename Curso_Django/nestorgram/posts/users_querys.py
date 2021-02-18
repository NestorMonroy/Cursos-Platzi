from datetime import date

users = [
    {
        'email': 'cvander@platzi.com',
        'first_name': 'Christian',
        'last_name': 'Van der Henst',
        'password': '1234567',
        'is_admin': True
    },
    {
        'email': 'freddier@platzi.com',
        'first_name': 'Freddy',
        'last_name': 'Vega',
        'password': '987654321'
    },
    {
        'email': 'yesica@platzi.com',
        'first_name': 'Yésica',
        'last_name': 'Cortés',
        'password': 'qwerty',
        'birthdate': date(1990, 12,19)
    },
    {
        'email': 'arturo@platzi.com',
        'first_name': 'Arturo',
        'last_name': 'Martínez',
        'password': 'msicomputer',
        'is_admin': True,
        'birthdate': date(1981, 11, 6),
        'bio': "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
    }
]

#https://docs.djangoproject.com/en/2.0/topics/db/queries/
from posts.models import User

for user in users:
    obj = User(**user)
    obj.save()
    print(obj.pk, ':', obj.email)


#con get solo se trae un objecto
user = User.objects.get(email='freddier@platzi.com')
#con filters mas de un objecto
platzi_users = User.objects.filter(email__endswith='platzi.com')

user = User.objects.all()


for u in platzi_users:
    print(u.email, ':', u.is_admin)


platzi_users = User.objects.filter(email__endswith='platzi.com').update(is_admin =True)

# no se pueda regrese en automatico ya que platzi_user regresa el updated

platzi_users = User.objects.filter(email__endswith='platzi.com')

for u in platzi_users:
    print(u.email, ':', u.is_admin)


"""

ORM: Object-relational mapping. Es el encargado de permitir
el acceso y control de una base de datos relacional a través de
una abstracción a clases y objetos

"""


from django.contrib.auth.models import User
#pbkdf2_sha256$100000$
u = User.objects.create_user(username='nestor', password='admin123')