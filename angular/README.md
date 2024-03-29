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

## Guardianes


Si quieren saber mas de guardianes visiten https://codingpotions.com/angular-seguridad 

CanActivate : Mira si el usuario puede acceder a una página determinada.
CanActivateChild :  Mira si el usuario puede acceder a las páginas hijas de una determinada ruta.
CanLoad :Sirve para evitar que la aplicación cargue los módulos perezosamente si el usuario no está autorizado a hacerlo.

### Creando vistas con Angular schematic

Schematics es una forma de crear archivos o reglas desde el CLI (command line interfaces), material ya tiene incluídos algunos schematics muy útiles para poder crear componentes de uso regular.

Para poder crear un schematic tienes que tener instalado 'angular/cdk', mismo que viene por defecto al instalar Angular desde el CLI, pero que se tiene que instalar si no llegasen a funcionar los comandos.

Los schematics generan código, así que busca en la documentación que quieres crear y pégalo en la línea de comandos, por ejemplo:

ng generate @angular/material:dashboard admin/components/dashboard

ng generate @angular/material:table admin/components/list-products

ng generate @angular/material:navigation admin/components/nav

ng generate @angular/material:address-form admin/components/product-form


### HtttpClient

La mayoría de las aplicaciones front-end se comunican con los servicios de back-end a través del protocolo HTTP. Los navegadores modernos admiten dos API diferentes para realizar solicitudes HTTP: la interfaz XMLHttpRequest y la API fetch(), pero Angular implementa su propia interfaz basada en XMLHttpRequest para facilitar el fetching de datos, api expuesta por los navegadores.


HttpClient viene desde @angular/common/http y ofrece una interfaz API HTTP de cliente simplificada para aplicaciones Angular.



Los beneficios adicionales de HttpClient incluyen:

* Suite de pruebas simplificadas
* Requests y responses tipados
* Intercepción de requests y responses
* Observables
* Manejo de errores optimizado (mediante streams)


Para trabajar con HttpClient tenemos que crear un objeto de tipo HttpClient:
```ts
import { HttpClient } from '@angular/common/http';
export class ProductsService {
  constructor( private http: HttpClient ) {}
}
```
HttpClient provee métodos http basados en los verbos de protocolos http, por lo tanto podemos facilitar una capa de servicios que implemente los métodos específicos de cada acción http:
```ts
export class ProductsService {
  ...
  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${environment.url_api}/products`);
  }
  ...
}
```

Algunos de los métodos que podríamos utilizar son:

* http.get
* http.post
* http.put
* http.patch
* http.put


Por lo tanto así se vería una capa de servicios en Angular basados en HttpClient
```ts
@Injectable({ providedIn: 'root' })
export class ProductsService {

