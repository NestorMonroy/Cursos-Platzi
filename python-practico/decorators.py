"""
    Funcion que recibe una funcion como parametro y devueve otra funcion como resultado    
"""

PASSWORD = '12345'

def password_required(func):
    def wrapper():
        password = input('Cual es tu contrasena? ')

        if password == PASSWORD:
            return func()
        else:
            print('La contrasena no es correcta')
    
    return wrapper


def upper_name(func):
    
    def wrapper(*args, **kwargs):
        result = func(*args, **kwargs)
        
        return result.upper()

    return wrapper



@password_required
def needs_password():
    print('La contrasena es correcta')


@upper_name
def say_my_name(name):
    return f' Hola, {name} '



if __name__ == '__main__':
    print(say_my_name('Nestor'))
    #needs_password()


