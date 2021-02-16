"""
    Un dicionario es silimar a la lista, se puede acceder a travez de indices
    Es una asociacion entre llaves y valores
    Se inicializan con {} o dict()

"""

productos = {}

productos['leche'] = 23.50
productos['carne'] = 50

print(productos)

#formas de ciclar en los dicionarios

for key in productos.keys():
    print(key)


for values in productos.values():
    print(values)


for k, v in productos.items():
    print(k, v)




rae = dict()

rae['pizza'] = 'Comida deliciosa'
rae['pasta'] = 'Comida mas sobrosa de italia'

#aceder a un valor
print(rae['pizza'])

#  con get se puede recuperar algo sin error
a = rae.get('helado', None)
print(a)


for key in rae.keys():
    print(key)


for values in rae.values():
    print(values)

#regresa una tupla
for k, v in rae.items():
    print(k, v)














