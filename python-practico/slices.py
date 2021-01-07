"""
    Operaciones con strings: Slices en python
    Los slices en Python nos permiten manejar secuencia de una manera poderosa.
    Slices en español significa ““rebanada””, si tenemos una secuencia de elementos y queremos una rebanada tenemos una sintaxis para definir que pedazos queremos de esa secuencia.
	Sigue este orden: secuencia[comienzo:final:pasos]
 
"""

fruit = 'banana'
fruit_slice = fruit[::2]
print ('fruit[::2] = ', fruit_slice)

fruit_slice = fruit[3:3]
print ('fruit[3:3] = ', fruit_slice)

fruit_slice = fruit[:]
print ('fruit[:] = ', fruit_slice)

fruit_slice = fruit[1:-1:2]
print ('fruit[1:-1:2] = ', fruit_slice)


var_string = 'Reconocer'
print ('var_string = ', var_string)
slice_string = var_string[::-1]
print ("var_string[::-1]",slice_string)