Notas

* Para verificar versión de Node JS: node -v
* Para verificar versión de NPM: npm -v
* Para verificar versión de Angular: ng version
* Para instalar Angular Framework:
    - npm i -g @angular/cli
    - npm install -g @angular/cli (-g de manera global)
* Para ver lista de comandos: ng
* Para crear un nuevo proyecto: ng new projectName
* Para correr la aplicación: ng Serve




Existen opciones adicionales para montar el servidor

Monta el servidor y abre el navegador por defecto.
- $ ng serve -o

Monta el servidor en un puerto diferente.
- $ ng serve --port 3692

Iniciar el servidor en local.
-$ ng serve

Alistar una app a producción.
-$ ng build --prod 


### String interpolation

String Interpolation sirve para renderizar variables {{ variableName }} que contiene TS que se ejecuta por angular y la salida se inserta en el HTML .
Entonces, si colocamos {{ 1 + 1 }} la plantilla, el número 2 se insertaría en el HTML .

En un h1 seria asi:
```html
<h1>{{ title }}</h1> <!-- Renderiza el título exportado en el archiv ts -->
<p>
  Las suma de 2 + 2 = {{ 2 + 2 }} <!-- 4 -->
</p>


```

### Data binding (ngModel)

Enlace de datos desde el componente hasta el template. Los cambios que haga en la template por input se almacenan en el componente.

app.module.ts
```ts
import { FormsModule }from '@angular/forms';

@NgModule({
  imports: [
    FormsModule
  ],
})

```


```html
<input [(ngModel)]="title"> 
  {{title}}
```

### ngIf
Muestra el titulo solo si tiene contenido

```HTML
    <div  *ngIf="title !== '' " > 
       <span>{{ title }} app is running!</span>
    </div>
```
Por ejemplo, siendo un if normalito de javascript, las validaciones se pueden hacer directamente con booleanos y también cuando alguna variable tiene el valor undefined.

```html
<div *ngIf="true">
  Esto es un div true
</div>
<!--Esto no se ve-->
<div *ngIf="!true">
  Esto es un div !true
</div>

<div *ngIf="undefined">
  Esto es un div undefined
</div>
<!--y esto tampoco se ve-->
<div *ngIf="!undefined">
  Esto es un div !undefined
</div>
```

### ngFor

Iteración de array. Se puede iterar por el índice
.componet.html
```ts
export class AppComponent {

  items = ['nestor', 'joel', 'example0']
 
  addItem() {
    this.items.push('Nuevo item')
  }

  deleteItem(index: number){
    this.items.splice(index, 1);
  }
}


```



```html
<button (click)="addItem()" >Add item</button>

<ul>
  <li *ngIf="items.length === 0 ">La lista esta vacia</li>
  <li *ngFor="let name of items; index as i">
    {{name}} - {{i}}
    <button (click)="deleteItem(i)">delete</button>
  </li>
</ul>

```
Generar acciones
Va dentro de parentesis y tiene un método(que se declara como función en app.components.ts).


### Uso de ngFor para recorrer objetos

Directiva [*ngFor]

Esta directiva permite generar iteraciones de elementos HTML. Posee partes obligatorias y opcionales.
Las partes obligatorias son:

* Declaración de la variable que contiene el valor de la iteración.
* Utilizar la palabra of.
* Variable a iterar.

Las partes opcionales son:

* Indice de la iteración.
* Imprimir la variable que contiene el valor de la iteración con data binding.

Sintaxis de la directiva *ngFor:

→ [ file.component.html ]
```html
<ul class="list-group">
		<!-- elemento que se quiere repetir -->
    <li *ngFor="let personaje of personajes; let i = index" class="list-group-item">
        {{ i + 1 }}. {{ personaje }}
    </li>
</ul>

```
→ [ file.component.ts ]
```ts
export class exampleComponent {
		personajes: string[] = ["Spiderman", "Venom", "Dr. Octopus"];
}

```
Cuando se tenga un objecto dentro del componente

```
objecto = {};
```
Esto no es iterable y sale error con ngFor
<!-- <div *ngFor="let item of objecto" ></div> Error ya que es un objecto-->


### ngSwitch

El funcionamiento de esta directiva es exactamente igual que el de un switch de programación, donde el resultante de una expresión definirá cuál es el elemento del DOM (el tag) que se mostrará. Para ello se utilizan los atributos ngSwitch igualado a una variable definida en código (la cual será la que cambie su valor) y los atributos *ngSwitchCase igualados a los posibles valores que puede tomar la variable. Cuándo la variable tome el valor de uno de los *ngSwitchCase se mostrará el tag asignado. También se puede incluir un tag con el atributo *ngDefaultSwitch para que se muestre siempre y cuando el valor de la variable no está contemplado en ninguno de los casos.
Sintaxis de la directiva *ngSwitch:

→ [ file.component.html ]
```html
<span [ngSwitch]="alerta">
		<p *ngSwitchCase="'success'">success</p>
    <p *ngSwitchCase="'info'">info</p>
    <p *ngSwitchCase="'warning'">warning</p>
    <p *ngSwitchDefault>Danger</p>
</span>

```
→ [ file.component.ts ]

```ts
export class NgSwitchComponent implements OnInit {
    alerta: string = 'info';
    ...
}

```

### ¿Qué son los componentes y decoradores?

Componentes

Un componente en Angular es una combinación de un archivo HTML con un TS y algunas veces SCSS para crear un elemento con características propias tanto de comportamiento como de apariencia que se puede mostrar en un navegador.
Básicamente los componentes son clases normales con un decorador específico.

Creación de un componente con la línea de comandos:
```
$ ng generate component folder{path}/component{nombre}

```
Se puede abreviar el comando de esta manera:
```
$ ng g c components/footer

```
El comando utilizado de esta manera genera cuatro archivos que son:

*name.component.sass → archivo para trabajar los estilos específicos del componente.
* name.component.html → archivo que contendré el template del componente.
* name.component.spec.ts → archivo para pruebas (no es abarcado en esta sección).
* name.component.ts → archivo de TypeScript que maneja la lógica del componente.

Creación de un componente de forma manual:

* Se crea el template, que sería un archivo HTML → example.component.html

* Se crea el archivo de lógica, que sería el archivo TS → example.component.ts
```ts
    import { Component } from '@angular/core'

    @Component({
    		// Nombre de la etiqueta que llamará al componente
        selector:'app-header',
    		// Template HTML, se mostrará cuándo la etiqueta sea llamada
        templateUrl: './header.component.html'
    })

    export class ExampleComponent { ... }

```
* Se exporta el componente al archivo app.module.ts y se añade a las declaraciones.
```ts
import { ExampleComponent } from './components/example/example.component'

@NgModule({
    declarations: [
        ...
        ExampleComponent
        ...
    ]
    ...
})
export class AppModule { }

```