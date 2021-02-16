import collections

"""
    EL modulo collections brinda cojunbto de objetos primitivos que permite extender
    el comportamiento de las built-collections y otorga estrucuras de datos addicionales
"""

#para extender el compotamiento de un diccionario se usa UseDict


class SecretDict(collections.UseDict):

    def _password_is_valid(self, password):
        pass

    def _get_item(self, key):
        pass

    def __getitem__(self, key):
        password, key = key.split(':')

        if self._password_is_valid(password):
            return self._get_item(key)
        
        return None


my_secret_dict = SecretDict()
my_secret_dict['some_password:some_key'] # si el password es valido regresar el valor



#namedtuple => se puede nombrar elementos en vez de utilizar posiciones para aceder a los valores , 
# no se crea una clase ya que uniccamente se necesita un contenedor de valores y no comportamiento

Coffe = collections.NamedTuple('Coffe', ('size', 'bean', 'price'))

def get_coffee(coffee_type):
    if coffee_type == 'houseblend':
        return Coffe('large', 'premium', 10)
