"""
    Buscar un elemento en una lista ordenada
"""
import random

def binary_search(data, target):
    low, high = 0, len(data)-1

    while low <= high:
        mid = (low + high) // 2 
        if target == data[mid]:
            return True
        else:
            if target < data[mid]:
                high = mid - 1
            else:
                low = mid + 1
    
    return False


# def binary_search(data, target):
#    low, high = 0, len(data)-1
#     # si el numero menor es mayor que el que buscamos
#     if low > high:
#         return False

#     mid = (low + high) // 2  #=> divicion de enteros

#     if target == data[mid]:
#         return True
    
#     elif target < data[mid]:
#         return binary_search(data, target, low, mid -1)
#     else:
#         # es numero es mas grande del que nos dio el indice a la mitad
#         return binary_search(data, target, mid + 1 , high)


if __name__ == '__main__':
    data = [random.randint(0, 100) for i in range(10)]
    data.sort()  # sort() => modifica el mismo arreglo 
    #sorted_data = sorted(data) # sorted => regresa un nuevo arreglo sin modificar el primero

    print(data)
    target = int(input('What number would you like to find? '))
    found = binary_search(data, target )

    print(found)

