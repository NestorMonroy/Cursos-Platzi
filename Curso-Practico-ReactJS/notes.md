React es una librería o mejor conocida como biblioteca de JavaScript para construir interfaces de usuario. Esa es su única finalidad. es declarativo. Esto nos permite crear interfaces de usuario muy amigables y de forma sencilla. También está basado en componentes. 

React puedes utilizarlo en la web. Puedes crear sorprendentes aplicaciones de escritorio para Windos, Mac o Linux. O también desarrollar aplicaciones mobile. 
Creacion > 2013 dentro de Facebook. Ahí es donde nace React y solventaba una pequeña particularidad que era el timeline.

Airbnb 
Netflix,
Uber, Landing Pages.

¿Qué es el virtual dom? 

Es una herramienta que implementa React para darle performance y velocidad a nuestros desarrollos copia fiel de lo que es el DOM. El Document Object Model de nuestro sitio. 

Pero vamos más a detalle a explicarlo. Tenemos una aplicación creada con React, la cual tiene una serie de elementos que tenemos que llenar. En este caso es nuestro perfil. Imaginemos que tenemos que llenar cada uno de estos y por cada uno de los elementos que vamos a actualizar, nuestro dom se tenía que refrescar totalmente, esto significa que volvía a presentar cada uno de estos elementos en nuestro navegador. Así es como actualmente trabaja el DOM. Pero con React y la implementación de Virtual DOM, ahora tenemos esta copia que permite identificar cada uno de estos elementos y saber cuál ha sido el que se actualizó.

no se va a refrescar toda la página ni presentar en el navegador cada uno de estos elementos, sino que solamente va a presentar la sección actualizada 

--
tipos de componentes 

la carpeta public, donde se van a encontrar los archivos que, como su nombre lo dice, son públicos para enviarlos a producción. Aquí está el favicon, aquí está el manifest y también está el archivo index principal, dónde está nuestro DOM. 

carpeta de source (src). Y aquí es donde se encuentra toda nuestra aplicación. 

Stateful -> Este componente es particularmente conocido como la estructura de clases. Nos va a permitir en nosotros también tener ciclo de vida y estado. Y es el componente más robusto que tiene React.

nuestro componente tiene acceso a un constructor. Y este constructor puede recibir las props. Y aquí tenemos que inicializar. Y las inicializamos con super, le pasamos esas pros que recibimos. Y aquí en esta sección también podemos hacer binding de las funciones o los eventos que vamos a manejar. O asignar el estado. 
Entonces yo voy a poder asignar aquí un estado llamado this.state, que esto es igual a un objeto.

Stateless -> Y como su nombre lo dice, no depende de tener un estado ni un ciclo de vida, sino que sólo va a presentar la lógica. Y también estos componentes son un poco más utilizados hoy en día porque trabajan con la parte funcional, son funciones y nos permite a nosotros enfocarnos en una particularidad, solo lo que necesitamos. Vamos a crear este componente. 

Presentacional -> va a ser un return explícito. Esto significa que no necesitó llamar al return y encapsularlo entre paréntesis para lo que voy a presentar

---
¿Qué es JSX? 
mezcla un poco de HTML con XML y con JavaScript, que te vas a topar cuando estamos trabajando con React. 

className, que es la nueva forma a la que nosotros vamos a trabajar. forma en la que nosotros asignamos clases dentro de JSX. 
---

Así como las funciones en Javascript reciben parámetros, nosotros podemos pasar propiedades a nuestros componentes. No importa si es de tipo clase o si es solamente presentacional. Estas propiedades son sólo de lectura. Y, sí en dado caso, tú requieras manipularlas o cambiar, las tenemos que instanciarlas en una nueva variable. 

destructurar los datos. ¿Y esto qué significa? Y es que voy a extraer el valor de Text de las props. 
--
¿Qué son los métodos del ciclo vida? 


Todos los componentes en React pasan por una serie de fases que generalmente se denominan “Ciclo de Vida del componente” es un proceso que React hace en cada componente, en algunos casos no podemos verlos como un bloque de código y en otros podemos llamarlos en nuestro componente para asignar una actividad según sea el caso necesario.

Los componentes en react pasan por un Montaje, Actualización, Desmontaje y Manejo de errores.

Montaje:
En esta fase nuestro componente se crea junto a la lógica y los componentes internos, luego son insertado en el DOM.

Constructor()

Este es el primer método al que se hace un llamado, aquí es donde se inicializan los métodos controladores, eventos del estado.

getDerivedStateFromProps()

