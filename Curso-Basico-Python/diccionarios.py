def run():
    mi_diccionario = {
        'llave1': 1,
        'llave2': 2,
        'llave3': 3,
    }
    # print(mi_diccionario['llave1'])
    # print(mi_diccionario['llave2'])
    # print(mi_diccionario['llave3'])

    poblacion_paises ={
        'Argentina': 44_938_712,
        'Brazil': 210_147_125,
        'Colombia': 50_037_424
    }

    # print(poblacion_paises['Argentina'])

    # for i in poblacion_paises.keys():
    #     print(i)

    # for i in poblacion_paises.values():
    #     print(i)

    for a ,b  in poblacion_paises.items():
        print('{} tiene {} habitantes '.format(a,b))
    
if __name__ == "__main__":
    run()