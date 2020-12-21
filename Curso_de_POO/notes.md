La programación orientada a objetos tiene cuatro características principales:

Encapsulamiento. Quiere decir que oculta datos mediante código.
Abstracción. Es como se pueden representar los objetos en modo de código.
Herencia. Es donde una clase nueva se crea a partir de una clase existente.
Polimorfismo. Se refiere a la propiedad por la que es posible enviar mensajes sintácticamente iguales a objetos de tipos distintos.

¿Qué resuelve la Programación Orientada a Objetos?

Codigo muy largo vs programacion estructurada

Huecos que la programación estructurada no resuelve, por lo que la estructuración por objetos surgió como una solución.

Ayuda a leer, depurar y mantener código que puede ser muy largo.
Evita que todo se rompa si algo falla.
Facilita el mantenimiento del código.
Evita generar un código espaguetti. Aquél que tiene demasiadas sentencias de control anidadas.

"Paradigma Orientado a Objetos"
POO o OOP, viene de una manera de pensar llamada “orientación a objetos”.
Surge a partir de los problemas que tenemos y necesitamos plasmar en código.
Observar los problemas en forma de objetos.
Paradigma: Teoría que suministra la base y modelo para resolver problemas.
La OO es un paradigma de programación programación a objetos:
Veremos: Clases, propiedadades, métodos, objetos
Encapsulamiento, Abstracción, Herencia, Polimorfismo

--“Lenguajes Orientados a Objetos”
En POO tenemos los siguientes lenguaje: Java, PHP, Python, JavaScript, C#, Ruby, Kotlin.
-Java:
-Orientado a objetos naturalmente.
-Android.
-Server side.
-Archivos .java
-PHP:
-Lenguaje interpretado.
-Pensado para la web.
-Archivos .php
-Python:
-Diseñado para ser fácil de usar.
-Múltiples usos: Web, Server Side, Análisis de Datos, Machine Learning, etc.
-Archivo .py
-JavaScript:
-Lenguaje interpretado.
-Orientado a Objetos pero basado en prototipos.
-Pensado para la Web.
-Archivos .js

-- “Diagramas de Modelado”
https://es.slideshare.net/still01/aprendiendo-uml-en-24-horas-16815956

Vamos a ver algunos diagramas de modelado:
OMT: Object Modeling Techniques, una vez que tenemos nuestro análisis, nuestros objetos,
atributos, métodos, inclusive objetos con nombres, empecemos a plasmar cada objeto en un
recuadro y pongamos todos los atributos y los métodos y con conectores definamos la relación
que tienen uno con otro.
UML: Unified Modeling Language, es más moderno, tomó las bases de la OMT y generó una mejor versión.

Se pueden realizar los siguientes modelos:
Clases, casos de uso, objetos, actividades, iteración, estados, implementación

Como ya viste UML significa Unified Modeling Language el cual es un lenguaje estándar de modelado de sistemas orientados a objetos.

Esto significa que tendremos una manera gráfica de representar una situación, justo como hemos venido viendo. A continuación te voy a presentar los elementos que puedes utilizar para hacer estas representaciones.

Las clases se representan así:

<div align="center">
<img src="./assets/img/clase.jpg" alt="Clase">
</div>

En la parte superior se colocan los atributos o propiedades, y debajo las opera ciones de la clase. Notarás que el primer caracter con el que empiezan es un símbolo. Este denotará la visibilidad del atributo o método, esto es un término que tiene que ver con Encapsulamiento y veremos más adelante a detalle.

Estos son los niveles de visibilidad que puedes tener:

- private

* public

# protected

~ default

Una forma de representar las relaciones que tendrá un elemento con otro es a través de las flechas en UML, y aquí tenemos varios tipos, estos son los más comunes:

Asociación

<div align="center">
<img src="./assets/img/Asociacion_001.png" alt="associacion">
</div>

Como su nombre lo dice, notarás que cada vez que esté referenciada este tipo de flecha significará que ese elemento contiene al otro en su definición. La flecha apuntará hacia la dependencia.

<div align="center">
<img src="./assets/img/Asociacion_002.png" alt="uml-relacion-asociacion">
</div>

