import random

def generar_contrasena():
    mayusculas = ['A', 'B', 'C', 'D', 'E', 'F']
    minuscula = ['a', 'b', 'c', 'd']
    simbolos = ['!', '$', '&']
    numeros = ['1', '2', '3']

    caracteres = mayusculas + minuscula + simbolos + numeros

    contrasena = []

    for i in range(6):
        caracter_random = random.choice(caracteres)
        contrasena.append(caracter_random)

    contrasena = ''.join(contrasena)
    return contrasena

def run():
    contrasena = generar_contrasena()
    print('Tu nueva contrasena es{}'.format(contrasena))


if __name__ == "__main__":
    run()
    