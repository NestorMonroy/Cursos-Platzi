### Programación funcional

¿Qué es la programación funcional?
La programación funcional es una forma de programar, un estilo de programación. Es un estilo más enfocado a tener casos específicos en el cual nos preocupamos en qué resolver.
En Java veremos dos cosas:
Funciones
Datos

Básicamente la programación funcional se enfoca en qué resolver, no en cómo resolverlo.
Lo importante es tener una función que pueda resolver el problema, no importa su procedencia.
En la parte de los datos vamos a aprender que son los datos mutables e inmutables. Esto es muy importante porque nos va a diferentes tipos de funciones según los datos que tengamos.

Beneficios de la programación funcional

* Legibilidad: Vamos a estar enfocados en qué resolver es decir, nuestras funciones van a ser más explícitas en cuanto a qué es lo que hacen, no en cómo lo hacen.
* Testing: Va a ser más fácil hacer pruebas porque, al tener nuestras funciones separadas resolviendo pequeños problemas, es más fácil hacer una prueba de una sola función que tener que resolver todo el sistema.
* Concurrencia: Más fácil y didáctica porque podemos liberar muchos procesos simultaneos a partir de la misma función. No necesitamos tener control de los objetos que existen en memoria porque tenemos funciones únicas.
* Comportamientos más definidos: Estos comportamientos van a estar dados por funciones simples y vamos a poder leerlas rápidamente y entender qué es lo que hacen.
* Manejos de estados: Vamos a tener un menor manejo de estados. No vamos a preocuparnos por qué objeto tiene el dato en el momento que estamos funcionando sino que, nos vamos a enfocar más en simplemente si “tenemos el dato o no tenemos el dato”.

## ¿Qué es una función?

Una función es un tipo de dato que puede operar sobre una dato x y genera un valor y.
Igualmente, por cada x siempre genera una y. También es:

Serie de pasos parametrizados

Puede o no devolver un resultado

Se puede definir, almacenar o declarar bajo demanda (cómo cualquier otro tipo)

Podemos definir funciones con respecto a otras funciones (recursividad)

Podemos definir funciones que tomen a otras funciones como parámetros


Los de ciudadanos de primera clase, en realidad hablamos de algo que dentro del lenguaje de programación es usable y operable.

En el caso de Java tenemos por ejemplo:

* Tipos de dato primitivos
* Clases
* Objetos
* Interfaces
* Tipos Genericos
* Anotaciones
* Arreglos

Todos ellos son ejemplos de ciudadano de primera clase.


### Funciones puras


* Función pura: determinista (resultado predecible). Fácil de probar. Su resultado será siempre el mismo al recibir siempre los mismos parámetros. No dependen del contexto, siempre generará el mismo resultado y no generará efectos secundarios, es decir no afectará datos de entrada ni otros datos relativos a otros flujos de datos. No dependen del estado del sistema.

* Función impura: no determinista. Dependen del estado del sistema. Dependen de su contexto. Pueden generar efectos secundarios, es decir, pueden afectar a otros flujos de datos o verse afectadas por otros flujos de datos subyacentes. No son predecibles.

Una función pura puede invocar a una función pura, pero no a una impura. Si una función pura invoca a una impura se transformará entonces en una función impura ya que la naturaleza de la impura hará impredecible el resultado de la función pura, ya sea por resultado o por los efectos secundarios y contexto que impliquen la función pura.


### Entendiendo los efectos secundarios

Un efecto secundario es todo cambio observable desde fuera del sistema es un efecto secundario. Los efectos secundarios son inevitables (porque terminan siendo necesarios), algunos ejemplos son:

* CRUD sobre archivos
* CRUD sobre una base de datos
* Enviar/Recibir una llamada de red
* Alterar un objeto/variable usada por otras funciones.

Sin embargo, se deben reducir los efectos secundarios, porque ayuda a tener una mejor estructura del código (favoreciendo la generación de funciones puras, la modularidad y la testeabilidad).


### Funciones de orden mayor


Una función de orden mayor cumple al menos con una de estas características:
Toma otra función como parámetro
Retorna una función como resultado.
Funcion que resive una funcion y un json, y retorna otro json modificado

-Toma otra funciona como parámetro.
-Retorna una función después de su ejecución.

Ventajas:

* Pasar comportamiento
* Compartir un medio de comunicación (callbacks)
* Compartir lógica/reglas

### Funciones lambda

Función = Tiene un nombre.
Lambda = Función que no tiene un nombre.

Por qué usar lambdas?
Es un comportamiento único.
Es una regla que solo se requiere en un lugar.
Es una función muy simple (1 línea).

### Inmutabilidad

Inmutabilidad

Un objeto inmutable es aquel cuyo estado no se puede cambiar una vez construído.
Ventajas :
* Una vez creado no se puede alterar.
* Facilidad para crear funciones puras.
* Facilidad para usar threads/concurrencia.
Desventajas :
* Cuando se necesecite alterar un datos, se requiere crear una nueva instancia por cada set modificado.
* Requiere especial atención al diseño.
* Los objetos mutables están fuera de nuestro alcance, porque se vuelven inpredecibles.

### Revisando el paquete java.util.function: Function

El tipo de Function en Java es una Interfaz y lo que estamos haciendo son clases anonimas.

La interfaz Predicate te ayuda con las validaciones de objetos complejos, para algunos datos ya definidos en el lenguaje, existen sus equivalentes

```java


import java.util.function.Function;
import java.util.function.Predicate;

public class MathFunctions {
    public static void main(String[] args) {
        Function<Integer, Integer> squareFunction = new 
        
        Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };
        System.out.println(squareFunction.apply(5));
        System.out.println(squareFunction.apply(25));
        System.out.println(square(5));
    }

    static int square(int x) {
        return x * x;
    }
}
```


### Revisando el paquete java.util.function: Predicate

Un Predicado es un interface funcional que define una condición que un objeto determinado debe cumplir. 

Con los predicados se pueden generar validaciones rapidas o sobre las mismas funciones que ya tenemos, nos beneficia al momento de estar filtrando elementos o corroborando que algo tenga datos


