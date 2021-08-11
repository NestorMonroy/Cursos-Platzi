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

### Uso de Inputs y Outputs

Comunicación entre componentes

Los componentes pueden establecer comunicación entre ellos, de padre a hijo o viceversa.
@Input - De un componente padre a un hijo

Se puede enviar información de un componente padre a un componente hijo haciendo uso del @Input que es un decorador. Esto se realiza al invocar la etiqueta del componente hijo en el componente padre de la siguiente manera:
```html
<app-heroe-tarjeta [heroe]="heroe" [index]="i" *ngFor="let heroe of heroes; let i = index"></app-heroe-tarjeta>

```    
* “heroe” es el valor que está presente en el componente actual, en este caso es el index de la directiva *ngFor.
* [heroe] esstos valores provienen del componente hijo, son declarados en el archivo [TS] con el decorador input como se muestra en el siguiente fragmento de código.

```ts
import { Input } from '@angular/core';
..
export class HeroeTarjetaComponent implements OnInit {
    @Input() heroe:any = {};
    @Input() index:number;
    ..
}
```
@Output - Un evento de un componente hijo a un padre

Se puede enviar también un evento desde el hijo al padre haciendo uso del @Output que es un decorador. Esto se realiza declarando el output acompañado de un EventEmitter en el componente hijo.
```ts
import { Output, EventEmitter } from '@angular/core';
..
export class HeroeTarjetaComponent implements OnInit {
    ..
    // Se declara la variable y se la declara de tipo EventEmitter
    @Output() heroeSeleccionado:EventEmitter<number>;
    constructor() {
        // Se inicializa la variable en el constructor
        this.heroeSeleccionado = new EventEmitter();
    }
    // Función que se desea enviar al padre
    verHeroe() {
        this.heroeSeleccionado.emit( this.index );
    }
}

```
Mientras tanto, el componente padre se pone a “escuchar” el evento en cuestión en la etiqueta del componente hijo.

```html
<!-- heroeSeleccionado es el evento declarado en el hijo y se le envía la función deseada con el parámetro $event -->
<app-heroe-tarjeta (heroeSeleccionado)="verHeroe( $event )"></app-heroe-tarjeta>
```

### Ciclo de vida de los componente

Angular crea los componentes, los renderiza, crea y renderiza a sus hijos, actualiza y re-renderiza los componentes cuando detecta cambios y finalmente los destruye antes de eliminarlos del DOM.

Todo el ciclo de vida de los componentes, está gestionado por Angular.

Para trabajar con los componentes, Angular te da acceso a los momentos clave de su vida a través de unos callbacks, los denominados lifecycle hooks.

Los lifecycle hooks disponibles en Angular son:

* ngOnChanges(): Este hook se llama al inicio y cada vez que Angular detecta un cambio en los inputs del componente (cuando tienes algún property binding). Recibe como parámetro un objeto [SimpleChanges](https://angular.io/api/core/SimpleChanges), con los valores actuales y anteriores (si había) de los inputs.
* ngOnInit(): Este hook te permite inicializar el componente una vez ha recibido las propiedades de entrada.
* ngDoCheck(): Sirve para detectar y actuar sobre cambios que Angular no va a detectar por si mismo. Se llama también durante cada ciclo de detección de cambios, después de ngOnChanges().
* ngAfterContentInit(): Se ejecuta una sola vez, justo después de que Angular proyecte contenido externo en la vista del componente (con ng-content).
* ngAfterContentChecked(): Se ejecuta después de que Angular compruebe el contenido proyectado en el componente. Se ejecuta también durante los ciclos de detección de cambios, después de ngDoCheck().
* ngAfterViewInit(): Se llama una única vez, tras inicializar las vistas y sub-vistas del componente.
* ngAfterViewChecked(): Se llama después de comprobar los cambios de las vistas y sub-vistas del componente. Se ejecuta también durante el ciclo de detección de cambios, después de ngAfterContentChecked().
* ngOnDestroy(): Se llama solo una vez, justo antes de que Angular destruya el componente, y sirve para prevenir memory leaks, eliminando por ejemplo suscripciones a Observables e event handlers.


### Uso de ng generate y ng lint
```
ng lint
```
Revisa el código del proyecto para ver si se están cumpliendo las reglas definidas en el archivo tslint.json
```
ng lint --format json
```
Nos permite visualizar el resultado de la revisión con un formato json.
```
ng lint --fix
```
Corrige automáticamente, dentro de lo posible, los errores encontrados.

Generate

Genera automáticamente el componente en una carpeta con el mismo nombre que se le dio. Ademas lo importa automáticamente en al app.module.ts

Ejemplo:
```
 ng g c cart
#g = generate
#c = component

```    
ng lint

Es una herramienta que ayuda a mejorar la escritura de código con buenas prácticas.


### Usando los pipes de Angular

https://angular.io/api/common/DatePipe

Pipes


Los pipes son una herramienta de Angular que nos permite transformar visualmente la información, por ejemplo, cambiar un texto a mayúsculas o minúsculas, o darle formato de fecha y hora.
Angular trae una serie de pipes por defecto pero también nos permite construir nuestros propios pipes.
Las sintaxis propia de los pipes es: {{ variable | pipe-name }}.

Para el pipe de fecha, los datos nos los entrega en el formato inglés de fecha, para cambiarlo a español se deben realizar las siguientes modificaciones el el archivo app.module.ts.

→ [ app.module.ts ]
```ts
import { LOCALE_ID } from '@angular/core';
import localeEs from '@angular/common/locales/es';
import { registerLocaleData } from '@angular/common';
registerLocaleData(localeEs);

@NgModule({
    declarations: [ .. ],
    imports: [ .. ],
    providers: [
        { provide: LOCALE_ID, useValue: 'es' }
    ],
    bootstrap: [ .. ]

})
export class AppModule { }
```
También se pueden crear pipes personalizados, esto se puede hacer de forma manual o también haciendo uso del Angular-CLI.

```
$ ng generate pipe folder{path}/pipe{nombre}
$ ng g p pipes/domseguro
```

También se pueden crear pipes personalizados, esto se puede hacer de forma manual o también haciendo uso del Angular-CLI.

```
$ ng generate pipe folder{path}/pipe{nombre}
$ ng g p pipes/domseguro
```
