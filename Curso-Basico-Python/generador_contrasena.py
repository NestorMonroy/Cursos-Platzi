import random
import string

def generar_contrasena():
    mayusculas = list(string.ascii_uppercase)
    minuscula = list(string.ascii_lowercase)
    simbolos = list(string.punctuation)
    numeros = list(string.digits)

    caracteres = mayusculas + minuscula + simbolos + numeros

    contrasena = []

    for i in range(15):
        caracter_random = random.choice(caracteres)
        contrasena.append(caracter_random)

    contrasena = ''.join(contrasena)
    return contrasena

def run():
    contrasena = generar_contrasena()
    print('Tu nueva contrasena es{}'.format(contrasena))


if __name__ == "__main__":
    run()
    