```java

import java.util.function.Function;
import java.util.function.Predicate;

public class MathFunctions {
    public static void main(String[] args) {
        //Definición de funcion mas simple, sin utilizar un operador @Override
        Function<Integer, Boolean> isOdd = x -> x % 2 == 1;

        //Predicate -> Trabaja sobre un tipo y regresa un bolean
        Predicate<Integer> isEven = x -> x % 2 == 0;
        isEven.test(4); //  con .test revisamos el resultado

        Predicate<Student> isApproved = student -> student.getCalificacion() >= 6.0;
        Student nestor = new Student(5);
        
        System.out.println(isApproved.test(nestor));

    }

    static class Student {
        private double calificacion;
        Student(double calificacion) {
            this.calificacion = calificacion;
        }
        public double getCalificacion() {
            return calificacion;
        }
    }
}

```

### Revisando el paquete java.util.function: Consumer y Supplier

* Consumer -> Consumido
* Supplier -> Proveedor

Consumer es una Interfaz genérica, función que tiene como 1 solo parámetro.
Tiene como método: accept

Supplier es otra interfaz genérica, función que que encarga de generar datos, proveer datos. 1 solo parámetro.

Tiene como método get.


Entonces, puedes ver que un Consumer se encarga de “consumir” los datos que le pases.

```
Consumer<Student> saveProgressInDataBase = student -> db.updateStudent(student);

Supplier<String> randomPasswordGenerator = () -> complexAlgorithm.generate() ;
```

Puedes tambien tener en cuenta que el Consumer de alguien que RECIBE datos y el Supplier es alguien que SUMINISTRA datos

### Revisando el paquete java.util.function: Operators y BiFunction

Estas funciones extienden de Function. Quiere decir que tienen el método apply.

UnaryOPerator --> Solo se especifica un solo tipo de dato. Se entiende que tendrá como resultado el mismo tipo.

BinaryOperator --> Solo se especifica un tipo de dato. Se entiende que tendrá 2 parámetros de entrada y el uno de retorno del mismo tipo de dato.

Bifunction --> 2 parámetros de entrada, se tiene que especificar el tipo de dato. Puede tener diferentes tipos de entradas como también diferente tipo de salida.


```java

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class StringFunctions {
    public static void main(String[] args) {
        //UnaryOperator: Function, donde la entrada y la salida son del mismo tipo.
        UnaryOperator<String> quote = text -> "\"" + text + "\"";
        UnaryOperator<String> addMark = text -> text + "!";

        System.out.println(quote.apply("Hola nestor")); // "Hola nestor"
        System.out.println(addMark.apply("Hola")); // Hola!
        
        //BinaryOperator: recibe un tipo y los el resultado es del mismo tipo

        BinaryOperator<Integer> multiplicacion = (x, y) -> x * y;
        System.out.println(multiplicacion.apply(5, 1));

        // BiFunction: Tipo de Function que recibe dos tipos de dato y regresa otro tipo de dato

        //BiFunction<Integer, Integer, Integer> multiplicacion = (x,y) -> x*y;

        BiFunction<String, Integer, String> leftPad =
                (text, number) -> String.format("%" + number + "s", text);

        System.out.println(leftPad.apply("Nestor", 5));

        List<>

    }
}

```


### Entendiendo dos jugadores clave: SAM y FunctionalInterface

SAM --> Single Abstrab Method, Es una interfaz que tiene un solo método sin definir. Para ello decoramos con @FuctionalInterface. Nos permite crear nuestras propias funciones.

```java
import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public class AgeUtils {
    public static void main(String[] args) {
        Function<Integer, String> addCeros = x -> x < 10 ? "0" + x : String.valueOf(x);

        TriFunction<Integer, Integer, Integer, LocalDate> parseDate =
                (day, month, year) -> LocalDate.parse(year + "-" + addCeros.apply(month) + "-" + addCeros.apply(day));

        TriFunction<Integer, Integer, Integer, Integer> calculateAge =
                (day, month, year) -> Period.between(parseDate.apply(day, month, year), LocalDate.now()).getDays();

        System.out.println(calculateAge.apply(10,10,1990));
    }


    //SAM: Single Abstrab Method, Es una interfaz que tiene un solo método sin definir.
    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }
}

```

### Operador de Referencia

Con el operador de referencia vamos a poder llamar métodos de otras clases ya establecidos en la aplicación de una forma más sencilla siempre y cuando cumpla las condiciones donde lo vayamos a utilizar.

```java

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class NombresUtils {
    public static void main(String[] args) {
        List<String> profesores = getList("Nestor", "Luis", "Joel");

        Consumer<String> printer = text -> System.out.println(text);
        profesores.forEach(printer);

        System.out.println("*****");

        /*
        
        Poder referenciar un método, los métodos también son funciones, estan liagadas a una clase
        EL metodo debe de cumplir con las mismas caracteriticas que la funcion que deberiamos escribir.
        Deben de cumplorar con la misma cantidad y tipo de parametros
        para poder generar el mismo resultado 

        (::)
        */
        profesores.forEach(System.out::println);

    }
    static<T> List<T> getList(T... elements){
        return Arrays.asList(elements);
    }
}

```

### Analizando la inferencia de tipos

La inferencia de tipo, es cuando java se encarga de validar que los datos que estan pasando atravez de la funcion, sea del tipo que corresponde. "Infiere" el tipo de dato.


```java
public class Inference {
    public static void main(String[] args) {
        Function<Integer, String> funcionConvertidora =
                integer -> "Al doble " + (integer * 2);

        List<String> alumnos = NombresUtils.getList("Paco", "Luis", "Nestor");
        alumnos.forEach((String name) -> System.out.println(name));
        alumnos.forEach(name -> System.out.println(name));
        alumnos.forEach(System.out::println);

    }
}
```

### Comprendiendo la sintaxis de las funciones lambda

Sintaxis de lambdas

Si la lambda NO recibe argumentos:
( ) -> operación

Si la lambda recibe 1 argumento:
_argumento -> operación
( argumento ) -> operación_

Si la lambda recibe mas de 1 argumento:
( argumento1, argumento2) -> operación

Si la lambda recibe varias operaciones:
( ) -> { operacion1; return operación2; }
argumento -> { operacion1; return operacion2; }
( argumento ) -> { operacion1; return operacion2; }
( argumento1, argumento2) -> { operacion1; return operacion2 }

Si la lambda tiene mas de una operación debemos retornar un valor mediante.
return

Pero si NO devuelve nada, solo hay que indicar el tipo de entrada vacío.

( ) -> { operación }

Para evitar errores es mejor usar
( ) -> { operación }
para cualquier caso


### Usando metodos default en nuestras interfaces

Default en una interfaz nos permitirá implementar un método. Es una keyword que permite añadir un comportamiento por defecto a la interfaz.

