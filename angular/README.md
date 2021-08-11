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

### Data binding

Enlace de datos desde el componente hasta el tamplate. Los cambios que haga en la templete por input se almacenan en el componente.

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

