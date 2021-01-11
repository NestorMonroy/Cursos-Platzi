""" 
    los generators son simplemente una forma rápida de crear iterables sin 
    la necesidad de declarar una clase que implemente el protocolo de iteración. 
    Para crear un generator simplemente declaramos una función y utilizamos el 
    keyword yield en vez de return para regresar el siguiente valor en una iteración.

    return en una funciona termina la funciona mientras que yiel regresa el siguiente valor
"""

def fibonacci(max):
    print(max, '-', '\n')
	
    a, b = 0, 1
    while a < max:
        yield a
        print(a)
        a, b = b, a+b



fib1 = fibonacci(20)
fib_nums = [num for num in fib1]
#print(fib1)
print(fib_nums)
print('*'.center(50,'*'))

double_fib_nums = [num * 2 for num in fib1] # no va a funcionar (no se muestra los valores de fib1), ya que fib1 se utilizo arriba

print(double_fib_nums) #se muestra una lista vacia por que ya no exiten los valores de fib1

double_fib_nums = [num * 2 for num in fibonacci(30)] # sí funciona  ya que se vulve a llamar a fibonacci(x), un un leve cambio que n se multiplicara x 2

print(double_fib_nums) #se muestran los valores recien generados #
