"""
    Las listas son secuencia de valores, pueden tener cualquier valor
    Las listas son mutables, las listas se inician con  [] o list()

"""

countries = ['Mexico', 'Venezuela', 'Colombia']
ages = [12, 18, 24, 35, 50]
#donde viven en memoria
print(id(countries))
print(id(ages))
# a diferencia de los string que si se declaran igual, viven en el mismo espacio en memoria, las listas generan un nuevo id
weight = [12, 18, 24, 35, 50]
print(id(weight))

receta = ['Enselada', 2, 'lechugas', 5]

#reasignar el valor de las listas
countries[0] = 'Ecuador'
print(countries)

global_countries = countries
countries[0] = 'Guatemala'
print(countries)
# se cambian las dos referencias
print(global_countries)


import copy

global_countries = None
global_countries = copy.copy(countries)
countries[0] = 'Guatemala'
print(countries)
print(global_countries)

#ciclos atravez de las listas
for country in countries:
    print(country)

#otra forma de generar una copia de una lista es con ::

lista1 = [1, 2, 3]
copia_lista1 = lista1[::]
lista1[0] = 0
print(lista1, copia_lista1)


#Operaciones con Listas

"""
    El operador + concatena dos o mas listas
    EL operador * repite la misma lista
    El metodo append, permite anadir un elemnto a la lista 
    EL metodo pop => elimina el el ultimo elemento de la lista, se puede asignar con indice pop[2]
    El metodo sort => ordena la lista de menor a mayor
    EL metodo sorted => ordena la lista y genea una nueva instancia
    El metodo del => funciona con slices del a[-1]
    El metodo remove => elimina un elemento sin su indice
"""
#lista de numeros pares de 0 al 100 no inclusivo
a = list(range(0, 100, 2))
print(a)
b = list(range(0, 10))
print(b)

print(a+b)
print(b*2)

fruits = []

fruits.append('apple')
fruits.append('banana')
len(fruits)
fruits.append('kiwi')

some_fruit = fruits.pop()
print(some_fruit)
some_fruit = fruits[0]
print(some_fruit)
del fruits[0]

import random

random_numbers = []

for i in range(10):
    random_numbers.append(random.randint(0,15))


print(random_numbers)

ordered_numbers = sorted(random_numbers)
print(ordered_numbers)
#no modifica la lista inical

random_numbers.sort()
print(random_numbers)
# todos los metodos de la lista 
dir(random_numbers)



