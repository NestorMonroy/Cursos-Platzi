LIST_NUMBERS = []
SORT_LIST = []

def binary_search(list, number_to_find, low, high):
    if low > high:
        return False

    mid = (low + high) // 2

    if list[mid] == number_to_find:
        return True
    
    elif list[mid] > number_to_find:
        return binary_search(list, number_to_find, low, mid -1 )
    else:
        return binary_search(list, number_to_find, mid + 1, high)
    


def sort_list(list):
    position = 0
    if len(list) > 0:
        min = list[0]
        for idx in range(1, len(list)):
            if list[idx] <=min:
                min = list[idx]
                position = idx
        SORT_LIST.append(min)
        list.pop(position)
        sort_list(list)
    return SORT_LIST


def check_option(option):
    if option == 1:
        number = int(input('Write the number: '))
        LIST_NUMBERS.append(number)
        #run()
    elif option == 2:
        number_to_find = int(input('Write the number to find: '))
        list_search = sort_list(LIST_NUMBERS)
        exist = binary_search(list_search, number_to_find, 0, len(list_search)-1)
        print('The number {} {}  in the list'.format(number_to_find, exist))

    else:
        print('Invalid option, please choose a correct option')
        #run()

if __name__ == "__main__":
    option = int(input('1. Add number\n 2. Search number \n '))
    check_option(option)









# def binary_search(numbers, number_to_find, low, high):

#     if low > high:
#         return False

#     mid = (low + high) // 2

#     if numbers[mid] == number_to_find:
#         return True
    
#     elif numbers[mid] > number_to_find:
#         return binary_search(numbers, number_to_find, low, mid -1 )
#     else:
#         return binary_search(numbers, number_to_find, mid + 1, high)
    


# if __name__ == "__main__":
#     #numbers = [1, 3, 4, 5, 6 ,7, 8, 10,13,25,28,34,39,46,51]
#     numbers = [3 , 9, 1, 22, 42, 99, 7, 1 ]
#     numbers.sort() # Se ordena la lista

#     number_to_find = int(input("Ingresa un numero: "))
#     result = binary_search(numbers, number_to_find, 0, len(numbers) -1)

#     if result is True:
#         print("El numero si esta en la lista")
#     else:
#         print('EL numero no esta en la lista')