def factorial(num):
    print('->', num)
    
    if 0 <= num <= 1:
        print('---\n') # acaba en -> 1 y empiza a calcular los productos
        return 1
    
    else:
        p = num #  cuando p_1 es 1 entonces p es 2
        p_1 = factorial(num-1) #bucle hasta que retorne 1
                                #la funcion factorial es anidada por si misma

        respuesta = p * p_1
        print(p, 'x', p_1, '=', respuesta) #se imprime empezando 2x1=2
        
        
        return respuesta
    

if __name__ == "__main__":
    ans = factorial(6)
    print('\nans', ans)