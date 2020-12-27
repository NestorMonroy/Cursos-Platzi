objetivo = int(input('Escoge un entero: '))
respuesta = 0

while respuesta **2 < objetivo:
    #print(respuesta)
    respuesta += 1
    
if respuesta ** 2 == objetivo:
    print('La raiz de {} es {}'.format(respuesta, objetivo))
else:
    print('El {} no tiene una raiz cuadrada exacta'.format(objetivo))
    