@FunctionalInterface, esta anotación nos permite contar con método sin definir y también método default.


### Chaining

Cuando hablamos de chaining o en español encadenamiento es hacer consecutivas las llamadas a diferentes metodos de diferentes resultados.

Por ejemplo si yo tengo una clase con un metodo que me retorna una lista:

```java
class Example{
    public List<String> getList(){ … }
}

//Se que puedo hacer algo como:

Example example = new Example();
List<String> myList = example.getList();
String firstString = myList.get(0);
String largeString = firstString.concat("…");

//Porque cada metodo devuelve un dato, pero tambien esto es valido:

new Example().getList().get(0).concat("…");
```
Porque los resultados intermedios no son de mi interes. Estoy aplicando unicamente el concepto de chaining entre los resultados de cada metodo.

Cuando hablamos de el patron de diseñoBuilder estamos hablando de una clase en concreto que esta encargada de generar otra clase. Lo utilizas comunmente porque la clase que necesitas es “compleja” de construir y porque podria ser que durante la creacion puedas tener accidentes no contemplados, por ejemplo:

```java
class PanBuilder{
    public PanBuilder conHuevos(int cantidadDeHuevos){…}

    public PanBuilder conHarina(float gramosHarina){…}

    public PanBuilder conSal(short sal){…}

    public PanBuilder conLeche(float mililitrosLeche){…}
    
    public PanBuilder conLevadura(float gramosLevadura){…}
    
    public PanBuilder conAgua(float mililitrosAgua){…}
    
    public Pan build(){…}
}
```
La clase PanBuilder se encarga del proceso de mezclar ingredientes para cuando tu decidas crear un Pan.

Existe otro patron de diseño que se llama Chain of Responsability cuya función es totalmente diferente a lo que buscamos.

Chain of Responsability hace que un grupo de objetos de un cierto tipo se deleguen una operación hasta que todos los objetos que puedan estar involucrados en la operación han sido llamados, por ejemplo:

En un cajero automatico, tienes un grupo de Repartidores de billetes que se encargan de entregar los billetes que corresponda y pasar el sobrante al siguiente Repartidor de billetes.

Algo asi:
```java
abstract class RepartidorBilletes{
    private RepartidorBilletes siguienteEnCadena;

    abstractvoidagregarBilletes(int cantidadPendiente);

    public RepartidorBilletes siguienteEnCadena(RepartidorBilletes repartidorBilletes){
        this.siguienteEnCadena = repartidorBilletes;
        return repartidorBilletes;
    }

    protectedvoidrepartirSiguiente(int cantidadPendiente){
        if(siguienteEnCadena != null){
            siguienteEnCadena.agregarBilletes(cantidadPendiente);
        }
    }
}

class RepartidorBilletes20 extends RepartidorBilletes{
    @Override
    voidagregarBilletes(int cantidadPendiente){
        int cantidadDeBilletes = …;
        int totalADescontar = …;
        int nuevaCantidadPendiente = cantidadPendiente - totalADescontar;
        
        getCajeroATM().entregarBilletes(cantidadDeBilletes, 20);
        
        repartirSiguiente(nuevaCantidadPendiente);
    }
}
```

podrias despues hacer una clase que sea tambien RepartidorBilletes50 que se encargue de repartir billetes de 50… etc. El chiste es que en un Chain of Responsability cada objeto se encarga de mandar a llamar al siguiente objeto en la cadena y pasarle datos para operar. Puedes leer mas aca: https://refactoring.guru/design-patterns/chain-of-responsibility

### Entendiendo la composición de funciones

-compose: Permite agregar pasos antes de la ejecución de una función( La lambda se ejecuta antes de la función que llama a compose)

-andThen: Permite agregar pasos después de la ejecución de una función( La lambda se ejecuta después de la función que llama a andThen)

Al recibir una funcion, nosotros podemos genenerar nuevas funciones de procedencia o que puedan ejecutar otros pasos adicionales antes de ejecutarse a si mismas **

Se crean funciones mas complejas ** Generar la conexion antes de hacer una consulta de nuestro lado.

```java
import java.util.function.Function;

public class MatOperations2 {
    public static void main(String[] args) {
        Function<Integer, Integer> multipleBy3
                = x -> {
            System.out.println("Multiplicando x: "+ x + " por 3.");
            return x * 3;
        };

        Function<Integer, Integer> add1MultipleBy3
                /*Se genera una funcion intermedia a travez de compose,
                compose, toma una funcion, ejecuta primero esa funcion, y
                posterior ejecuta la funcion que se  mando a llamar.
                **Funcion compuesta basada en dos funciones **
                * */
                = multipleBy3.compose(y -> {
            System.out.println("Le agregare 1 a: " + y);
            return y + 1;
        });

        Function<Integer, Integer> andSquare =
                /* Se toma una funcion y una vez ejecutado eso con .andThen
                 ejecuta una nueva funcion
                */
                add1MultipleBy3.andThen(x -> {
                    System.out.println("Estoy elevando " + x + " al cuadrado");
                    return x * x;
                });
        System.out.println(
                add1MultipleBy3.apply(5)
        );

        System.out.println(
                andSquare.apply(3)
        );
    }

}
```


### La clase Optional

Apartir de java 8, se evita existencias con valores inexistentes esdecir NullPointerException 

Apartir de diferentes tipos de instancias, no tengas que preocuparte
por el valor de retorno.

Diferentes tipos de defaul 

Optional.empty(): Cuando no encontremos casos
Optional.ofNullable(): Desconocemos el valor de una variable

La clase Optional es una manera de almacernar un dato, el cual no tenemos certeza si esta o no presente.

Vale la pena recordar que Opcional se debe usar para información que se retorna, en lugar de información que se recibe (a través de parámetros, por ejemplo). 

Tu codigo debería usar unicamente Optional como resultado de una función, nunca como entrada.


### Streams

¿Que son los Streams?

Los Stream se utilizan para procesar colecciones de objetos. Una secuencia es una secuencia de objetos que admite varios métodos que se pueden canalizar para producir el resultado deseado.

Un Stream es auto iterable -> Cuanndo se crea una lista, se puede decir la operacion que se hace a la lista 

Las características de la secuencia de Java son:

* Un flujo no es una estructura de datos, sino que toma información de las colecciones.
* Los flujos no cambian la estructura de datos original, solo proporcionan el resultado según los métodos canalizados.
* Cada operación intermedia se ejecuta de forma perezosa y devuelve un flujo como resultado, por lo que se pueden canalizar varias operaciones intermedias. Las operaciones de terminal marcan el final de la secuencia y devuelven el resultado.


