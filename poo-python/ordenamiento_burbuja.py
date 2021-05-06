import random

def ordenamiento_burbuja(lista):
    n = len(lista)
    contador = 0
    for i in range(n):
        for j in range(0, n - i - 1): # O(n) * O(n) = O(n * n) = O(n**2)
            if lista[j] > lista[j + 1]:
                lista[j], lista[j + 1] = lista[j + 1], lista[j]
            contador +=1
    print(f'Se necesito {contador} iteraciones \n')
    return lista

if __name__ == "__main__":
    tamano_de_lista = int(input('De que tamano sera la lista? '))
        
    lista = [random.randint(0,100) for i in range(tamano_de_lista)]
    
    print(f'La lista desordenada es: \n{lista}')
    
    lista_ordenada = ordenamiento_burbuja(lista)
    print(f'La lista ordenada es: \n{lista_ordenada}')