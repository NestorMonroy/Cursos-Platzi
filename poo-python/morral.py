"""

Imagina que eres un ladrón que entra a un museo pero tienes un gran problema, 
nada mas tienes una mochila pero hay muchísimas cosas mas de las que puedes cargar, 
por lo cual debes determinar cuales artículos puedes cargar y te entregaran el mayor valor posible.

Para este problema sabemos que no podemos dividir los artículos, 
por lo que nuestra primera aproximación sera evaluar los artículos.

"""

contador = 0
"""Complejidad algoritmica O(nW) donde n es el numero de elementos y W el tamano del morral"""

def morral(tamano_morral, pesos, valores, n, mensaje):
    print('-' *50)
    print(mensaje)
    global contador
    contador += 1
    
    print(f'   * Analizamos Elemento {n} *')
    print(f'   - Espacio en morral = {tamano_morral}')
    print(f'   - Peso = {pesos[n - 1]}, valor = {valores[n - 1]} ')
    
    
    if n == 0 or tamano_morral == 0:
        if tamano_morral == 0:
            print('   Espacio en morral lleno!')
        elif n == 0:
            print('   Indice final alcanzado!') 
        return 0
    
    if pesos[n - 1] > tamano_morral:
        print('   peso del elemento > espacio morral...')
        return morral(tamano_morral, pesos, valores, n - 1, '')
    
    
    return max(valores[n - 1] + morral(tamano_morral - pesos[n - 1], pesos, valores, n - 1, f'--> SI Robo el elemento {n} y sumo a mi morral {valores[n - 1]} en valor!'),
                morral(tamano_morral, pesos, valores, n - 1, f'--> NO robo el elemento {n}!'))

if __name__ == '__main__':
    valores = [60, 100, 120]
    pesos = [10, 20 ,30]
    tamano_morral = 30

    n = len(valores)

    resultado = morral(tamano_morral, pesos, valores, n, 'Calculo del problema del morall de forma recursiva')
    
    print(f'\n * El metodo se llamo {contador} veces para calcular {n} elementos')
    print(f'El valor maximo que podemos robar es {resultado}')
    print('La complejidad del algoritmo es O(nW) donde n es el numero de elementos y W el tamano del morral')
    
# def morral(tamano_morral, pesos, valores, n):
    
#     if n == 0  or tamano_morral == 0:
#         return 0

#     if pesos[n - 1] > tamano_morral:
#         return morral(tamano_morral, pesos, valores, n-1)
    
#     return max(valores[n -1 ] + morral(tamano_morral - pesos[n-1], pesos, valores, n-1 ), 
#                morral(tamano_morral, pesos, valores, n-1) )

# if __name__ == "__main__":
#     valores = [60, 100, 120]
#     pesos = [10, 20, 30]
#     tamano_morral = 25
#     n = len(valores)
    
#     resultado = morral(tamano_morral, pesos, valores, n)
#     print(resultado)