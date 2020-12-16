React

Es una biblioteca, ella vas cree para construir interfaces de usuario.

Es declarativo

Se le indica que debe hacer pero no como debe hacerse, ahorrando de esta manera muchos pasos

//
index.js es el punto de entrada de la aplicacion

babel -> traduce javaScript

```js
// const jsx = <h1>Hola!</h1>
// const element = React.createElement(
//   'a',
//   {href: 'http://www.google.com'},
//   'Ir a google'

// )

// const name = 'Nestor'
// const suma = () => 2+2;
// //const element = React.createElement('h1', {}, `hola soy ${name}`)
// //{__expresiones__}
// //Si son
// const jsx = <h1>Hola soy, {name}  {suma()} </h1>

const jsx = (
  <div>
    <h1>Hola</h1>
    Soy nestor
  </div>
);

const element = React.createElement(
  "div",
  {},
  React.createElement("h1", {}, "Hola"),
  React.createElement("p", {}, "Soy nestor")
);
const container = document.getElementById("app");

ReactDOM.render(element, container);
```

componentes -> son bloques de construcción.
Los componentes son como nuestros pequeños bloques

en la web -> Los componentes van a hacer lo que forman WebSite,
El componente es una clase y el elemento es un objeto Es decir, el elemento sale de la clase. El elemento sale del componente

Si en JSX tenemos código que está dentro de brackets {} => Esos son elementos.
Si no usamos esos brackets son componente.

Pero si si seguimos la primera pregunta es qué elementos se repiten de nuevo?
Tenemos dos días. Aquellos elementos que estén en una lista son buenos candidatos y aquellos elementos que comparten un aspecto visual o de funcionalidad.

Si estamos en la lista que tenemos casas Cada una de sus elementos de una lista sale un componente.

Está entre una lista, se repite. Es un perfecto candidato para hacer componente y aquellos que se vean igual y que trabaje igual son componentes

Tenemos también las componentes que hacen una función muy específica sirven para encapsular lógica y además nos permiten hacer muchas cosas en un solo componente.

Ejemplo la barra de búsqueda es un componente. Es mucho más complejo que los demás porque interactúa mucho con el usuario, salen resultados. Hace peticiones, te regresa Links, le das click y te vas a otro página.

Todo eso Es como encapsula trabajo dentro. Una función una, la función esa suponen que hacen cosas muy específicas. Nuestros componentes van a hacer lo mismo.

Los componentes en React tienen vida; nacen, crecen y desaparecen.

El ciclo de vida de los componentes tiene 3 fases :
1- El Montaje es cuando los usuarios llegan a nuestra aplicación, cuando tienen su 1era interacción con él.
2- La Actualización , es cuando se ejecuta el render, generando el nuevo DOM, es cuando React manda una señal de actualización componentDidUpdate() .
3- Eliminación de los componentes, al entrar a otra página, varios componentes no estarán en ella, React manda la señal componentWIllUnmount(), seguido de la eliminación del código en el DOM.

Props

Argunmentos a una funcion

Eventos dentro del formulario

click -> evento que se desencadena al hacer click sobre el elemento
onChange -> evento que se desencadena al tener un cambio en valor del elemento (handleChange para manejar los cambios en los valores de los inputs)
onSubmit -> evento que se desencadena al ejecutar el submit de formulario

Las aplicaciones que se trabajan en React son llamadas single page apps. Esto es posible gracias a React Router que es una librería Open Source

Multi Page Apps: Cada página implica una petición al servidor. La respuesta usualmente tiene todo el contenido de la página

Single Page Apps (SPA): Aplicaciones que cargan una sola página de HTML y cualquier actualización la hacen re-escribiendo el HTML que ya tenían.

React Router tiene 4 componentes principales:

Browser Router. Es necesario colocar el componente en la parte superior de la aplicación, lo que esté dentro de este va a servir como una Single Page App y les va a permitir al resto de las herramientas funcionar. Ya que fuera de él NO Funciona.

Route. Representa una dirección de Internet, el path es donde va arenderizar el componente y el componente es el componente que va arenderizar, usualmente es un a página.

Switch. Componente que nos sirve para representar 1 sola ruta de variasque podemos poner dentro del componente.

Link. Toma el lugar del elemento ancla, evita que se recarguecompletamente la página, actualiza la URL sin recargar la páginacompleta.

Cuando su estado cambia o recibe unos props diferentes se actualiza.
Cuando cambiamos de página y ese componente ya no está, decimos que se desmontó

Montaje:

Representa el momento donde se inserta el código del componente en el DOM

Se llaman tres métodos:
constructor, render y componentDidMount

