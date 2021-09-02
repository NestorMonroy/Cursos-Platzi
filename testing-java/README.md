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