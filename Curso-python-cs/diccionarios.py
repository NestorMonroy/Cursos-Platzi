#
my_dict = {
    'David': 30,
    'Erika': 32,
    'Jaime': 50,
}

my_dict['David']

#regresar un valor que no exista con
my_dict.get('juan', 30)

#reagisnar un valor
my_dict['Jaime'] = 20

my_dict['Pedro'] = 29

del my_dict['Jaime']

for i in my_dict.keys():
    print(i)

for valor in my_dict.values():
    print(valor)    

for llave, valor in my_dict.items():
    print(llave, valor)
    

# Dictionary Comprehension
my_dict = {
    'David': 30,
    'Erika': 32,
    'Jaime': 50,
}

double_age = [i*2 for i in my_dict.values()]
print(double_age)