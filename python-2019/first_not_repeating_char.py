"""
"abacabad"
"abcabcabc"
"bbbbcyc"
"""

# def first_not_repeating_char(char_sequence):
#     for char in char_sequence:
#         if char_sequence.count(char) == 1:
#             return char

#     return '_'
    


def first_not_repeating_char(char_sequence):
    #crea un diccionario, para posteriormente guardar las letras que son vistas o repetidas
    seen_letters = {}
    
    #iterar por cada secuencia de caracteres, obteniendo un indice y letra 
    for idx, letter in enumerate(char_sequence): 
        if letter not in seen_letters: #verifica que el valor por cada letra en la secuencia inicial no este

            seen_letters[letter] = (idx, 1)  #si es la primera vez que esta, crea una tupla con valores de indicve de la letra y cantidad de veces vista dentro del diccionario con key 
            print("No te he visto")    
            print(seen_letters)
        else:
            seen_letters[letter] = (seen_letters[letter][0], seen_letters[letter][1] + 1) # si no es la primera vez que la ve, crea otra tupla agregando  el valor del indice en el primer ligar y el valor de veces vista en la posicion2 , este valor va aumentado cada vez que ve una palabra repetida
            print("Ya te he visto")    
            print(seen_letters)

    final_letters = [] # esta es la lista donde se guardaran las letras que se repiten una sola vez
    for key, value in seen_letters.items(): #obtiene los valor de key y value dentro del diccionario para verificar el ato de numero de repeticiones, este corresponde al value[1]
        if value[1] == 1:  # si solo se repite la letra una vez
            final_letters.append((key, value[0])) # se agrega a la lista final_letters
    print("final_letters")
    print(final_letters)

    # def sort_order(value):
        # return value[1] # lambda definir una funcion en una linea
    not_repeated_letters = sorted(final_letters, key=lambda value: value[1]) # se usa para ordernar la lista de final_letters de manera ordenada, ya que los datos vienen desordenados desde seen_letters

    print('not_repeated_letters')
    print(not_repeated_letters)

    if not_repeated_letters:  #SI TIENE ALGO REGRESA
        print(not_repeated_letters[0]) 
        return not_repeated_letters[0][0] # retorna la posicion 0 de la lista y la posicion 0 dentro de esa tupla
    else: 
        #si la lista esta vacia 
        return '_'


if __name__ == "__main__":
    char_sequence = str(input('Escribe una secuencia de caracteres: '))

    result = first_not_repeating_char(char_sequence)

    if result == '_':
        print('Todos los caracteres se repite')
    else:
        print('EL primer caracter no repetido es: {}'.format(result))