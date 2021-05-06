class CasillaDeVotacion:


    def __init__(self, identificador, pais):
        self._indentificador = identificador
        self._pais = pais
        self._region = None


    # getters
    # utilizamos el decorador @property
    #@property
    def pais(self):
        return self._pais
    
    
    @property
    def region(self):
        return self._region


    # primero hacemos referencia al nombre de la propiedad seguido
    # de .setter (@region.setter)
    @region.setter
    def region(self, region):
        if region in self._pais:
            self._region = region
        else:
            raise ValueError(f'La región {region} no es válida en {self._pais}')


casilla = CasillaDeVotacion(123, ['Ciudad de México', 'Morelos'])
print(casilla.pais())
print(casilla.region)
casilla.region = 'Ciudad de México'
print(casilla.region)