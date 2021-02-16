"""
    Sin igual a las listas, son inmutables 
    Serie de valores separado por , o  con ()
    Se puede inicializar con tuple, regresar mas de un valor 

    Los cojuntos (sets) son una colecion sin order que no se permite elementos duplicados
    los set son mutables
    se inicializa con set
"""

a = (1, 5 , 1, 1, 2, 3)

# se puede acceder por indice

print(a[0])
# marcaria error ya que son inmutables
#a[0] = 10

print(dir(a))

print(a.count(1))
print(a.count(5))


b = set([1, 2 , 3])
c = {3, 4, 5}

print(type(b), type(c))

#no se puede acceder por indice
# marcaria error
#b[0]

b.add(3)
# no se modifica ya que los set no permiten duplicados
print(b)

b.add(20)
print(b)

print(b.intersection(c))

print(b.union(c))

print(b.difference(c))
# se puede eliminar un elemento
b.remove(20)

print("metodos de set", dir(b))