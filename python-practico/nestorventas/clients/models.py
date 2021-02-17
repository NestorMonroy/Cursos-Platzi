import uuid


class Client:

    def __init__(self, name, company, email, position, uid=None):
        self.name = name
        self.company = company
        self.email = email
        self.position = position
        self.uid = uid or uuid.uuid4()

    
    def to_dict(self):
        # la funcion vars , permite acceder a una representation de dictionario
        return vars(self)

    
    @staticmethod #metodo estatico, se puede ejecutar sin la necesidad de una instancia de clase
    def schema():
        return ['name', 'company', 'email', 'position', 'uid']