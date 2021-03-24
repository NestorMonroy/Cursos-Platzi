¿Para qué nos sirve el archivo .travis.yml?
R = Donde establecemos las configuraciones necesarias para Travis-CI, nuestro sistema de Integración Continua.

¿Qué es Enzyme?
R = Librería para trabajar con pruebas unitarias creada por AirBnb

¿Cuál es el método que nos permite comprobar elementos de un Array?
R = expect([banana, limon, pera]).toContain('banana');

¿Cuál es el comando para instalar Jest?
R = npm install jest --save-dev

¿Cuál es el método que se ejecuta antes de cada prueba?
R = beforeEach(() => console.log('Después de todas las pruebas'))

¿Cuál es el comando en Jest para observar todas las pruebas creadas?
R = jest --watch

Por convención, ¿Cuál es la forma de llamar la carpeta de las pruebas?
R = /__test__/

¿Cuál es el método que se ejecuta después de cada prueba?
R = afterEach(() => console.log('Después de todas las pruebas'));

¿Cuál es el método que nos permite comparar texto dentro un texto?
R = expect('string').toMatch(/rin/);

Para ejecutar una sola prueba, ¿Cuál es el comando?
R = jest <path>/randomStrings.test.js

¿Qué comando utilizamos si queremos regenerar un snapshot?
R = jest --updateSnapshot

¿Cuál es el método con el cual podemos comprobar un boleano?
R = expect(true).toBeTruthy();

¿Cuáles son los comandos que ejecutamos para generar un reporte del alcance de las pruebas?
R = jest --coverage

¿Cuál es el método que nos permite comprobar que un valor es mayor que otro?
R = expect(10).toBeGreaterThan(9);