Con esto vemos que la ClaseA está asociada y depende de la ClaseB.
Herencia

<div align="center">
<img src="./assets/img/Herencia_001.png" alt="herencia">
</div>

Siempre que veamos este tipo de flecha se estará expresando la herencia.
La dirección de la flecha irá desde el hijo hasta el padre.

<div align="center">
<img src="./assets/img/Herencia_002.png" alt="herencia-clases">
</div>

Con esto vemos que la ClaseB hereda de la ClaseA

Agregación

<div align="center">
<img src="./assets/img/Agregacion_001.png" alt="agregacion">
</div>

Este se parece a la asociación en que un elemento dependerá del otro, pero en este caso será: Un elemento dependerá de muchos otros. Aquí tomamos como referencia la multiplicidad del elemento. Lo que comúnmente conocerías en Bases de Datos como Relaciones uno a muchos.

<div align="center">
<img src="./assets/img/Agregacion_002.png" alt="uml-relacion-agregacion">
</div>

Con esto decimos que la ClaseA contiene varios elementos de la ClaseB. Estos últimos son comúnmente representados con listas o colecciones de datos.

Composición

<div align="center">
<img src="./assets/img/Composicion_001.png" alt="composicion">
</div>

Este es similar al anterior solo que su relación es totalmente compenetrada de tal modo que conceptualmente una de estas clases no podría vivir si no existiera la otra.

<div align="center">
<img src="./assets/img/Composicion_001.png" alt="uml-relacion-composicion">
</div>

“Objetos”

Objetos: Cuando tengamos un problema lo primero que debemos hacer es identificar objetos.

-Objetos: SIEMPRE son aquellos que tienen propiedades y comportamientos, deben tener un nombre que sean sustantivos, nombre para nombrar ALGO.
-Pueden ser físicos o conceptuales (que físicamente no existen, viven en nuestra mente
o son simbologías de procesos que están ocurriendo).
-Propiedades: También pueden llamarse atributos, serán sustantivos:
nombre, tamaño, forma, estado, etc.
-Comportamientos: Serán todas las operaciones del objeto, suelen ser verbos o sustantivo
y verbo. Ejemplos: login(), logout(),makeReport()

sesion de usuario\_ puede tener comportamientos (Objecto conseptual)

Por cada objecto analizar sus propiedades, sus comportamientos

Clase: Lugar donde especificamos las caracteristicas de nuestro objeto, cuales atributos y comportamientos tendra

Objeto: Se crea a partir de una clase y solo puede hacer lo que esta definido en ella
Abstracción: generar caracteristicas generales de cierta cosa particular, que nos permita crear varios objetos distintos con ciertas caracteristicas en común

ABSTRACCION es cuando sacamos lo mas importante de un objeto osea enfocarnos en lo mas relevante “separar la informacion central de los detalles secundarios”

Modular: Dividir un sistema y así crear módulos independientes, lo que permite evitar un colapso masivo en nuestro código y mejorar la legibilidad.
La modularidad nos permite:
Reutilizar código
Evitar Colapsos
Mantenible
Legibilidad
Resolución Rápida de Problemas

<div align="center">
<img src="./assets/img/modularidad-vs-estructurada.jpg" alt="modularidad">
</div>

-Analisis del problema
1- Necesidad
2- Solicitar
3- Tipos
4- Tomar
-Detectar los objetos

Herencia -> Creacion de nuevas clases apartir de otras
SuperClase -> SubClase

<div align="center">
<img src="./assets/img/diagrama_.png" alt="diagrama">
</div>

Metodo constructor

Dar un estado inicial al objecto
TIene el mismo nombre de la clase
Son los parametros minimos que necesita el objecto para que pueda vivir

<div align="center">
<img src="./assets/img/metodos_constructor.png" alt="metodos_constructor">
</div>

En Java: Palabra clave “<strong>super</strong>” para referirnos al método constructor de la clase padre
En PHP: “<strong>parent::</strong>” seguido de su constructor

php -S localhost:8080 index.php

El Principio de Inyección de Dependencias

