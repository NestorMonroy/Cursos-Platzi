#### Migrando de Angular 7 a Angular 8

https://update.angular.io/


sudo npm i -g @angular/cli@latest
ng update


### Que es Ivy

Es un motor de render en el que el equipo de angular ha estado trabajando como la gran novedad.

trae como ventajas:

* aplicaciones mas pequeñas
* compilaciones mas rápidas
* debugging mas simple y exacto
* Ivy es amable con la aplicación y al compilar elimina código y paquetes de angular sin utilizar

https://angular.io/guide/ivy


### Differential loading

Differential Loading es un proceso mediante el cual el navegador elige entre Javascript moderno o heredado en función de sus propias capacidades, es decir se crean dos paquetes a compilar uno para los navegadores modernos que permiten ES2015 > y un paquete para navegadores legacy o antiguos que solo admiten la versión de ES5 de Javascript.

El navegador cargará automáticamente el paquete que le corresponda, gracias al soporte de los módulos de ES6 en los navegadores más nuevos, por lo que tendrán que cargar menos código y cargar una cantidad mucho menor de polyfills.


### Dynamic import

Es la forma nativa en la que precarga Javascript de forma nativa los módulos.

### CLI Builders


CLI builders: Son aquellos que nos habilitan extender las funcionalidades del cliente de comandos de Angular (sobretodo correr tareas y correrlas a nuestro modo).
3 categorías de comandos:

* Tareas de creación y modificación de código. ng new, ng generate, ng add, ng update.
* Tareas simples. ng help, ng version, ng doc
* Tareas complejas. ng serve, ng build, ng test, ng lint.
* los comandos de tareas complejas se abren para extender y hacerlo a nuestro manera. Ej. @angular/fire y @azure/ng-deploy


### Patrón LIFT (Locate, Identify, Flat and Try DRY) y Naming

El patrón LIFT lleva la escalabilidad desde las buenas prácticas que Angular propone para mantener un proyecto organizado y estandarizado.

* Locate: Expresa que debe haber una facilidad de encontrar los componentes, directivas, pipes, servicios, etc en la estructura del proyecto.
* Identify: Se trata de reconocer rápidamente el rol que cumple cada uno de los archivos, es decir, colocarle ‘ apellido’ al archivo.
* Flat: Mantener la estructura de nuestro proyecto de forma plana, con máximo 3 niveles de profundidad en la estructura de carpetas del proyecto.
* Try DRY: Alienta la reutilización de código con el fin de tener un proyecto mantenible.

### Aplicando el patrón: Smart and Dumb components

* Components = Renderizar (Inputs, Outputs)
* Containers = Fetch (buscan datos) y mandan a renderizar en los componentes
* Dumb component: debe encargarse de la parte visual e interactiva
* Smart component: trae datos para mandarlos a al dump component

Los dump components tienene de apellido .component y los smart compnents .container

### REDUX

Resuelve toda la arquitectura y el manejo de datos en un sólo sentido.