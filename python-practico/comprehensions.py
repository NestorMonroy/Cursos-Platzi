"""
    Estructura que permite generar una secuencia apartir de otras secuencias

    list
        [element fotrr element in element_list if element_meets_condition]
    dictionary
        {key: element for element in element_list if element_meets_condition }
    set 
        {element for element in element_list if element_meets_condition}
"""

lista_de_numeros = list(range(100))

pares = [numero for numero in lista_de_numeros if numero % 2 == 0 ]
print(pares)

student_uid = [1, 2, 3]
students = ['Joel', 'Juan', 'Jose']

#zip regresa un itirador de tuplas
students_with_uid = {uid: student for uid, student in zip(student_uid, students)}

print(students_with_uid)

import random

random_numbers = []

for i in range(10):
    random_numbers.append(random.randint(1, 3))

print(random_numbers)

# se pueden eliminar los repetidos con set comprehension

non_repeated = {number for number in random_numbers}

print(non_repeated)