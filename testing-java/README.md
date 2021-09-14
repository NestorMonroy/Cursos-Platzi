### Tipos y beneficios de los tests

Beneficios

* Comprobar los requerimientos de nuestra aplicación.
* Documentación y ejemplos de nuestras clases.
* Mediante Test Driven Development (TDD) nos puede ayudar en el diseño de clases.
* Confianza al desarrollar.
* Confianza para refactorizar nuestro código.
* Es una habilidad que se solicita cada vez más en el mercado.

Existen test automáticos y manuales, los automáticos van a requerir tiempo de desarrollo y algunas veces no serán tan viables, pero de ser posible siempre trata de hacer test automáticos ya que:

* Son más rápidos.
* Son más fiables.
* Son incrementales.

Tipos de test

Unitario: realizan pruebas a una función o clase muy concreta de nuestro proyecto.
Integración: prueban cómo se conectan diferentes componentes de nuestro proyecto.
Funcionales: prueban una funcionalidad de nuestro proyecto, pueden involucrarse varias clases.
Inicio a fin: prueba todo un proceso del proyecto.
Estrés: útil para probar si nuestra aplicación puede soportar grandes cantidades de procesos y peticiones a la vez.



### Creación de test unitario: lanzar una excepción para alertar sobre un error

Vamos a utilizar una excepción con la función throw new RuntimeException("Error") en lugar de la función System.out.println("Error") para identificar más fácil los errores. Ahora, los mensajes tendrán un color diferente y pueden mostrarnos un poco más de información sobre los errores: ubicación, el resultado esperado, mensajes personalizados, entre otros.

```java
public class StringUtilTest {

    @Test
    public void testRepeat() {

      assertEquals(StringUtil.repeat("hola", 1), "hola");

      //  if (!result.equals("holahoAlahola")) {
      //      throw new RuntimeException("ERROR");
      //  }
      //  if (result.equals("holaholahola")) {
      //      System.out.println("Ok");
      //  }

       String result2 = StringUtil.repeat("hola", 1);

       assertEquals(result2, "hola");
       if (!result2.equals("hola")) {
           throw new RuntimeException("ERROR");
       }

       if (result2.equals("hola")) {
           System.out.println("Ok");
       }

    }

   private static void assertEquals(String actual, String expected) {
       if (!actual.equals(expected)) {
           throw new RuntimeException(actual + "is not equal to expected: " + expected);
       }
   }

}
```


### Test unitario

```java


public class StringUtil {
    public static String repeat(String str, int times) {
        String result = "";

        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;

    }
}

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void testRepeat() {

        Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 2));
        Assert.assertEquals("hola", StringUtil.repeat("hola", 1));


}
```

### Organización de tests con JUnit

La forma correcta de separar nuestras pruebas es realizar cada una en su propia función, además, el nombre de la función debe describir que estamos probando.

Para indicarle a JUnit que esperamos una excepción lo debemos hacer de la siguiente forma:

```java
@Test(expected = IllegalArgumentException.class)

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void repeat_string_once() {
        Assert.assertEquals("hola", StringUtil.repeat("hola", 1));
    }

    @Test
    public void repeat_string_multiple_times() {
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 3));
    }

    @Test
    public void repeat_string_zero_times() {
        Assert.assertEquals("", StringUtil.repeat("hola", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times() {
        StringUtil.repeat("hola", -1);
    }
}
```


### Test con Mockito para simular un dado


Mockito nos va a servir para simular clases mientras probamos, para añadirlo a nuestro proyecto debemos copiar las siguientes líneas de código:

<dependency>
  <groupId>org.mockito</groupId>
  <artifactId>mockito-core</artifactId>
  <version>2.23.4</version>
  <scope>test</scope>
</dependency>

Para instanciar un mock debemos utilizar la función Mockito.mock() e indicarle como parámetro la clase que va a simular.
Las funciones assertFalse y assertTrue tal como su nombre lo indican, sirven para comprobar si un valor es igual a false o true respectivamente.
Archivos de la clase

### Análisis de los tests y mejoras

Nuestros test siguen un mismo proceso:

1 Se preparan los objetos que vamos a probar.
2 Llamamos al método que estamos probando.
3 Comprobamos los resultados.

Podemos reducir la cantidad de código moviendo las partes comunes de preparación a una función que se ejecute antes de cada prueba.
Con @Before le indicamos a JUnit la función que debe ejecutar antes de cada prueba

