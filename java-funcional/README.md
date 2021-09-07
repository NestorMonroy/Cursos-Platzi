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