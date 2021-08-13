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


### Construyendo una directiva propia
```
ng g d directives/highlight/highlight

```


Para crear una directiva
ng generate directive <name>
ng g directive <name>

Las directivas tienen un selector que es como su identificador el cual se debe colocar en las etiquetas como atributos.
Ejemplo:
selector = ‘[appTabRequired]’

En el constructor tendremos que hacer la inyeccion de dependencia ElementRef
```
constructor( element: ElementRef) {
   element.nativeElement.style.color = 'red';
}
```


### RUTAS EN ANGULAR

En el archivo app-routing-module.ts se encuentra un objeto Route el cual sirve para incrustar las rutas del proyecto.

La sintaxis dentro del router ```(app-routing-module.ts)```:
```
import { componentName } from './url/to/componentName.component';

const routes: Routes = [
  {
    path = ‘routeName’,
    component = componentName
  },
]
  
```
Donde:

* path = ruta relativa al home (’/’) de nuestra app
* component = componente importado desde componentName.component.ts

La forma de implementar el router en un template.html es con el componente router-outlet:
```
<!-- app.component.html -->

<router-outlet></router-outlet>
```

Donde el router-outlet se reemplazará por el contenido del componente según la URL en la que estés
Páginas no encontradas (not-found)

Para definir una página no encontrada podemos utilizar la ruta '**' que simboliza cualquier ruta diferente a las anteriormente definidas, el componente también deberá de ser el objeto del componente importado.
```
  {
    path: '**',
    component: NotFoundComponent
  }
```

Nota: El orden de las rutas es importante, si algo matchea una ruta, no se segirá a la siguiente, por lo que el not-found, debería de ser la última ruta, siempre

Redirecciones

Para las redirecciones tenemos que usar las propiedades redirectTo:'route' y pathMatch:'full'

```
  {
    path: 'from',
    redirectTo: 'to',
    pathMatch: 'full'
  },
```
Donde:
* path: Página actual
* redirectTo: página a la que se redireccionará
* pathMatch: tipo de match, en el caso de ‘full’ será con una relación exacta

Redirecciones sin recargar routerLink

Para poder movernos entre rutas sin recargar nuestra página (tipo single page application) debemos agregar a nuestras anclas ‘<a>’ la directiva routerLink envés del atributo href para que Angular determine que no haga una recarga de la página.
```html
<div>
     <a routerLink="/home">Home</a> <!-- Antes <a href="/home">Home</a> -->
</div>
```
Ancla activa routerLinkActive

Puedes definir una clase para cuando una ruta matchee completamente al agregar la directiva routerLinkActive, misma que agregará una clase al elemento que contenga un routerLink, de esta manera en los estilos podrás acceder al elemento seleccionado.
.
La recomendación es llamar “active” al routerLinkActive (routerLinkActive="active">), de esta manera podrás acceder desde el css mediante la clase .active

html
```html
<nav>
    <a routerLink="/home" routerLinkActive="active">Home</a>
    <a routerLink="/products" routerLinkActive="active">Products</a>
    <a routerLink="/contact" routerLinkActive="active">Contact</a>
</nav>

scss
```scss
nav a {
  padding: 5px;
  text-decoration: none;
  &.active {
    background-color: papayawhip;
  }
}

