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