### Stream listeners

Operaciones intermedias:
```java

/*map: El método de map se utiliza para devolver una secuencia que consta de los resultados de aplicar la función dada a los elementos de esta secuencia.
*/

List number = Arrays.asList(2,3,4,5); List square = number.stream().map(x->x*x).collect(Collectors.toList());

/*filter: El metodo filter se utiliza para seleccionar elementos según el predicado pasado como argumento.
*/

List names = Arrays.asList("Reflection","Collection","Stream"); List result = names.stream().filter(s ->s.startsWith("S")).collect(Collectors.toList());

/* sorted: El método sorted method se utiliza para ordenar la secuencia.*/

List names = Arrays.asList("Reflection","Collection","Stream"); List result = names.stream().sorted().collect(Collectors.toList());
```


Operaciones de la terminal:

```java

/* collect: El método method se utiliza para devolver el resultado de las operaciones intermedias realizadas en la secuencia.*/

List number = Arrays.asList(2,3,4,5,3); Set square = number.stream().map(x->x*x).collect(Collectors.toSet());

// forEach: El método forEach se utiliza para iterar a través de cada elemento de la secuencia.

List number = Arrays.asList(2,3,4,5); number.stream().map(x->x*x).forEach(y->System.out.println(y));

//reduce: El método reduce se utiliza para reducir los elementos de una secuencia a un solo valor. El método reduce toma un BinaryOperator como parámetro.

List number = Arrays.asList(2,3,4,5); int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);

```

### Operaciones y Collectors

Java 8 Funcional: Operaciones y Collectors

Lambdas, operaciones y retornos

Usando Stream nos podemos simplificar algunas operaciones, como es el filtrado, el mapeo, conversiones y más. Sin embargo, no es del todo claro cuándo una operación nos devuelve otro Stream para trabajar y cuándo nos da un resultado final…

¡O al menos no era claro hasta ahora!

Cuando hablamos de pasar lambdas a una operación de Stream, en realidad, estamos delegando a Java la creación de un objecto basado en una interfaz.

Por ejemplo:

```java
Stream<String> coursesStream = Utils.getListOf("Java", "Node.js", "Kotlin").stream();

Stream<String> javaCoursesStream = coursesStream.filter(course -> course.contains("Java"));


// En realidad, es lo mismo que:

Stream<String> explicitOperationStream = coursesStream.filter(new Predicate<String>() {
    public boolean test(String st) {
        return st.contains("Java");
    }
});
```

Estas interfaces las mencionamos en clases anteriores. Solo como repaso, listo algunas a continuación:


* Consumer<T>: recibe un dato de tipo T y no genera ningún resultado
* Function<T,R>: toma un dato de tipo T y genera un resultado de tipo R
* Predicate<T>: toma un dato de tipo T y evalúa si el dato cumple una condición
* Supplier<T>: no recibe ningún dato, pero genera un dato de tipo T cada vez que es invocado
* UnaryOperator<T> recibe un dato de tipo T y genera un resultado de tipo T


Estas interfaces (y otras más) sirven como la base de donde generar los objetos con las lambdas que pasamos a los diferentes métodos de Stream. Cada una de ellas cumple esencialmente con recibir el tipo de dato de el Stream y generar el tipo de retorno que el método espera.

Si tuvieras tu propia implementación de Stream, se vería similar al siguiente ejemplo:


```java
public class PlatziStream<T> implements Stream {
    private List<T> data;

    public Stream<T> filter(Predicate<T> predicate) {
        List<T> filteredData = new LinkedList<>();
        for(T t : data){
            if(predicate.test(t)){
                filteredData.add(t);
            }
        }

        return filteredData.stream();
    }
}
```

Probablemente, tendría otros métodos y estructuras de datos, pero la parte que importa es justamente cómo se usa el Predicate. Lo que hace Stream internamente es pasar cada dato por este objeto que nosotros proveemos como una lambda y, según el resultado de la operación, decidir si debe incluirse o no en el Stream resultante.

Como puedes notar, esto no tiene mucha complejidad, puesto que es algo que pudimos fácilmente replicar. Pero Stream no solo incluye estas operaciones “triviales”, también incluye un montón de utilidades para que la máquina virtual de Java pueda operar los elementos de un Stream de manera más rápida y distribuida.

Operaciones

A estas funciones que reciben lambdas y se encargan de trabajar (operar) sobre los datos de un Stream generalmente se les conoce como Operaciones.

Existen dos tipos de operaciones: intermedias y finales.

Cada operación aplicada a un Stream hace que el Stream original ya no sea usable para más operaciones. Es importante recordar esto, pues tratar de agregar operaciones a un Stream que ya esta siendo procesado es un error muy común.

En este punto seguramente te parezcan familiares todas estas operaciones, pues vienen en forma de métodos de la interfaz Stream. Y es cierto. Aunque son métodos, se les considera operaciones, puesto que su intención es operar el Stream y, posterior a su trabajo, el Stream no puede volver a ser operado.

En clases posteriores hablaremos más a detalle sobre cómo identificar una operación terminal de una operación intermedia.

Collectors

Una vez que has agregado operaciones a tu Stream de datos, lo más usual es que llegues a un punto donde ya no puedas trabajar con un Stream y necesites enviar tus datos en otro formato, por ejemplo, JSON o una List a base de datos.

Existe una interfaz única que combina todas las interfaces antes mencionadas y que tiene como única utilidad proveer de una operación para obtener todos los elementos de un Stream: Collector.

Collector<T, A, R> es una interfaz que tomará datos de tipo T del Stream, un tipo de dato mutable A, donde se iran agregando los elementos (mutable implica que podemos cambiar su contenido, como un LinkedList), y generara un resultado de tipo R.

Suena complicado… y lo es. Por eso mismo, Java 8 incluye una serie de Collectors ya definidos para no rompernos las cabeza con cómo convertir nuestros datos.

Veamos un ejemplo:

```java
public List<String> getJavaCourses(Stream<String> coursesStream) {
    List<String> javaCourses =
        coursesStream.filter(course -> course.contains("Java"))
            .collect(Collectors.toList());

    return javaCourses;
}
```

