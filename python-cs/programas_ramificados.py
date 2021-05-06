numero1 = int(input('Escribe un numero: '))
numero2 = int(input('Escribe otro numero: '))

if numero1 > numero2:
    print('el numero  {}  mayor que {} '.format(numero1, numero2))
elif numero1 < numero2:
    print('el numero  {}  mayor que {} '.format(numero2, numero1))
else:
    print('los numeros son iguales')