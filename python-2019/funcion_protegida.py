
def protected(func):

    def wrapper(password):

        if password == 'Nestor':
            return func()
        else:
            print('La contrasena es incorrecta')
    
    return wrapper
        

@protected
def protected_func():
    print('Tu contrasena es correcta')


if __name__ == "__main__":
    password = str(input('Escribe una contrasena: '))

    # wrapper = protected(protected_func)
    # wrapper(password)

    protected_func(password)