Usando java.util.stream.Collectors podemos convertir muy sencillamente un Stream en un Set, Map, List, Collection, etc. La clase Collectors ya cuenta con métodos para generar un Collector que corresponda con el tipo de dato que tu Stream está usando. Incluso vale la pena resaltar que Collectors puede generar un ConcurrentMap que puede ser de utilidad si requieres de multiples threads.

Usar Collectors.toXXX es el proceso inverso de usar Collection.stream(). Esto hace que sea fácil generar APIs publicas que trabajen con estructuras/colecciones comunes e internamente utilizar Stream para agilizar las operaciones de nuestro lado.


Tipos de retorno

Hasta este punto, la única manera de obtener un dato que ya no sea un Stream es usando Collectors, pues la mayoría de operaciones de Stream se enfocan en operar los datos del Stream y generar un nuevo Stream con los resultados de la operación.

Sin embargo, algunas operaciones no cuentan con un retorno. Por ejemplo, forEach, que es una operación que no genera ningún dato. Para poder entender qué hace cada operación basta con plantear qué hace la operación para poder entender qué puede o no retornar.


Por ejemplo:

La operación de findAny trata de encontrar cualquier elemento que cumpla con la condición del Predicate que le pasamos como parámetro. Sin embargo, la operación dice que se devuelve un Optional. ¿Qué pasa cuando no encuentra ningún elemento? ¡Claro, por eso devuelve un Optional! Porque podría haber casos en que ningún elemento del Stream cumpla la condición.

En las clases posteriores haremos un listado más a detalle y con explicaciones de qué tipos de retorno tiene cada operación. Y entenderemos por qué se categorizan como operaciones finales e intermedias.


Conclusiones

Por ahora, hemos entendido que cada operación en un Stream consume hasta agotar el Stream. Y lo hace en un objeto no reusable. Esto implica que tenemos que decidir en nuestro código cuándo un Stream es un elemento temporal para una función o cuándo realmente una función sera la última en tocar los datos del Stream.

Las siguientes clases y lecturas cubrirán mas a detalle las múltiples operaciones y cómo afectan a los datos del Stream.


### Streams de tipo específico y Paralelismo

A través del método .parallel() podremos poner a trabajar los demás procesadores de nuestro equipo para que compilen más rápido el Stream y esto va ser ideal cuanto se manejen grandes cantidades de datos. 

parallel() -> distribuir los datos en todos los procesadores no regresa los datos ordenados
Stream con parallel funciona bien cuando son millones de datos, pero cuando son poco no debes de usar parallel


###  Operaciones Terminales

Las operaciones terminales son aquellas operaciones que como resultado no generan un nuevo Stream. Su resultado puede variar según la operación. La utilidad de estas es poder generar un valor final a todas nuestras operaciones o consumir los datos finales. La razón principal para querer esto es que los datos deberán salir en algún punto de nuestro control y es con las operaciones terminales que hacemos esto.

Pensemos, por ejemplo, en un servidor web. Recibe una petición de datos, convierte la petición en un Stream, procesa los datos usando filter o map, convierte de JSON a datos locales que sean manipulables por código Java y hace consumo de una base de datos. Todo esto mediante streams de diferentes tipos. Pero eventualmente tiene que devolver una respuesta para quien le hizo la petición.

¿Qué pasa si quien hizo la petición no esta usando Java? No podemos enviarle un objeto de tipo Stream a un código hecho en Python o en JavaScript… es ahi donde una operación final nos ayuda a convertir nuestro Stream de Java en algún tipo de dato que sea mas comprensible.

Otro ejemplo claro es si estamos creando una librería o creando código que más gente en nuestro equipo usará. Al crear nuestros métodos y clases usamos streams por aquí y lambdas por allá, pero al exponer estos métodos para uso de otros desarrolladores no podemos obligarlos a usar Stream.

Las razones son variadas. No queremos obligar y limitar a quienes usen nuestro código a trabajar con un solo tipo dato. No sabemos qué versión de Java está usando quien use nuestro código. No sabemos si Stream está disponible en su parte del código (por ejemplo, en Android no estaba disponible del todo), etc.

Es por ello que quisiéramos proveer de algo mas simple: listas, primitivos o incluso dar algún mecanismo para poder usar código externo de nuestro lado.

Las operaciones terminales más comunes que se encuentran en Stream son:

* anyMatch()
* allMatch()
* noneMatch()
* findAny()
* findFirst()
* min()
* max()
* reduce()
* count()
* toArray()
* collect()
* forEach()

Revisaremos qué hacen y qué utilidad tienen durante esta lectura.

#### Operaciones terminales de coincidencia

anyMatch, allMatch, noneMatch

Las operaciones anyMatch, allMatch y noneMatch sirven para determinar si en un Stream hay elementos que cumplan con un cierto Predicate. Esto puede ser una forma simple de validar los datos de un Stream. Son terminales pues las tres retornan un boolean:

```java
//Nos indica si un stream contiene un elemento según el Predicate que le pasemos:
Stream numbersStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 11);
boolean biggerThanTen = numbersStream.anyMatch(i -> i > 10); //true porque tenemos el 11

//allMatch
//Nos indica si todos los elementos de un Stream cumplen con un cierto Predicate:
Stream agesStream = Stream.of(19, 21, 35, 45, 12);
boolean allLegalDrinkingAge = agesStream.allMatch(age -> age > 18); //false, tenemos un menor

//noneMatch
//Nos indica si todos los elementos de un Stream NO CUMPLEN un cierto Predicate:
Stream oddNumbers = Stream.of(1, 3, 5, 7, 9, 11);
boolean allAreOdd = oddNumbers.noneMatch(i -> i % 2 == 0);
```

#### Operaciones terminales de búsqueda

findAny, findFirst

Estas operaciones retornan un Optional como resultado de buscar un elemento dentro del Stream.

La diferencia entre ambas es que findFirst retornara un Optional conteniendo el primer elemento en el Stream si el Stream tiene definida previamente una operación de ordenamiento o para encontrar elementos. De lo contrario, funcionará igual que findAny, tratando de devolver cualquier elemento presente en el Stream de forma no determinista (random)

Si el elemento encontrado es null, tendrás que lidiar con una molesta NullPointerException. Si el Stream esta vacío, el retorno es equivalente a Optional.empty().

La principal razón para usar estas operaciones es poder usar los elementos de un Stream después haber filtrado y convertido tipos de datos. Con Optional nos aseguramos que, aún si no hubiera resultados, podremos seguir trabajando sin excepciones o escribiendo condicionales para validar los datos.

