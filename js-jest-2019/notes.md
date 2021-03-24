¿Cuál es el cliente HTTP para hacer peticiones a recursos de terceros en web y nodejs?
R = Axios

Con este comparador puedes comprobar lo contrario de que espera el resultado:
R = not


Con este parámetro Jest esperará hasta que se llame el callback antes de terminar la prueba:
R = done()

De las siguientes pruebas, ¿Cual tendrá un resultado positivo?

R = test(“test”, () => { expect(2 + 2).toBeLessThanOrEqual(4); });

¿Cuál es el nombre de la carpeta donde debemos guardar nuestras pruebas unitarias?
R = __ test __/

Si queremos comparar el tamaño de un arreglo utilizamos:
R = toHaveLength

Esta función crea un bloque que agrupa diferentes pruebas relacionadas entre ellas en un suite de pruebas:
R = describe()

¿Cuál es la porción de código que debemos añadir al package.js para que jest funcione como un script de npm?
R = “scripts”: {
“test”: “jest”
}

Para comprobar la igualdad de números flotantes utilizamos:
R = toBeCloseTo

Para verificar que un arreglo contenga un elemento particular utilizamos:
R = toContain

¿Cuál es el comando que se usa para ejecutar todas las pruebas (Por defecto)?
R = jest

¿Cuál es el comando que ejecuta sólo las pruebas que se especificaron con un patrón o un nombre de archivo?
R = jest mytest.test.js

Utilizamos esta función para probar cadenas contra expresiones regulares:
R = toMatch(/string/)

Con Jest se puede usar async y await en tests, ¿cuál es la forma correcta de implementarlo?
R = test('Resuelve un Hola', async () => { await expect(Promise.resolve('Hola')).resolves.toBe('Hola'); });

¿Cuál es la función que ejecuta una función después de que se ejecute cada prueba del archivo? Si la función regresa un promise, Jest esperará a que ésta resuelva antes de continuar.
R = afterEach(fn)

¿Cuál es la función que ejecuta una función antes de cada prueba del archivo?. Si la función regresa un promise, Jest esperará a que ésta resuelva antes de continuar.
R = beforeEach

Cuando estás escribiendo tests, a menudo necesitas comprobar que los valores cumplen ciertas condiciones para eso utilizamos esta función.
R = expect(value)

Si queremos actualizar una instantánea previamente creada con nuevos valores utilizamos:
R = jest -u

¿Cuál paquete puedes usar si deseas comprobar y manipular el render de tus componentes?
R = enzyme

¿Cuál es la función que verifica recursivamente cada campo de un objeto o un arreglo?
R = toEqual
