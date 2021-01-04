
"""
Funciones

Existen lenguajes de programación que sólo usan funciones.
Son una agrupación de Statements, que poseen un nombre y realizan una acción o computo.
Los nombres de funciones deben ser descriptivos, se le pueden agregar parámetros (que recibe la función), y estas pueden regresar un valor, que puede ser aprovechado en el resto del programa.
Python tiene una “filosofía” de Batteries included (baterías incluidas) ya que en su librería estándar tiene muchas Built-in functions (funciones incluidas) y módulos que podemos utilizar.

https://docs.python.org/3/library/functions.html

"""
type(1)
#de string a entero
un_entero = int('5')
type(un_entero)

#
a = bool('a')
print(a)

a = float(3)
print(a)


def suma_de_dos_numeros(x, y):
    return x + y

suma_de_dos_numeros(10, 15)

type(suma_de_dos_numeros)

#asignacion
suma_total = suma_de_dos_numeros(10,15)

print(suma_total)
type(suma_total)