#### Operaciones terminales de reducción

min, max

Son dos operaciones cuya finalidad es obtener el elemento más pequeño (min) o el elemento más grande (max) de un Stream usando un Comparator. Puede haber casos de Stream vacíos, es por ello que las dos operaciones retornan un Optional para en esos casos poder usar Optional.empty.

La interfaz Comparator es una @FunctionalInterface, por lo que es sencillo usar min y max con lambdas:

```java
Stream bigNumbers = Stream.of(100L, 200L, 1000L, 5L);
Optional minimumOptional = bigNumbers.min((numberX, numberY) -> (int) Math.min(numberX, numberY));
```

reduce

Esta operación existe en tres formas:

* reduce(valorInicial, BinaryOperator)
* reduce(BinaryAccumulator)
* reduce(valorInicial, BinaryFunction, BinaryOperator)

La diferencia entre los 3 tipos de invocación:

* reduce(BinaryAccumulator)

Retorna un Optional del mismo tipo que el Stream, con un solo valor resultante de aplicar el BinaryAccumulator sobre cada elemento o Optional.empty() si el stream estaba vacío. Puede generar un NullPointerException en casos donde el resultado de BinaryAccumulator sea null.


```java
Stream aLongStoryStream = Stream.of("Cuando", "despertó,", "el", "dinosaurio", "todavía", "estaba", "allí.");
Optional longStoryOptional = aLongStoryStream.reduce((previousStory, nextPart) -> previousStory + " " + nextPart);
longStoryOptional.ifPresent(System.out::println); //"Cuando despertó, el dinosaurio todavía estaba allí."
```


reduce(valorInicial, BinaryOperator)

Retorna un valor del mismo tipo que el Stream después de aplicar BinaryOperator sobre cada elemento del Stream. En caso de un Stream vacío, el valorInicial es retornado.

```java
Stream firstTenNumbersStream = Stream.iterate(0, i -> i + 1).limit(10);
int sumOfFirstTen = firstTenNumbersStream.reduce(0, Integer::sum); //45 -> 0 + 1 + … + 9

```

Y el caso mas interesante…

reduce(valorInicial, BinaryFunction, BinaryOperator)

Genera un valor de tipo V después de aplicar BinaryFunction sobre cada elemento de tipo T en el Stream y obtener un resultado V.

Esta version de reduce usa el BinaryFunction como map + reduce. Es decir, por cada elemento en el Stream se genera un valor V basado en el valorInicial y el resultado anterior de la BinaryFunction. BinaryOperator se utiliza en streams paralelos (stream.parallel()) para determinar el valor que se debe mantener en cada iteración.

```java
Stream aLongStoryStreamAgain = Stream.of("Cuando", "despertó,", "el", "dinosaurio", "todavía", "estaba", "allí.");
int charCount = aLongStoryStreamAgain.reduce(0, (count, word) -> count + word.length(), Integer::sum);
```

count

Una operación sencilla: sirve para obtener cuantos elementos hay en el Stream.

```java
Stream yearsStream = Stream.of(1990, 1991, 1994, 2000, 2010, 2019, 2020);
long yearsCount = yearsStream.count(); //7, solo nos dice cuantos datos tuvo el stream.
```

La principal razón de usar esta operación es que, al aplicar filter o flatMap, nuestro Stream puede crecer o disminuir de tamaño y, tal vez, de muchas operaciones solo nos interese saber cuántos elementos quedaron presentes en el Stream. Por ejemplo, cuantos archivos se borraron o cuantos se crearon por ejemplo.

toArray

Agrega todos los elementos del Stream a un arreglo y nos retorna dicho arreglo. La operación genera un Object[], pero es sposible hacer castings al tipo de dato del Stream.

collect

Mencionamos la operación collect en la lectura sobre operaciones y collectors, donde mencionamos que:

Collector es una interfaz que tomara datos de tipo T del Stream, un tipo de dato mutable A, donde se irán agregando los elementos (mutable implica que podemos cambiar su contenido, como un LinkedList) y generara un resultado de tipo R.
Usando java.util.stream.Collectors podemos convertir sencillamente un Stream en un Set, Map, List, Collection, etc. La clase Collectors ya cuenta con métodos para generar un Collector que corresponda con el tipo de dato que tu Stream esta usando. Incluso vale la pena resaltar que Collectors puede generar un ConcurrentMap que puede ser de utilidad si requieres de multiples threads.

```java
public List getJavaCourses(Stream coursesStream) {
    List javaCourses =
        coursesStream.filter(course -> course.contains("Java"))
            .collect(Collectors.toList());

    return javaCourses;
}
```

#### Operaciones terminales de iteración

forEach

Tan simple y tan lindo como un clásico for. forEach es una operación que recibe un Consumer y no tiene un valor de retorno (void). La principal utilidad de esta operación es dar un uso final a los elementos del Stream.

```java
Stream> courses = getCourses();
courses.forEach(courseList -> System.out.println("Cursos disponibles: " + courseList));
```

Conclusiones

Las operaciones terminales se encargan de dar un fin y liberar el espacio usado por un Stream. Son también la manera de romper los encadenamientos de métodos entre streams y regresar a nuestro código a un punto de ejecución lineal. Como su nombre lo indica, por lo general, son la ultima operación presente cuando escribes chaining:

```java
Stream infiniteStream = Stream.iterate(0, x -> x + 1);
List numbersList = infiniteStream.limit(1000)
    .filter(x -> x % 2 == 0) // Operación intermedia
    .map(x -> x * 3) //Operación intermedia
    .collect(Collectors.toList()); //Operación final
```
Por ultimo, recuerda que una vez que has agregado una operación a un Stream, el Stream original ya no puede ser utilizado. Y más aun al agregar una operación terminal, pues esta ya no crea un nuevo Stream. Internamente, al recibir una operación, el Stream en algún punto llama a su método close, que se encarga de liberar los datos y la memoria del Stream.

### Operaciones Intermedias

Operaciones intermedias

En clases anteriores hablamos de dos tipos de operaciones: intermedias y finales. No se explicaron a profundidad, pero en esta lectura iremos más a fondo en las operaciones intermedias y trataremos de entender qué sucede por dentro de cada una.

¿Qué son?

Se le dice operación intermedia a toda operación dentro de un Stream que como resultado devuelva un nuevo Stream. Es decir, tras invocar una operación intermedia con un cierto tipo de dato, obtendremos como resultado un nuevo Stream conteniendo los datos ya modificados.

