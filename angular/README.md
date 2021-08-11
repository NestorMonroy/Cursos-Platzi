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
