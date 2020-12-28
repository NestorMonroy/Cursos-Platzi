def factorial(n):
    print(n)
    if n == 1:
        return 1
    
    return n * factorial(n-1)

n = int(input('Escribe un numero: '))

print(factorial(n))