El Stream que recibe la operación intermedia pasa a ser “consumido” posterior a la invocación de la operación, quedando inutilizable para posteriores operaciones. Si decidimos usar el Stream para algún otro tipo de operaciones tendremos un IllegalStateException.

Viéndolo en código con un ejemplo debe ser mas claro:

```java
Stream initialCourses = Stream.of("Java", "Spring", "Node.js");

Stream lettersOnCourses = initialCourses.map(course -> course.length());
//De este punto en adelante, initialCourses ya no puede agregar mas operaciones.

Stream evenLengthCourses = lettersOnCourses.filter(courseLength -> courseLength % 2 == 0);
//lettersOnCourses se consume en este punto y ya no puede agregar mas operaciones. No es posible usar el Stream mas que como referencia.

```

El ejemplo anterior puede ser reescrito usando chaining. Sin embargo, la utilidad de este ejemplo es demostrar que las operaciones intermedias generan un nuevo Stream.

#### Operaciones disponibles

La interfaz Stream cuenta con un grupo de operaciones intermedias. A lo largo de esta lectura explicaremos cada una de ellas y trataremos de aproximar su funcionalidad. Cada operación tiene implementaciones distintas según la implementación de Stream, en nuestro caso, haremos solo aproximaciones de la lógica que sigue la operación.

Las operaciones que ya están definidas son:

* filter(…)
* map(…)
* flatMap(…)
* distinct(…)
* limit(…)
* peek(…)
* skip(…)
* sorted(…)

Analicemos qué hace cada una de ellas y hagamos código que se aproxime a lo que hacen internamente.

* filter

La operación de filtrado de Stream tiene la siguiente forma:

```java
Stream filter(Predicatesuper <T> predicate)
```

Algunas cosas que podemos deducir únicamente viendo los elementos de la operación son:

* La operación trabaja sobre un Stream y nos devuelve un nuevo Stream del mismo tipo (T)
* Sin embargo, el Predicate que recibe como parámetro trabaja con elementos de tipo T y cualquier elemento siempre que sea un subtipo de T. Esto quiere decir que si tenemos la clase PlatziStudent extends Student y tenemos un Stream donde también tenemos elementos de tipo PlatziStudent, podemos filtrarlos sin tener que revisar o aclarar el tipo
* Predicate es una @FunctionalInterface (como lo viste en la clase 11), lo cual nos permite pasar como parámetro objetos que implementen esta interfaz o lambdas

El uso de esta operación es sencillo:

```java
public Stream getJavaCourses(List courses){
    return courses.stream()
        .filter(course -> course.contains("Java"));
}
```

Lo interesante radica en la condición que usamos en nuestra lambda, con ella determinamos si un elemento debe permanecer o no en el Stream resultante. En la lectura anterior hicimos una aproximación de la operación filter:

```java
public Stream filter(Predicate predicate) {
    List filteredData = new LinkedList<>();
    for(T t : this.data){
        if(predicate.test(t)){
            filteredData.add(t);
        }
    }

    return filteredData.stream();
}

```

filter se encarga de iterar cada elemento del Stream y evaluar con el Predicate si el elemento debe estar o no en el Stream resultante. Si nuestro Predicate es sencillo y no incluye ningún ciclo o llamadas a otras funciones que puedan tener ciclos, la complejidad del tiempo es de O(n), lo cual hace que el filtrado sea bastante rápido.

Usos comunes de filter es limpiar un Stream de datos que no cumplan un cierto criterio. Como ejemplo podrías pensar en un Stream de transacciones bancarias, mantener el Stream solo aquellas que superen un cierto monto para mandarlas a auditoria, de un grupo de calificaciones de alumnos filtrar únicamente por aquellos que aprobaron con una calificación superior a 6, de un grupo de objetos JSON conservar aquellos que tengan una propiedad en especifico, etc.

Entre mas sencilla sea la condición de filtrado, más legible sera el código. Te recomiendo que, si tienes más de una condición de filtrado, no le temas a usar varias veces filter:


```java
courses.filter(course -> course.getName().contains("Java"))
    .filter(course -> course.getDuration() > 2.5)
    .filter(course -> course.getInstructor().getName() == Instructors.SINUHE_JAIME
```

Tu código sera más legible y las razones de por qué estás aplicando cada filtro tendrán más sentido. Como algo adicional podrías mover esta lógica a funciones individuales en caso de que quieras hacer más legible el código, tener más facilidad de escribir pruebas o utilices en más de un lugar la misma lógica para algunas lambdas:

```java
courses.filter(Predicates::isAJavaCourse)
    .filter(Predicates::hasEnoughDuration)
    .filter(Predicates::hasSinuheAsInstructor);

// La lógica es la misma:
public final class Predicates {
    public static final boolean isAJavaCourse(Course course){
        return course.getName().contains("Java");
    }
}

```

* map

La operación map puede parecer complicada en un principio e incluso confusa si estas acostumbrado a usar Map, pero cabe resaltar que no hay relación entre la estructura y la operación. La operación es meramente una transformación de un tipo a otro.

```java
Stream map(Functionsuper T, ? extends <R> mapper)
```

Los detalles a resaltar son muy similares a los de filter, pero la diferencia clave está en T y R. Estos generics nos dicen que map va a tomar un tipo de dato T, cualquiera que sea, le aplicara la función mapper y generara un R.

Es algo similar a lo que hacías en la secundaria al convertir en una tabla datos, para cada x aplicabas una operación y obtenías una y (algunos llaman a esto tabular). map operará sobre cada elemento en el Stream inicial aplicando la Function que le pases como lambda para generar un nuevo elemento y hacerlo parte del Stream resultante:

```java
Stream ids = DatabaseUtils.getIds().stream();

Stream users = ids.map(id -> db.getUserWithId(id));
```

O, puesto de otra forma, por cada DatabaseID en el Stream inicial, al aplicar map genera un User:

```java
DatabaseID(1234) -> map(…) -> User(Sinuhe Jaime, @Sierisimo)
DatabaseID(4321) -> map(…) -> User(Diego de Granda, @degranda10)
DatabaseID(007) -> map(…) ->User(Oscar Barajas, @gndx)
```

Esto resulta bastante practico cuando queremos hacer alguna conversión de datos y realmente no nos interesa el dato completo (solo partes de él) o si queremos convertir a un dato complejo partiendo de un dato base.

Si quisiéramos replicar qué hace internamente map sería relativamente sencillo:

