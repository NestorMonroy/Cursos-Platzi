¿Cómo podemos navegar entre páginas sin recargarla?

R = Utilizamos el componente Link de @reach/router en lugar de un anchor. También podemos navegar programáticamente importando la utilidad navigate de @reach/router.

¿Qué son las rutas protegidas?
R = Son rutas que no se pueden acceder dependiendo de una condición. Esta condición podría ser cualquier cosa como, por ejemplo, que el usuario haya iniciado sesión en nuestro sitio y tenga los permisos necesarios.

¿Qué son los React Hooks?
R = Los hooks en React son una nueva característica de la librería, disponible desde la versión 16.8.0, que nos permite tener estado en nuestros componentes funcionalidades, entre otras cosas, que hasta hace muy poco sólo podíamos conseguir con componentes con clases.

¿Podemos hacer SEO en nuestras aplicaciones de React?
R = Sí, tenemos librerías como React Helmet que nos permite cambiar toda la información necesaria.

¿Qué es un High Order Component?
R = Es una función que toma un componente como parámetro y devuelve un nuevo componente. Muy útil para reusar lógica.

¿Qué es @reach/router?
R = Es una librería independiente que nos permite crear una SPA en React que gestiona rutas de forma declarativa y que se preocupa por la accesibilidad.

¿A qué nos referimos cuando hablamos de CSS en JS?
R = Es una técnica dónde escribimos las propiedades CSS en nuestros archivos Javascript para estilar nuestros componentes. Esto ofrece varias ventajas, como la optimización y poder usar la potencia de Javascript en nuestros estilos.

¿Qué nos ofrece la librería styled-components?
R = Librería que nos permite estilar de forma muy sencilla, siguiendo CSS y usando los tags de HTML que queramos usar en nuestra aplicación y cualquier componente que acepte una prop className.

El hook useEffect se ejecuta:
R = Cada vez que ese renderiza el componente. Podemos saltarnos la ejecución indicándole en un segundo parámetro con una lista de valores de los que depende el efecto.

¿Qué son las renderProps?
R = Es una técnica para compartir código entre componentes en React que utiliza una prop (cómo children u otra de otro nombre, aunque normalmente se usa render) como función, que recibe como parámetro información y devuelve el componente que queremos que renderice.

¿Puede un custom hook tener estado?
R = Sí, los custom hooks pueden usar otros hooks incluso, otros custom hooks.

¿Para qué podemos utilizar React.memo?
R = Nos permite determinar cuándo un componente funcional se debe renderizar. Para ello podemos comparar las props anteriores y las nuevas.

¿Qué componente se utiliza para crear rutas en @reach/router?
R = Para crear rutas en @reach/router, envolvemos nuestros componentes página con el componente y cada componente ya podrá utilizar la prop "path" para especificar en qué path se renderizará cada componente.

¿Se puede crear una PWA de una aplicación de React?
R = Claro, y podemos utilizar herramientas como Workbox para ayudarnos.

¿Qué podemos hacer con el Context de React?
R = El contexto en React nos permite pasar información a través del árbol de components sin necesidad de usar props en cada nivel

¿Para qué sirven los Custom Hooks?
R =  Sirven para poder reutilizar la lógica en diferentes componentes. Para poder utilizarlos, deben empezar por la palabra use (useMiNombreDeHook)

¿Cómo podemos usar el Contexto de React?
R =  Tenemos que crear el contexto con React.createContext. Este contexto es un objeto con dos propiedades. Una es el Provider, que nos permite envolver la parte del árbol que queremos que tenga acceso al contexto. La otra es el Consumer, que nos permite suscribirnos a los cambios y valores que tendrá el contexto. También podemos usar el hook useContext como Consumer para leer los valores del contexto.

¿Qué son las mutaciones en GraphQL?
R =  Las mutaciones son las operaciones que no corresponden a una consulta: la creación, modificación, borrado o actualización de información.

Cypress nos ofrece una forma de:
R =  Testear de forma fácil, rápida y confiable cualquier cosa que se ejecute en el servidor como, por ejemplo, una aplicación web.

¿Qué es la performance de un sitio?
R =  Es la velocidad a la que una web es descargada, mostrada en el navegador y usable por el usuario.

El hook useState sirve para:
R = Crear un estado local en nuestro componente.

¿Cómo definirías React Apollo?
R = Es un cliente que nos permite hacer peticiones a un servidor utilizando el lenguaje GraphQL. Además, tiene los conectores necesarios para ser utilizado en una aplicación que utilice React, de forma que nos facilita su integración y uso.

¿Podemos saber si un enlace va a la ruta que está activa?
R = Sí, en el componente Link podemos saber si está enlazando a una página activa recuperando sus props. Además, podemos darle estilos directamente, ya que @reach/router le añade el atributo aria-current="page"


¿Para qué sirve la función React.lazy?
R = La función React.lazy nos permite renderizar un import dinámico como si fuese un componente normal. Para que funcione, debemos envolverlo con el componente <Suspense />

¿Qué debemos medir para la performance de nuestra web?
R = La performance de una web no se limita a una sola métrica pero, actualmente, la recomendación es fijarse en las métricas que afectan directamente a la experiencia del usuario, como el Time To Interactive. Lighthouse puede ayudarnos, ya que simula una conexión móvil para los datos.

¿Qué es StandardJS?
R = Unas reglas para lintar nuestro código. Aunque se llama Standard, no es oficial, aunque hay muchos proyectos que lo utilizan de forma predeterminada.

¿Cómo conseguimos pasarle parámetros a una query en React Apollo?
R = Usando la prop “variables” del componente <Query />, que recibe un objeto con todos los parámetros que queremos utilizar en la petición.
