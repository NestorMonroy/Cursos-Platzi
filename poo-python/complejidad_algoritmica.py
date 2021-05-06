import time
import sys

def factorial(n):
    respuesta = 1
    
    while n > 1 :
        respuesta *= n
        n -= 1
        
    return respuesta


def factorial_r(n):
    if n == 1:
        return 1
    
    return n * factorial_r(n - 1)



if __name__ == "__main__":
    n = 1000
    sys.setrecursionlimit(n+10)
    comienzo = time.time()
    #print(factorial(n))
    factorial(n)
    final = time.time()
    print(f"Execturion time whit bucle\t{final - comienzo} " )
    
    comienzo = time.time()
    #print(factorial_r(n))
    factorial_r(n)
    final = time.time()
    print(f"Execturion time whit bucle\t{final - comienzo} " )
    
