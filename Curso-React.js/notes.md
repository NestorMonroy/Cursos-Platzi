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
    <p>Soy nestor</p>
  </div>
)

const element = React.createElement(
  'div',
  {},
  React.createElement('h1', {}, 'Hola'),
  React.createElement('p', {}, 'Soy nestor')
)
const container = document.getElementById('app');

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
 
