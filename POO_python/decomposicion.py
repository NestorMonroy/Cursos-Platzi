

class Automovil:
    
    def __init__(self, modelo, marca, color):
        self.modelo = modelo
        self.marca = marca
        self.color = color
        self._estado = 'en reposo'
        self._motor = Motor(cilindros=4)
    
    def acelear(self, tipo='despacio'):
        if tipo == 'rapida':
            self._motor.inyecta_gasolina(10)
        else:
            self._motor.inyecta_gasolina(3)
        
        self._estado = 'en_movimiento'
        
    def frenar(self):
        self._motor.inyecta_gasolina(0)
        self._estado = 'en_reposo'

class Motor:
    # Con el constructor definimos sus características.
    def __init__(self, cilindros, tipo='gasolina'):
        self.cilindros = cilindros
        self.tipo = tipo
        self._temperatura = 0
        
    def inyecta_gasolina(self, cantidad):
        pass
    
        