```java
public  Stream filter(Function mapper) {
    List mappedData = new LinkedList<>();
    for(T t : this.data){
        R r = mapper.apply(t);
        mappedData.add(r);
    }
    return mappedData.stream();
}

```

La operación map parece simple ya vista de esta manera. Sin embargo, por dentro de las diferentes implementaciones de Stream hace varias validaciones y optimizaciones para que la operación pueda ser invocada en paralelo, para prevenir algunos errores de conversión de tipos y hacer que sea mas rápida que nuestra versión con un for.

* flatMap

En ocasiones no podremos evitar encontrarnos con streams del tipo Stream>, donde tenemos datos con muchos datos…

Este tipo de streams es bastante común y puede pasarte por multiples motivos. Se puede tornar difícil operar el Stream inicial si queremos aplicar alguna operación a cada uno de los elementos en cada una de las listas.


Si mantener la estructura de las listas (o colecciones) no es importante para el procesamiento de los datos que contengan, entonces podemos usar flatMap para simplificar la estructura del Stream, pasándolo de Stream> a Stream.

Visto en un ejemplo más “visual”:

```java
<Stream> coursesLists; // Stream{List["Java", "Java 8 Functional", "Spring"], List["React", "Angular", "Vue.js"], List["Big Data", "Pandas"]}
Stream allCourses; // Stream{ ["Java", "Java 8 Functional", "Spring", "React", "Angular", "Vue.js", "Big Data", "Pandas"]}
```
flatMap tiene la siguiente forma:

```java
Stream flatMap(Functionsuper T, ? extends Stream> mapper)
```

Lo interesante es que el resultado de la función mapper debe ser un Stream. Stream usará el resultado de mapper para “acumular” elementos en un Stream desde otro Stream. Puede sonar confuso, por lo que ejemplificarlo nos ayudará a entenderlo mejor:

```java
//Tenemos esta clase:
public class PlatziStudent {
    private boolean emailSubscribed;
    private List emails;

    public boolean isEmailSubscribed() {
        return emailSubscribed;
    }

    public List getEmails(){
        return new LinkedList<>(emails); //Creamos una copia de la lista para mantener la clase inmutable por seguridad
    }
}

//Primero obtenemos objetos de tipo usuario registrados en Platzi:
Stream platziStudents = getPlatziUsers().stream();

// Despues, queremos enviarle un correo a todos los usuarios pero… solo nos interesa obtener su correo para notificarlos:
Stream allEmailsToNotify = 
                        platziStudents.filter(PlatziStudent::isEmailSubscribed) //Primero evitamos enviar correos a quienes no estén subscritos
                                    .flatMap(student -> student.getEmails().stream()); // La lambda genera un nuevo Stream de la lista de emails de cada studiante.

sendMonthlyEmails(allEmailsToNotify);
//El Stream final solo es un Stream de emails, sin mas detalles ni información adicional.
```

flatMap es una manera en la que podemos depurar datos de información adicional que no sea necesaria.

* distinct

Esta operación es simple:

```java
Stream distinct()
```

Lo que hace es comparar cada elemento del Stream contra el resto usando el método equals. De esta manera, evita que el Stream contenga elementos duplicados. La operación, al ser intermedia, retorna un nuevo Stream donde los elementos son únicos. Recuerda que para garantizar esto es recomendable que sobrescribas el método equals en tus clases que representen datos.

* limit

La operación limit recibe un long que determina cuántos elementos del Stream original seran preservados. Si el número es mayor a la cantidad inicial de elementos en el Stream, básicamente, todos los elementos seguirán en el Stream. Un detalle interesante es que algunas implementaciones de Stream pueden estar ordenadas (sorted()) o explícitamente no ordenadas (unordered()), lo que puede cambiar drásticamente el resultado de la operación y el performance.

```java
Stream limit(long maxSize)
```

La operación asegura que los elementos en el Stream resultante serán los primeros en aparecer en el Stream. Es por ello que la operación es ligera cuando el Stream es secuencial o se usó la operación unordered() (no disponible en todos los Streams, ya que la operación pertenece a otra clase).

Como reto adicional, crea el código para representar lo que hace la operación limit.

```java
public Stream limit(Long limit){
    List list = new LinkedList<>();
    for (int i = 0; i < limit; i++){
        list.add(this.data);
    }
    return list.stream();
}
```

* peek

peek funciona como una lupa, como un momento de observación de lo que está pasando en el Stream. Lo que hace esta operación es tomar un Consumer, pasar los datos conforme van estando presentes en el Stream y generar un nuevo Stream idéntico para poder seguir operando.

```java
Stream peek(Consumersuper T> consumer)
```
Usarlo puede ayudarnos a generar logs o registros de los datos del Stream, por ejemplo:

```java
Stream serverConnections =
    server.getConnectionsStream()
        .peek(connection -> logConnection(connection, new Date()))
        .filter(…)
        .map(…)
    //Otras operaciones…
```

* skip

Esta operación es contraria a limit(). Mientras limit() reduce los elementos presentes en el Stream a un numero especifico, skip descarta los primeros n elementos y genera un Stream con los elementos restantes en el Stream.

```java
//Esto es:

Stream first10Numbers = Stream.of(0,1,2,3,4,5,6,7,8,9);
Stream last7Numbers = first10Numbers.skip(3); // 3,4,5,6,7,8,9
```
Esto puede ser de utilidad si sabemos qué parte de la información puede ser descartable. Por ejemplo, descartar la primera línea de un XML (), descartar metadatos de una foto, usuarios de prueba al inicio de una base de datos, el intro de un video, etc.


* sorted

La operación sorted() requiere que los elementos presentes en el Stream implementen la interfaz Comparable para poder hacer un ordenamiento de manera natural dentro del Stream. El Stream resultante contiene todos los elementos pero ya ordenados, hacer un ordenamiento tiene muchas ventajas.

#### Conclusiones

Las operaciones intermedias nos permiten tener control sobre los streams y manipular sus contenidos de manera sencilla sin preocuparnos realmente por cómo se realizan los cambios.

Recuerda que las operaciones intermedias tienen la funcionalidad de generar nuevos streams que podremos dar como resultado para que otras partes del código los puedan utilizar.

Aunque existen otras operaciones intermedias en diferentes implementaciones de Stream, las que aquí listamos están presentes en la interfaz base, por lo que entender estas operaciones te facilitara la vida en la mayoría de los usos de Stream.