# def potencia(num):
#     potencia = 1
#     while (potencia <= 10):
#         result = num ** potencia
#         print('Potencia de {} a la {} es {}'.format(num, potencia, result))
#         potencia +=1

# def run():
#     numero = int(input("Escribe el numero al cual quiere saber la potencia: "))
#     potencia(numero)

# if __name__ == "__main__":
#     run()

# contador = 0
# print('2 elevado a ' + str(contador) + 'es igual a :' + str( 2**contador))

# contador = 1
# print('2 elevado a ' + str(contador) + 'es igual a :' + str( 2**contador))


def run():
    LIMITE = 1000000
    contador = 0
    potencia_2 = 2**contador
    while potencia_2 < LIMITE:
        print('2 elevado a {} es igual a {} '.format(contador, potencia_2))
        contador += 1
        potencia_2 = 2 ** contador


if __name__ == "__main__":
    run()
