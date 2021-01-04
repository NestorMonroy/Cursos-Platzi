country = 'Mexico'
print(country)
print(len(country))
print(country[0])
print(country[-1])

second_letter = country[1]
print(second_letter)
print(id(second_letter))

other_var = 'e'

print(id(other_var))




country_2 = 'Colombia'
print(country_2)
print(id(country_2))
country_2 += 's'
# si me modifica un caracter el objecto en memoria cambia

print(country_2)
print(id(country_2))