Cuando decimos que se monta el componente, significa que React está introduciendo el código que lo representa en el DOM. El ++DOM ++es este documento HTML que representa la página que estamos viendo.

El constructor es el lugar perfecto para inicializar estado, o para inicializar valores.

El render es el momento preciso donde React va a calcular el elemento que representa este componente y lo va a introducir en el código.

Una vez eso ocurra, React va a llamar a una señal, el método componentDidMount. Cuando componentDidMount se llama, nuestro componente ya es visible en pantalla (ya está su código en el DOM).

Actualización:

Ocurre cuando los props o el estado del componente cambia.

Se llaman dos métodos: render y componentDidUpdate.

Cuando los props o el state del componente cambia, ocurre una actualización.

El componente vuelve a renderizarse, pues su información cambió, así que posiblemente su aspecto visual es otro. Por ende, hay que volver a renderizar. Esto también aplica a cualquier componente descendiente de este componente.

Como segundo paso de la actualización, React va a llamar a otra señal, el método componentDidUpdate. Este método va a recibir dos argumentos: los props que tenía anteriormente y el estado que tenía anteriormente. Esto nos va a servir por si queremos comparar con la versión anterior del componente y la versión actual.

Desmontaje:

Nos da la oportunidad de hacer limpieza de nuestro componente.

Se llama sólo un método: componentWillUnmount.

Es cuando el componente sale de escena, desaparece de la pantalla, cuando por ejemplo se navega de una página a otra y ya no está ese código.
React llama a la señal componentWillUnmount, que es lugar perfecto para limpiar memoria, a veces podemos usar timeout o intervalos, que si no cancelamos hará que perdamos memoria en el componente, cosa que debemos evitar

Una llamada a una API tiene tres estados

Una promesa

Loading
=>
Error
||
Data
Without data {}
||
With data {…}

Es vital indicar que se está cargando
Si no hay data es vital hacer un CTA para introducir data

https://storyset.com/

md5

Polling -> consiste en que cada cierto tiempo que es definido por nosotros se buscan los datos y se actualizan automaticamente. Esto se hara constantemente hasta que el usuario se vaya de la pagina

Funciones no tiene un estado propio, no tiene ciclo de vida

las Clases si

Portales => Elemento fuera del nodo principal de la aplicacion

Los hooks son un feature de React que permite que un componente funcional use las propiedades que tiene un componente de clase, es decir, puede acceder al manejo de estado, usar los ciclos de vida, entre otros.

Tenemos hooks básicos como:

- useState → para manejos de estados.
- useEffect → para acceder a los ciclos de vida.
- useReducer → para ejecutar un efecto basado en una acción.

Hay dos reglas para usar hooks:

Los hooks deben ser llamados en la parte superior de los componentes funcionales, no puedes usar hooks dentro del loops o condicionales.

Todos los hooks deben ser nombrados e indentificados con la palabra use al principio.

Usando useState

Este hook viene de React (el cual ya está importado en nuestro componente), para acceder a el usamos React.useState(argumentoOpcional) y vamos a guardar la información que nos proporcione dentro de un array (porque este hook siempre regresa un array), así:

```js
const [count, setCount] = React.useState(0)

<button
    onClick={() => {setCount(count + 1)}}>
     Incrase count: {count}

</button>
```

El argumento opcional hace referencia al estado inicial (en este caso = 0) el cual se va a guardar en count.

Al hacer click en el button se va a llamar a una función anónima la cual a su vez hace un llamado a setCount, cuya función es actualizar el estado, es decir, el count. Esto lo hace leyendo el estado actual y sumando 1.

Crear nuestro propio Hook

Podemos usar el mismo ejemplo. Para crear un hook usamos (por fuera de la función proncipal del componente) una función que recibe argumentos opcionales y dentro de esta, hacemos el llamado al hook useState().

```js
function useIncreaseCount(max) {
  const [count, setCount] = React.useState(0);

  if (count > max) {
    setCount(0);
  }
  return [count, setCount];
}
```

El argumento será un máximo y dentro del hook irá una condición → si count (el estado) supera al máximo, setCount (setState) lo regresa a 0. Al final, el hook siempre va a regresar el array con count y setCount, los cuales serán usados más adelante. ¿Dónde? pues dentro de la función principal, será el array que guarde el resultado del llamado al componente useIncreaseCount que acabamos de crear. Lo demás quedará igual.

```js
const [count, setCount] = useIncreaseCount(4);
<button
  onClick={() => {
    setCount(count + 1);
  }}
>
  Incrase count: {count}
</button>;
```