Este método se llama antes de presentarse en el DOM y nos permite actualizar el estado interno en respuesta a un cambio en las propiedades, es considerado un método de cuidado, ya que su implementación puede causar errores sutiles.

render()

Si queremos representar elementos en el DOM en este método es donde se escribe esta lógica, usualmente utilizamos JSX para trabajar y presentar nuestra aplicación.

ComponentDidMount()

Este método se llama inmediatamente que ha sido montado en el DOM, aquí es donde trabajamos con eventos que permitan interactuar con nuestro componente.

Actualización:
En esta fase nuestro componente está al pendiente de cambios que pueden venir a través de un cambio en “state” o “props” esto en consecuencia realizan una acción dentro de un componente.

getDerivedStateFromProps()

Este método es el primero en ejecutarse en la fase de actualización y funciona de la misma forma que en el montaje.

shouldComponentUpdate()

Dentro de este método se puede controlar la fase de actualización, podemos devolver un valor entre verdadero o falso si queremos actualizar o no el componente y es utilizado principalmente para optimización.

render()

Se llama el método render que representa los cambios en el DOM.

componentDidUpdate()

Este método es invocado inmediatamente después de que el componente se actualiza y recibe como argumentos las propiedades y el estado y es donde podemos manejar nuestro componente.

Desmontaje:

En esta etapa nuestro componente “Muere” cuando nosotros no necesitamos un elemento de nuestra aplicación, podemos pasar por este ciclo de vida y de esta forma eliminar el componente de la representación que tiene en el DOM.

componentWillUnmount()

Este método se llama justo antes de que el componente sea destruido o eliminado del DOM.

Manejo de Errores:
Cuando nuestro código se ejecuta y tiene un error, podemos entrar en una fase donde se puede entender mejor qué está sucediendo con la aplicación.

Algo que debemos tener en cuenta es que un componente NO debe pasar por toda las fases, un componente puede ser montado y desmontado sin pasar por la fase de actualización o manejo de errores.

getDerivedStateFromError()

Una vez que se lanza un error este es el primer método que se llama, el cual recibe el error como argumento y cualquier valor devuelto en este método es utilizado para actualizar el estado del componente.

componentDidCatch()

Este método es llamado después de lanzarse un error y pasa como argumento el error y la información representada sobre el error.

--
¿qué es el estado en React? El estado es un objeto al cual le podemos definir variables que pueden ser de tipo string, número, booleanos o funciones. Y vamos a poder acceder dentro nuestro componente en el momento en el que se inicializa. Y esto nos va a permitir a nosotros tener elementos que vamos a usar. 

En React tú le llamarías onClick con la C mayúscula. Y en HTML sería todo en minúsculas llamado onClick.


--
npm init -y. La y significa que va a preconfigurar este documento y nos lo va a crear automáticamente Y después ya en nuestro editor de código vamos a editarlo. 

package-lock, que permite manejar el versionado de nuestros paquetes que estamos instalando. 
node_modules, que vienen siendo todos los elementos, en este caso paquetes y dependencias de nuestros elementos instalados

También tenemos la carpeta public, que tenemos un archivo index.html, que va a ser utilizado para publicarse cuando llegue el momento.

package.json, que nos va a permitir tener toda la historia de los elementos que hemos instalado, así como las configuraciones, scripts y cómo reconocer nuestro proyecto.

--
¿qué es Babel? 
Babel es una herramienta que vamos a utilizar nosotros los desarrolladores para crear JavaScript moderno y poderlo transformar a JavaScript que pueda ser compatible con todos los navegadores. 

instalar Babel y estos elementos que necesitamos para la configuración que vamos a crear. 
@babel/core
babel-loader 
@babel/preset-env
@babel/preset-react
--save-dev  (solo desarrollo)

configuración de Babel.
A este le vamos a llamar .babelrc

Y aquí vamos a crear un objeto con las configuraciones que previamente instalamos. 
Pero ¿qué instalamos? Fue Babel Core, que incluye todas las herramientas para transformar a código moderno nuestro JavaScript. 

También instalamos el Babel Loader, que se encarga de trabajar con Webpack. 
Así como dos Presets que nos van a ayudar a entender y transformar nuestro código. En este caso de JavaScript y también de React. 
@babel/preset-env
@babel/preset-react
Y uno nos va a servir para trabajar con ECMAScript cinco y seis. Y el otro para trabajar con lo que es JSX y React

--
instalar y configurar Webpack.

Esta herramienta nos va a ayudar a nosotros como desarrolladores a preparar nuestro proyecto para un entorno de desarrollo local o para mandarlo a producción. 

