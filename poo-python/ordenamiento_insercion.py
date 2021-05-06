import random

def ordenamiento_insercion(lista):
    n = len(lista)
    contador = 0
    for i in range(n):
        actual = lista[i]
        idx = i
        
        while idx > 0 and lista[idx - 1] > actual:
            lista[idx] = lista[idx - 1 ]
            idx -= 1
            
            contador +=1
        lista[idx] = actual
        
    print(f'Se necesito {contador} iteraciones \n')
    return lista

if __name__ == "__main__":
    tamano_de_lista = int(input('De que tamano sera la lista? '))
        
    lista = [random.randint(0,100) for i in range(tamano_de_lista)]
    
    print(f'La lista desordenada es: \n{lista}')
    
    lista_ordenada = ordenamiento_insercion(lista)
    print(f'La lista ordenada es: \n{lista_ordenada}')