```
Así se vería un app-routing.module.ts completo:

```ts
... // importaciones
const routes: Routes = [
  {
    path: 'home',
    redirectTo: '',
    pathMatch: 'full'
  },
  {
    path: '',
    component: HomeComponent
  },
  {
    path: '**',
    component: NotFoundComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

```

## routerLink

En Angular existe una directiva llamada routerLink, con ella se evita que se recargue la pagina cada vez que navegamos entre las rutas, manteniendo nuestro proyecto como una ‘Single Page Application’. La forma de aplicarlo es cambiar las referencias href en html por routerLink.


```
Inicial:
<div>
    <a href="/home">Home</a>
</div>

routerLink

<div>
    <a routerLink="/home">Home</a>
</div>

routerLinkActive
```
Esta directiva le asigna una clase determinada a la etiqueta html si y solo si esta parado en la ruta definida con routerLink, por lo general esta es “active”. Con esto podemos asignar estilos para esta clase en particular.

html
```html
<nav>
    <a routerLink="/home" routerLinkActive="active">Home</a>
    <a routerLink="/products" routerLinkActive="active">Products</a>
    <a routerLink="/contact" routerLinkActive="active">Contact</a>
</nav>

```
```css

nav > a {
    padding: 5px;
    text-decoration: none;
}

nav > a.active {
    background-color: blue;
}

```

En este ejemplo las etiquetas ‘nav > a’ aplican un estilo en particular, pero cuando tienen asignado la clase ‘active’ se les aplica un decorador adicional.


Servicios
Los servicios proveen datos esencialmente. La forma de crear un servicio es en la terminal con los comandos ‘ng g s nombreServicio’.
Por lo general tenemos 2 métodos esenciales en los servicios, uno para obtener todos los objetos guardados en una variable, y otro para obtener 1 objeto especifico.
```ts
export class someService {

  store = [
    {
      id: '1',
      title: 'title',
      price: 10,
    },
    {
      id: '2',
      title: 'title',
      price: 20,
    }
  ];

  constructor() { }

  getAllStored() {
    return this.store;
  }

  getStored(id: string) {
    return this.store.find(item => id === item.id);
  }
}
/*
    El método getAllStored() devuelve todos los objetos almacenados en la variable.

    El método getStored() devuelve 1 objeto especifico almacenado en la variable, en este caso se utiliza la variable id para buscar este objeto.
  *
```

Componente para objetos
A veces es necesario crear componentes para desplegar la información de un solo objeto que provee un servicio. Para eso creamos un componente en la terminal con el comando ‘ng g c nombreComponente’

Luego de esto debemos asignarle una ruta en el archivo de routing, pero en esta ocasión tendrá un parámetro dinámico que se enviará.
```ts
const routes: Routes = [
    {
      path: 'home',
      component: HomeComponent
    },
    {
      path: 'product',
      component: ProductComponent
    }
    {
      path: 'product/:id',
      component: ProductDetailComponent
    }

];
```
En el componente creado debemos realizar 2 importaciones de dependencias, estos son ‘ActivatedRoute’ y ‘Params’ de ‘@angular/router’. Nota: no olvidar que las inyecciones de dependencia deben ingresarse como parámetro en el constructor.
```ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {

  constructor(
    private route: ActivatedRoute
  ) { }

  ngOnInit() {};

}
```
Desde el ngOnInit() es la forma adecuada de recibir el parámetro definido anteriormente en la ruta, y se suscribe a el por si existen cambios, esto para ejecutar los cambios en la pagina por si cambia la ruta. La variable definida en la suscripción es de tipo Params que fue importado anteriormente.
```ts
ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      const id = params.id;
      console.log(id);
    });
  }
```
En el método anterior capturamos el valor de id en params. Es importante aclarar que params es un json.

Ahora para consultar los objetos de un servicio debemos importar el servicio en sí. Con ello tendremos acceso a sus datos y métodos. Los servicios son inyecciones de dependencia, por lo que hay que ingresarlos en el constructor.
```ts
import { ProductsService } from './../products.service';

constructor(
        private route: ActivatedRoute,
        private productsService: ProductsService
) { }
```
El servicio importado en este caso tiene un método que devuelve un objeto especifico en formato json que se busca a través de su id, por ello se solicita una variable de entrada que se utiliza para buscar dicho objeto. En el siguiente caso se guarda el objeto en una variable y se imprime por consola.
```ts
ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      const id = params.id;
      const product = this.productsService.getProduct(id);
      console.log(product);
    });
  }
```

### Vistas Anidadas

A veces existen componentes que se utilizan en varios otros componentes, para esto existe la técnica de vistas anidadas, la cual consiste en crear un componente que albergue los elementos que se repiten y los otros componentes que los utilizan serán rutas hijas del componente creado anteriormente.

Primero creamos el componente que almacena los elementos con el comando ‘ng g c nombreComponente’

Luego en los archivos del componente se almacenan los elementos que se utilizaran repetitivamente en otros componentes. En el archivo html se utiliza la etiqueta router-oulet para renderizar los componentes que se quieren cargar, y los elementos repetitivos se especifican.
```html
<app-header></app-header>

<router-outlet></router-outlet>

<app-footer></app-footer>
```
En el archivo routing se incorpora el componente creado anteriormente en la variable de routes, pero esta vez todos los componentes que se basen en este deberán estar anidadas. Para anidarlos el objeto del componente creado tendrá que tener una nueva característica ‘children’, el cual tendrá los ‘path’ y ‘component’ de las rutas que se basen en la anterior.
```ts
const routes: Routes = [
    {
      path: '',
      component: LayoutComponent,
      children: [
        {
          path: '',
          redirectTo: '/home',
          pathMatch: 'full',
        },
        {
          path: 'home',
          component: HomeComponent
        },
        {
          path: 'products',
          component: ProductsComponent
        },
        {
          path: 'products/:id',
          component: ProductDetailComponent
        },
        {
          path: 'contact',
          component: ContactComponent
        },
      ]
    },
    {
      path: 'demo',
      component: DemoComponent
    },
    {
      path: '**',
      component: PageNotFoundComponent
    }
  ];
```

### Lazy Loading
Ésta técnica se encarga de fragmentar el archivo generado main.js para que cargue más rápido la aplicación, basada en la técnica “divide y vencerás”, cargando siempre el código JavaScript necesario para que la vista funcione de manera adecuada.

Con ésto claro, un pre-requisito fundamental es modularizar la aplicación. Un módulo encapsula varios elementos de la aplicación (components, directivas, servicios, etc)

Modularizando home:

```
Crear archivo home/home.module.ts

ng g module components/home

Crear carpeta home/components
Copiar y pegar los componentes que el módulo home va a utilizar
Eliminar el componente del array de declarations de otros módulos e importarlo al módulo creado
Crear el routing para el módulo Home. En angular cada módulo debe tener un routing
cd src/app/components/home
ng g module home-routing --flat --module=home
```