import csv

class Contact:

    def __init__(self, name, phone, email):
      self.name = name
      self.phone = phone
      self.email = email


class ContactBook:

    def __init__(self):
        self._contacts = []

    def add(self, name, phone, email):
        contact = Contact(name, phone, email)
        self._contacts.append(contact)
        self._save()

    def show_all(self):
        for contact in self._contacts:
            self._print_contact(contact)

    def _print_contact(self, contact):
        print('-- *-- * -- *-- * -- *-- * -- *-- *')
        print('Nombre: {} '.format(contact.name))
        print('Telefono: {} '.format(contact.phone))
        print('Email: {} '.format(contact.email))
        print('-- *-- * -- *-- * -- *-- * -- *-- *')

    def delete(self, name):
        for idx, contact in enumerate(self._contacts):
            if contact.name.lower() == name.lower():
                del self._contacts[idx]
                self._save()
                break
    
    def search(self, name):
        for contact in self._contacts:
            if contact.name.lower() == name.lower():
                self._print_contact(contact)
                break
        else:
            self._not_found()

    def update(self, name):
        for idx, contact in enumerate(self._contacts):
            if contact.name.lower() == name.lower():
                parameter = str(input(
                    '''
                    Que dato desea actualizar?

                    [n]ombre
                    [t]elefono
                    [e]mail
                    [to]dos

                    '''))
                if parameter == 'n':
                    name_ = str(input('Ingrese un nuevo nombre: '))
                    del self._contacts[idx].name
                    self._contacts[idx].name = name_
                    print('Actualización exitosa')
                    break
                if parameter == 't':
                    phone_ = str(input('Ingrese un nuevo telefono: '))
                    del self._contacts[idx].phone
                    self._contacts[idx].phone = phone_
                    print('Actualización exitosa')
                    break
                if parameter == 'e':
                    email_ = str(input('Ingrese un nuevo email: '))
                    del self._contacts[idx].email
                    self._contacts[idx].email = email_
                    print('Actualización exitosa')
                    break
                if parameter == 'to':
                    name_ = str(input('Ingrese un nuevo nombre: '))
                    phone_ = str(input('Ingrese un nuevo telefono: '))
                    email_ = str(input('Ingrese un nuevo email: '))
                    del self._contacts[idx].name
                    del self._contacts[idx].phone
                    del self._contacts[idx].email
                    self._contacts[idx].name = name_
                    self._contacts[idx].phone = phone_
                    self._contacts[idx].email = email_
                    print('Usuario actualizado existosamente ')

                else:
                    print('Comando no encontrado')
                    break

                self._save()
        else:
            self._not_found()
    
    def _not_found(self):
        print('********')
        print('No encontrado')
        print('********')

    def _save(self):
        with open('contacts.csv', 'r+') as f:
            writer = csv.writer(f, lineterminator='\r')
            writer.writerow(('name', 'phone', 'email'))

            for contact in self._contacts:
                writer.writerow((contact.name, contact.phone, contact.email))


def run():
    contact_book = ContactBook()

    with open('contacts.csv', 'r') as f:
        reader = csv.reader(f)
        for idx, row in enumerate(reader):
            if idx == 0:
                continue
            
            contact_book.add(row[0], row[1], row[2])


    while True:
        command = str(input(
            '''
            Que desea hacer?
            [a]ñadir contacto
            [ac]tualizar contacto
            [b]uscar contacto
            [e]liminar contacto
            [l]istar contactos
            [s]alir

            '''))
        
        if command == 'a':
            name = str(input('Escribe el nombre del contacto: '))
            phone = str(input('Escribe el telefono del contacto: '))
            email = str(input('Escribe el email del contacto: '))

            contact_book.add(name, phone, email)

        elif command == 'ac':
            name = str(input('Escribe el nombre del contacto que desea actualizar: '))
            contact_book.update(name)

        elif command == 'b':
            name = str(input('Escribe el nombre del contacto que desea buscar: '))
            contact_book.search(name)

        elif command == 'e':
            name = str(input('Escribe el nombre del contacto que desea eliminar: '))
            contact_book.delete(name)

        elif command == 'l':
            contact_book.show_all()

        elif command == 's':
            break
        else:
            print('Comando no encontrado')


if __name__ == "__main__":
    run()