El Principio de inyección de dependencia no es más que poder pasar (inyectar) las dependencias cuando sea necesario en lugar de inicializar las dependencias dentro de la clase receptora.
Desacoplar la construcción de sus clases de la construcción de las dependencias de sus clase

Encapsulamiento:

Es hacer que los datos sean inviolables, inalterable o hacer que se esconda, cuando se le asigne un Modificador de Acceso.

Modificadores de Acceso:

Public: Es el mas permisivos de todos, Accede a todo.
Protected: Podrá ser accedido por la clase, paquetes y subclases.
Default: Permite el acceso a nivel de clses de internas y paquetes (No podremos ver las herencias si ha detener (Osea subclases))
Private: Solo podrá ser modificado dentro de la clase.

Se puede encapsular: elementos o atributos, clases o incluso métodos; El encapsulamiento nos permite tener dicho elemento inalterable en la POO.

Public: Todas las Clases.
Protected: En la misma Clase, paquetes, subclases.
Default: En la misma Clase y paquetes internos. (no es accedido a la herencia)
Private: Solo en la misma Clase

Polimorfismo: 
Construir métodos con el mismo nombre pero con comportamiento diferente

El Diagrama UML de Uber 

<div align="center">
<img src="./assets/img/diagrama_UML_uber.png" alt="diagrama_UML_uber">
</div>

En primer lugar notarás que tenemos 3 tipos de flechas:

Asociación

<div align="center">
<img src="./assets/img/Asociacion_003.png" alt="Asociacion_003">
</div>

Como su nombre lo dice, notarás que cada vez que esté referenciada este tipo de flecha significará que ese elemento contiene al otro en su definición. Si recuerdas la clase Car, este contenía una instancia de Driver. La flecha apuntará hacia la dependencia.

<div align="center">
<img src="./assets/img/Asociacion_004.png" alt="Asociacion_004">
</div>

Herencia

<div align="center">
<img src="./assets/img/Herencia_003.png" alt="Herencia_003">
</div>


Siempre que veamos este tipo de flecha se estará expresando la herencia.
En nuestro diagrama tuvimos al menos tres familias conviviendo. La dirección de la flecha irá desde el hijo hasta el padre.

<div align="center">
<img src="./assets/img/Herencia_004.png" alt="Herencia_004">
</div>

<div align="center">
<img src="./assets/img/Herencia_005.png" alt="Herencia_005">
</div>

<div align="center">
<img src="./assets/img/Herencia_006.png" alt="Herencia_006">
</div>

Composición

<div align="center">
<img src="./assets/img/Composicion_003.png" alt="Composicion_003">
</div>

Pasemos a una de nuestras piezas claves, pues notarás en el centro del diagrama la clase Trip que está vinculada a User, Car, Route y Payment. La composición va a significar una asociación entre estas clases con la diferencia de que para que esta clase pueda vivir forzosamente necesita a las demás. Es decir que estas clases son obligatorias para que la clase Trip pueda existir, esta dependencia obligatoria podríamos expresarla en el método constructor de la clase Trip, pues para que un objeto pueda ser creado dependerá de que los demás existan.


<div align="center">
<img src="./assets/img/Composicion_004.png" alt="Composicion_004">
</div>

Esta clase Trip poseerá la lógica más fuerte del negocio aquí será donde se concentrarán la mayor cantidad de clases.

En Resumen ** 
En la POO hay 5 cosas fundamentales:

Clases: Son el molde más genérico y del cual podemos instanciar muchos objetos.

Objetos: Son creados de las clases y tienen datos y funcionalidad.

Atributos: Son las características especificas del objeto (Son las variables dentro del código)

Métodos: Son las funciones o acciones que puede hacer este objeto.

**Instaciar:**Es la creación de un objeto desde una clase a eso se le llama instancia o instancias.

Los pilares de la POO son:

Abstracción: Es separar cada uno de los datos de un objeto para poder crear su molde (clase)

Encapsulamiento: Es aislar un dato para que este sea privado y no pueda ser visto o modificado.

Herencia: Es crear una o más clases a partir de una clase que ya existe. Y se les llaman subclases.

**Polomorfismo:**Es construir  métodos con el mismo nombre pero con comportamiento diferente.
