import sys
import csv
import os

CLIENT_TABLE = '.clients.csv'
CLIENT_SCHEMA = ['name', 'company','email','position']

clients = []

def _initialize_clients_for_storage():
    with open(CLIENT_TABLE, mode='r') as f:
        reader = csv.DictReader(f, fieldnames = CLIENT_SCHEMA)

        for row in reader:
            clients.append(row)


def _save_clients_to_storage():
    tmp_table_name = '{}.tmp'.format(CLIENT_TABLE)
    with open(tmp_table_name, mode='w') as f:
        writer = csv.DictWriter(f, fieldnames = CLIENT_SCHEMA)
        writer.writerows(clients)

        os.remove(CLIENT_TABLE)
        os.rename(tmp_table_name, CLIENT_TABLE)




def _not_found_clients():
    print('Client is not in clients list')


def verify_clients(clients):

    if client in clients:
        return True
    else:
        return False


def create_client(client):
    global clients

    if verify_clients(clients):
        print('*' * 50)
        print('Client already is in the client\'s list')
        print('*' * 50)
    else:
        clients.append(client)



def list_clients():
    print('uid |  name  | company  | email  | position ')
    print('*' * 50)
    # se genera un indice a la lista
    for idx, client in enumerate(clients):
        print('{uid} | {name} | {company} | {email} | {position}'.format(
            uid = idx,
            name = client['name'],
            company = client['company'],
            email = client['email'],
            position = client['position']))


def update_client(client_id, updated_client ):
    
    global clients

    if len(clients) -1 >= client_id:
        clients[client_id] = updated_client
    else:
        _not_found_clients()
    

def delete_client(client_name):
    global clients

    for idx, client in enumerate(clients):
        if idx == client_id:
            del clients[idx] 
            break


def search_client(client_name):
    global clients

    for client in clients:
        if client != client_name:
            continue
        else:
            return True



def _print_welcome():
    print('WELCOME TO VENTAS')
    print('*' * 50)
    print('What would you like today? ')
    print('[C]reate client')
    print('[L]ist clients')
    print('[U]pdate client')
    print('[D]elete client')
    print('[S]earch client')


def buscar_clientes(client_name):
    global clients
    for client in clients:
        if client['name'] != client_name:
            continue
        else:
            return client_name


def _get_client_id(client_name):
    global clients
    for id,client in enumerate(clients):
        if client_name in client['name']:
            return id



def _get_client_field(field_name):
    field = None # variable vacia
    while not field:
        field =input(f'What is the client {field_name} ? ')
    return field


def _get_client_name():
    client_name = None # variable vacia
    while not client_name:
        client_name =input('What is the client name? ').strip()

        if client_name == 'exit':
            client_name = None
            break

    if not client_name:
        sys.exit()

    return client_name


def _get_client_object():
    client = {
            'name': _get_client_field('name'),
            'company': _get_client_field('company'),
            'email': _get_client_field('email'),
            'position': _get_client_field('position')
        }
    return client


if __name__ == "__main__":
    _initialize_clients_for_storage()
    _print_welcome()
    
    command = input()
    command = command.upper()
    
    if command == 'C':
        client = _get_client_object()
        create_client(client)
    
    elif command == 'L':
        list_clients()
    
    elif command == 'D' :
        client_id = int(_get_client_field('id'))
        delete_client(client_id)
        
    elif command == 'U':
        print ('Update client')
        client_id = int(_get_client_field('id'))
        updated_client = _get_client_object()
        update_client(client_id, updated_client)
    elif command == 'S':
        client_name = _get_client_name()
        found = search_client(client_name)

        if found:
            print('The client is in the client\'s list')
        else:
            #print('The client: {} is not in our client\'s list'.format(client_name))
            #A partir de Python 3.6
            print(f'The client: {client_name} is not in our client\'s list')
    else:
        print('Invalid command')
    
    _save_clients_to_storage()
    