Se encarga de los archivos, en este caso de todos nuestros recursos en Javascript, HTML, CSS y multimedia. Los agrupa y los pone listos y optimizados para poderlos nosotros mandar a producción y crear este entorno óptimo de trabajo. 

npm install webpack. 
Requerimos también webpack-cli. Y un plugin que vamos a requerir para manejar archivos html. Utilizamos html-webpack-plugin.
Y un loader que se va a llamar html-loader. 

--save-dev. 

el archivo de Webpack, que va a tener toda la configuración que vamos a utilizar para nuestro proyecto.

webpack.config.js, donde va a vivir la configuración para todo nuestro proyecto. 

ver los cambios en tiempo real con Webpack es webpack-dev-server
--
SASS

Un preprocesador que nos va a permitir trabajar con CSS y añadirle unas bondades muy particulares. Como una de ellas sería las variables o trabajar con mixins.

mini-css-extract-plugin -> Este me va a permitir extraer el CSS del bundle resultante para poder crear un nuevo archivo de ese CSS. 
css-loader -> un loader que necesitamos
node-sass y un sass-loader -> compatibilidad con Sass 

Se guardan como dependencias de desarrollo
--


ESLint. 
Que es una herramienta que nos va a ayudar a nosotros a que no tengamos los errores que previamente tuvimos, sino que nos va a ayudar a detectar esos bugs, esos tipos o ayudarnos a que podamos tener un estándar dentro de nuestro código. 

instalar los paquetes que necesitamos. 
eslint
babel-eslint
eslint-config-airbnb
eslint-plugin-import
eslint-plugin-react -> se va a encargar de la parte del React. En este caso se revisaría nuestro código. 
eslint-plugin-jsx-a11y -> va añadir le accesibilidad a nuestros proyectos y que pueda detectarnos aquellos que sean necesarios para el navegador.

Webpack con Imagenes
npm install file-loader --save-dev

Fake-Json
npm install json-server -g
json-server (nombre del json)

React Hooks 

fue presentado en Octubre de 2018 en la React Conf de Las Vegas por Dan Abramov
da estado y ciclo de vida a nuestros componentes de tipo función o mejor conocidos como stateless

problemas con los componentes. -> se volvía una cascada de elementos. Y que era un poco más complejo transmitir las propiedades entre cada uno de estos elementos.

solo está disponible en la versión > 16.8 si estás trabajando con una versión anterior, no vas a poder implementar estas cualidades en nuestro proyecto si ya se tiene un proyecto que está en marcha y lo quisieras implementar, tendrías que evaluar muy bien el uso de esta tecnología, porque puede haber incompatibilidades con tu proyecto.


useEffect y useState
Con useState ->  manejar mi estado
useEffect -> hacer las transmisiones. Esto significa que puedo hacer peticiones de una API o algún evento que se tenga que transmitir dentro nuestros componentes, así como también estar escuchando algún cambio que vaya a ser necesario. 

//Lectura

Los React Hooks son una característica de React que tenemos disponible a partir de la versión 16.8. Nos permiten agregar estado y ciclo de vida a nuestros componentes creados como funciones.

El Hook useState nos devuelve un array con dos elementos: la primera posición es el valor de nuestro estado, la segunda es una función que nos permite actualizar ese valor.

El argumento que enviamos a esta función es el valor por defecto de nuestro estado (initial state).

```js
import React, { useState } from 'react';

const Component = () => {
  const [name, setName] = useState('Nombre por defecto');

  return <div>{name}</div>;
}
```

El Hook useEffect nos permite ejecutar código cuando se monta, desmonta o actualiza nuestro componente.

El primer argumento que le enviamos a useEffect es una función que se ejecutará cuando React monte o actualice el componente. Esta función puede devolver otra función que se ejecutará cuando el componente se desmonte.

El segundo argumento es un array donde podemos especificar qué propiedades deben cambiar para que React vuelva a llamar nuestro código. Si el componente actualiza pero estas props no cambian, la función no se ejecutará.

Por defecto, cuando no enviamos un segundo argumento, React ejecutará la función de useEffect cada vez que el componente o sus componentes padres actualicen. En cambio, si enviamos un array vacío, esta función solo se ejecutará al montar o desmontar el componente.

```js
import React, { useState, useEffect } from 'react';

const Component = () => {
  const [name, setName] = useState('Nombre por defecto');

  useEffect(() => {
    document.title = name;
    return () => {
      document.title = 'el componente se desmontó';
    };
  }, [name]);

  return <div>{name}</div>;
}
```