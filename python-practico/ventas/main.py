
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


def _get_client_name():
    return input('What is the client name? ')

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
    else:
        print('Invalid command')
    
