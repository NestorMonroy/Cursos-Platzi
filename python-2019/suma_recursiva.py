
def factorial(number):
    if number == 0:
        return 1
    return number * factorial(number - 1)


def recursive_sum(num1, num2):
    if num1 < num2:
        x = list(range(num1, (num2 + 1)))
        result = 0
        for i in range(len(x)):
            result = result + x[i]
        
        return result

    else:
        x = list(range(num2, (num1 + 1)))

        result = 0
        for i in range(len(x)):
            result = result + x[i]
        
        return result



def run():
    while True:
        option = str(input(''' 
        Indique una opcion
        [s]uma
        [f]actorial
        [x]salir 
        
        '''))

        if option == 's':
            num1 = int(input('Escribe el numero entero en el cual inicia la suma: '))
            num2 = int(input('Escribe el numero entero en el cual finaliza la suma: '))
            
            total = recursive_sum(num1, num2)

            print('La suma recursiva del {} al {} es {} '.format(num1, num2, total)) 

        if option == 'f':
            num = int(input('Escribe el numero entero en el cual iniciar'))
            total = factorial(num)

            print('El factorial de {} es {}'.format(num, total))

        if option == 'x':
            break
        else:
            print('La opcion no es correcta')


if __name__ == "__main__":
    run()