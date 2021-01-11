"""
    while loops nos sirve para iterar mientras una condición sea verdadera.

"""

def cuenta_regresiva(n):
    while n > 0:
        print(n)
        n-=1

cuenta_regresiva(10)


def cuenta_regresiva_bug(n):
    while n > 0:
        print(n)
        n+=1

#cuenta_regresiva_bug(10)