  constructor( private http: HttpClient ) {}

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${environment.url_api}/products`);
  }
  getProduct(id: string): Observable<Product> {
    return this.http.get<Product>(`${environment.url_api}/products/${id}`);
  }
  createProduct(product: Product): any {
    return this.http.post(`${environment.url_api}/products`, product);
  }
  updateProduct(id: string, changes: Partial<Product>): any {
    return this.http.put(`${environment.url_api}/products/${id}`, changes);
  }
  deleteProduct(id: string): any {
    return this.http.delete(`${environment.url_api}/products/${id}`);
  }
}
```

#### Ambientes en Angular

Un entorno de aplicación en Angular (environment) es información de configuración JSON que le dice al sistema de compilación qué archivos cambiar cuando usa ng build y ng serve.
.
La recomendación es hacer ambientes dentro del directorio environments/environment.[nombre].ts, y para registrarlo necesitas modificar el archivo angular.json
.
Para agregar un nuevo ambiente al angular.json se necesitan duplicar el environment de build y de serve dentro de projects.<project-name>.architect.build.configurations.nameOfNewEnvironment y de projects.<project-name>.architect.serve.configurations.production y cambiar production por el nombre que quieras que reciba tu environment, como staging o local, etc.
.
Recuerda que es muy delicado este archivo y que lo tienes que hacer a conciencia, además de que tienes que colocar la ruta de tu archivo de environments en fileReplacements, porque lo que hace este archivo es reemplazar las ocurrencias de importación de src/environments/environment.ts por el archivo de ambiente que le indiques.
```ts
{
  projects: {
    nameOfProject: {
      ...
      architect: {
        build: {
          ...
          production: {} <-- Duplicar este objeto
        },
        serve: {
          configurations: {
            ...
            production: {} <-- Duplicar este objeto
          }
        }
      }
    }
  }
}
```

ng serve -c=stag
ng build -c=stag


### Formularios Reactivos

Los formularios reactivos ayudan a manejar entradas de formulario cuyos valores cambian con un enfoque explícito e inmutable para administrar el estado de un formulario en un momento dado.

Los formularios reactivos difieren de los formularios basadas en plantillas en los siguientes puntos.

* Las formas reactivas son predecibles al ser síncronas con el modelo de datos 
* Son inmutables, por lo tanto cada cambio en el estado del formulario devuelve un nuevo estado,   seguimiento de cambios a través de streams observables. 
* Proporcionan una ruta directa a las pruebas porque tiene la seguridad de que sus datos son consistentes y predecibles cuando se solicitan. 
*Cualquier consumidor de los streams tiene acceso para manipular estos datos de manera segura 
* Se construyen alrededor de observable streams

Además proveen métodos más sencillos para:

* La validación de datos
* Realización de pruebas unitarias: porque tienes la seguridad de que sus datos son consistentes y predecibles al momento de solicitarlos.
*Tener lógicas más complejas

FormControl.

Un input de tipo FormControl permite la anidación de validadores (ValidatorFn) con los que podemos de manera sencilla validar la fuente de datos.

```ts
FormControl(
  formState?: any, 
  validatorOrOpts?: ValidatorFn | ValidatorFn[] | AbstractControlOptions, 
  asyncValidator?: AsyncValidatorFn | AsyncValidatorFn[]
): FormControl
```

Se definen detro de una variable de tipo FormControl() y se pueden llamar en el template:

component.component.ts
```ts
export class Component implements OnInit {
  emailField: FormControl;
  constructor() {
    this.emailField =  new FormControl('', [
      Validators.required,
      Validators.maxLength(50),
      Validators.minLength(4),
      Validators.email,
      Validators.pattern(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/)
    ]);
  }
}
```

<!-- component.component.html -->
```html
<input type="email" [formControl]="emailField">
{{ emailField.valid }} <!-- Imprime true o false si el input es válido -->

```

RxJS Operators 

https://rxjs-dev.firebaseapp.com/guide/operators

-----------------

Según el siguiente bloque de código en un template de Angular:
<h1>{{ 1 + ‘1’ }}</h1>
¿Cuál es el resultado correcto?
R= Un elemento H1 con el valor 11

¿Cuál es la forma correcta de obtener el índice iterador en un ngFor en un template de Angular?
R= <element *ngFor="let item of items; index as i"></element>

Para crear una barra de navegación tipo side con Angular Material ¿Cuál es el comando para generarlo?
R= ng generate @angular/material:nav <component-name>

¿Cuál es la forma de enlazar un template al componente por medio del decorador?
R= @Component({ selector:'app-footer', templateUrl:'./footer.component.html', })

¿Cuál es la forma correcta de declarar un condicional en un template Angular?
R= <element *ngIf="conditional"></element>

¿Cúal es el comando para hacer un deploy a Firebase Hosting?
R= firebase deploy

¿Cuál es la manera correcta de tipar una solicitud GET?
R= this.http.get<type>('url')

Si quiero que un input[text] sea requerido y además tenga mínimo 10 caracteres, ¿cuál sería el array correcto?
R= [Validators.required, Validators.minLength(10)]


¿Qué método se usa en los Guards para permtir la entrada a una ruta?
R= canActivate

¿En qué orden correcto en que se ejecutan estos métodos según el ciclo de vida de un componente?
R= 1.constructor 2.ngOnInit 3.ngOnDestroy

¿Cuál tipo de Typescript me permite definir solo la parte de un modelo?
R= const product: Partial<product>;

¿Cuál es la directiva para mostrar activo un link de acuerdo a la ruta?
R= <a routerlinkactive="active">My Link</a>

¿Cuál es la directiva para manejar un caso por defecto en un ngSwtich?
R= *ngSwitchDefault

¿Cuál es la ruta por defecto para controlar cuando una url no hace match?
R= { path: '**', component: PageNotFoundComponent }

¿Cuál de estos pipes cumple con la función de mostrar un string al revés? ejemplo: {{ 'hola' | reverse }} // aloh
R= transform(value: string): string { return value.split('').reverse().join(''); }

¿Cuál es el módulo que de debe importar en app.module para habilitar el uso de HttpClient?
R= HttpClientModule

¿Cuál es la forma correcta de instalar Angular CLI?
R= npm i -g @angular/cli

¿Cuál es la forma correcta del uso de async?
R= {{ element$ | async }}

¿Cuál es la forma correcta de crear un Observable para manejar valores y comunicarlos a través de un servicio?
R= new BehaviorSubject<product[]>([]);</product[]>

¿Cuál es la forma correcta de obtener los parámetros de una ruta?
R= this.route.params.subscribe((params: Params) => { console.log(params); });

¿Con qué comando puedes crear un nuevo proyecto en Angular?
R= ng new nameProject


¿Cuál es la forma correcta de generar una compilacion a producción para un ambiente el ambiente stag?
R= ng build --prod -c=stag


¿Cuál de las siguientes afirmaciones explican LazyLoading?
R= Fragmenta la aplicación en módulos para luego hacer la carga de cada uno.

¿Con cuál comando del Angular CLI puedo generar un componente?
R= ng g c my-component

¿Si quieres instalar una lib que tenga CSS dónde debes agregar sus archivos de estilos?
R = En el archivo angular.json en el array de styles

¿Cuál es la función de los inputs en los componentes?
R = Su función es enviar datos desde un componente padre a un componente hijo.

¿Cuál es la forma de leer los cambios de un FormControl?
R = field.valueChanges.subscribe()


¿Cuál es el comando para instalar y configurar de forma automatica Angular Material en una aplicación Angular?
R = ng add @angular/material

¿Cuál es la forma de pasar valores ya definidos a un FormGroup?
R= form.patchValue(values)

Si pongo un servicio en un SharedModule, ¿cuál es la consecuencia?
R =  Por cada módulo que importe el SharedModule sea crea una unica instancia para el modulo que lo importo 
-------------
