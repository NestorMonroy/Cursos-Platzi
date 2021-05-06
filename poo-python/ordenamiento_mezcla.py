import random

def ordenamiento_mezcla(lista): #O(logn) 
    if len(lista) > 1:
        #print(len(lista) , 'lista')
        medio =len(lista) // 2
        izquierda = lista[:medio]
        derecha = lista[medio:]
        print(izquierda, '*' * 5, derecha)
        
        #llamada recursiva en cada  mitad
        ordenamiento_mezcla(izquierda)
        ordenamiento_mezcla(derecha)

        #iteradores para recorrer las dos sublistas
        i=0
        j=0 
        #itertadores para la lista principal
        k=0

        
        while i < len(izquierda) and j < len(derecha):
                    
            #print(i, 'i-1')
            if izquierda[i] < derecha[j]:
                lista[k] = izquierda[i]
                i+=1
                
            else:
                lista[k] = derecha[j]
                j+=1
            
            k += 1
        
        while i < len(izquierda):
            #print(i, 'i-2')
            lista[k] = izquierda[i]
            i+=1
            k+=1
            
        while j < len(derecha):
            #print(j, 'i-3')
            lista[k] = derecha[j]
            j+=1
            k+=1
        print(f'izquierda {izquierda}, derecha {derecha} ')
        print(lista)
        print('-')
    return lista
                

if __name__ == "__main__":
    tamano_de_lista = int(input('De que tamano sera la lista? '))
        
    lista = [random.randint(0,100) for i in range(tamano_de_lista)]
    
    print(f'La lista desordenada es: \n{lista}')
    print('-' * 20)
    
    lista_ordenada = ordenamiento_mezcla(lista)
    print('-' * 20)
    print(f'La lista ordenada es: \n{lista_ordenada}')