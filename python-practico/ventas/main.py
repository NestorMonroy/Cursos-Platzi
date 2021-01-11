import sys
clients = 'nestor,joel,'


def _not_found_clients():
    print('Client is not in clients list')



def verify_clients(client_name):
    global clients
    
    if client_name in clients:
        return True
    else:
        return False



def create_client(client_name):
    global clients
    
    if verify_clients(client_name):
        print('Client already is in the client\'s list')
    else:
        clients += client_name
        _add_coma()



def list_clients():
    global clients
    print(clients)


def update_client(client_name):
    
    global clients
    
    if verify_clients(client_name):
        updated_client_name = input('What is the updated client name? ')
        #clients = clients.replace(client_name + ',', update_client)
        clients = clients.replace(client_name, updated_client_name)
    else:
        _not_found_clients()
    
def delete_client(client_name):
    global clients
    
    if verify_clients(client_name):
        clients = clients.replace(client_name + ',', '')
    else:
        _not_found_clients()


def search_client(client_name):
    #split dividir un string en un lista
    clients_lists = clients.split(',')

    for client in clients_lists:
        if client != client_name:
            continue
        else:
            return True


    
def _add_coma():
    global clients
    
    clients += ','


def _print_welcome():
    print('WELCOME TO VENTAS')
    print('*' * 50)
    print('What would you like today? ')
    print('[C]reate client')
    print('[D]elete client')
    print('[U]pdate client')
    print('[D]elete client')
    print('[S]earch client')


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


if __name__ == "__main__":
    _print_welcome()
    
    command = input()
    command = command.upper()
    
    if command == 'C':
        client_name =  _get_client_name()
        create_client(client_name)
        list_clients()
    elif command == 'D' :
        client_name = _get_client_name()
        delete_client(client_name)
        list_clients()
    elif command == 'U':
        client_name = _get_client_name()
        update_client(client_name)
        list_clients()
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
    