```java

public class PaymentProcessorTest {
    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    @Before
    public void setup() {
        paymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    public void payment_is_correct() {
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));
        boolean result = paymentProcessor.makePayment(1000);
        assertTrue(result);
    }

    @Test
    public void payment_is_wrong() {
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));
        boolean result = paymentProcessor.makePayment(1000);
        assertFalse(result);
    }
}

```


### TDD: Definición, Beneficios, Ciclos y Reglas

El Test Driven Development (TDD) o desarrollo guiado por test, creado por Kent Beck, consiste en escribir primero los test antes que las clases permitiéndote ver si el diseño de una clase es la adecuada.
El ciclo del TDD

* Red: escribe un test que falle.
* Green: escribe el código necesario para que pase el test.
* Refactor: mejora el código.

Reglas

* Sólo escribirás código de test hasta que falle.
* Sólo escribirás código de producción para pasar el test.
* No escribirás más código de producción del necesario.

Puedes combinar las reglas del TDD con su ciclo tal como hizo el profesor:

* Red: Escribirás el mínimo de código test que falle.
* Green: Escribirás el mínimo de código de producción que pase el test.
* Refactor: sólo cuando los tests estén pasando.


###  Organización de una aplicación

Por lo general una aplicación se divide en:

* Interfaz: Se encarga de la comunicación con el exterior o un usuario.
* Negocio: Es la lógica de nuestra aplicación.
* Datos: Se encarga de guardar los datos de nuestra aplicación.

Cada capa se puede comunicar con otra, pero no conoce los detalles de implementación.


### Test a partir de requerimiento

Normalmente, el desarrollo de los proyectos comienza a partir de requerimientos muy bien especificados. Sin embargo, habrá veces donde el programador debe definirlos o acabar de concretarlos. No importa cuál sea el caso, solo podemos empezar a escribir los tests una vez tenemos los requerimientos.

Existen diferentes escenarios:

* Típicos
* Extremos
* Incorrectos
* No previstos


### En Java, los tipos primitivos como int, boolean o double no pueden tener valor *null.

La expresión regular [a-z0-9]+ detectaría textos que:
R= Tienen letras minúsculas o números

En TDD, podemos hacer refactor:
R= Sólo cuando los tests estén pasando

En un test generalmente comparamos dos valores. ¿Cuáles son?
R= El valor esperado y el valor real

La expresión movies.stream().filter(condición):
R= Retorna las películas que cumplen la condición indicada.

Generalmente, los tests tienen estas tres partes, y en este orden:
R= Preparación de los objetos, llamada al método, comprobación del resultado

El nombre de un test debe indicar lo que estamos probando en ese test:
R= Verdadero

En TDD, los pasos que seguimos son los siguientes y en este orden:
R= Escribimos primero un test, y luego la parte de nuestra clase o método que pase ese test.

¿Para qué sirven los métodos query y queryForObject en JdbcTemplate?
R= query sirve para obtener una colección y queryForObject para obtener un solo objeto

Como programador, si los requerimientos de la aplicación no están claros:
R= Intentaremos definir mejor los requerimientos, hablando con alguien que pueda aclararlos.

¿Qué elementos prueba un test unitario?
R= Prueba sólo una clase

Para asegurarnos de que nuestro código funciona, lo mejor es:
R= Escribir tests automáticos


En JUnit podemos comparar valores con la función:
R= assertEquals

La sentencia “Mockito.when(dice.roll()).thenReturn(2);” hace lo siguiente:
R= Hace que cuando llamemos a dice.roll() devuelva 2.

En el test unitario de negocio:
R= Creamos un mock del repositorio para simular la base de datos

Usamos Mockito para simular una pasarela de pago porque:
R =En el test no queremos usar la pasarela de pago real.

El nombre de cada método de test debe indicar:
R = El escenario que estamos probando

¿Para qué nos sirve lanzar una excepción cuando un test falla?
R = Para saber exactamente en qué línea de código está el error.


Para probar todo el proceso que se desencadena cuando un usuario hace una compra, debes hacer un test de tipo:
R= De inicio a fin

¿Cuál de estas afirmaciones es correcta respecto a la organización de una aplicación?
R = Muchas aplicaciones tienen capa de interfaz, negocio y datos

En un test de integración de base de datos:
R MAL= Nos conectamos con una base de datos simulada (mock)
R MAL = Integramos una base de datos real con una simulada

