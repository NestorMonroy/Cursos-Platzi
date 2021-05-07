¿Qué es NPM (node package manager)? 

Es un gestor de paquetes, el más popular que tiene JavaScript, donde encontrarás una gran cantidad de recursos para poder implementar en tus proyectos. También vas a poder crear tus propios paquetes y compartirlos con toda la comunidad.

INICIAR UN PROYECTO NPM
Primero abrimos nuestra terminal y nos posicionamos donde guardamos nuestros archivos.
Podemos crear una carpeta para nuestro proyecto con el comando
mkdir project_name nos movemos dentro de la carpeta con cd project_name ya dentro de la carpeta podemos iniciar:

Primeros pasos

npm init: con este comando vamos a crear nuestro archivo de configuración del proyecto, el package.json
Luego nos saldrá lo siguiente
package name: el nombre de nuestro proyecto, generalmente es el nombre de la carpeta
version: version con la que iniciaremos el proyecto, generalmente aparece 1.0.0
description: descripcion breve del proyecto
entry point: punto de acceso a nuestro proyecto
test command: comando para gestionar los test
git repository: repositorio de github u otro servicio
keywords: palabras claves del proyecto
author**: nombre del autor y < correo > **license`: licencia que tendrá el proyecto

<h3>2da opción (para hacer package rápido)</h3>
Escribimos npm init -y y esto generará un package.json vacio para que lo configuremos más adelante.

<h3>3ra opción (configuramos algunos elementos)</h3>
Escribimos en nuestra terminal
npm set init.author.email "your@email"
npm set init.author.name "your name"
npm set init.license "license name"
npm init -y
Y se creará un package.json con los datos que seleccionamos.


–save : Este documento que vas a instalar dentro del proyecto es necesario para vivir en producción. Hay que tener cuidado con los paquetes que instalamos, cuando es a producción y cuando no lo es.

npm i -S moment 

–save-dev: Este documento que vamos a instalar solo es necesario en nuestro entorno local o en el de desarrollo. Es importante no mandar dependencias a producción ni omitir algunas que deban de estar en producción.

npm i -D moment


Paquetes de forma global
sudo npm install -g nodemon

Ver paquetes instalados de forma global
npm list -g --depth 0


Instalación de dependencias con force
Simula la instalacion para tener un output para decidir si instalarlo
npm install react --dry-run

Instalacion forzada
npm install webpack -f

Como reinstalar todos los paquetes y dependencias
Este comando toma el archivo package.json e intala todo lo que tiene en el.
npm install

Instalacion de una version en particular
npm install json-server@0.15.0

Actualizar paquetes
Revisar que paquetes disponen de nuevas versiones
npm outdate

Para ver un output más detallado
npm outdate --dd

Actualizar los paquetes que no están en la ultima versión
npm update

Actualizar un paquete especifico
npm install json-server@latest

Eliminar paquetes

Eliminar un paquete de node_modules y del archivo package.json
npm uninstall json-server

Desinstalar un paquete de todo node_modules pero no del archivo package.json
npm uninstall webpack --no-save

<h3>Versionado Semántico</h3>
En el versionado tenemos 3 dígitos que significa:

Primer dígito: son cambios mayores
Segundo dígito: añaden ciertas funcionalidades pero no representan un gran paso para decir que esta es una versión nueva
Tercer dígito: estos son patch, bug fixes o cambios menores
*Cuando tenemos el símbolo (^) catet dentro de la configuración del package.json estamos garantizando que cuando nosotros hagamos una actualización o tengamos un cambio que podamos realizar, vamos a hacer actualizacion solo de los cambios menores y de los parches o bug fix de este paquete.

*también podemos establecer una tilde (~) esto quiere decir que vamos a recibir actualización o cambios que son parch o bug fixes.

*Lo recomendo si queremos tener el control sobre estas actualizacion garantizando que nos queremos quedar en cierta versión lo mejor es elimina el caret (^)

Package-lock.json a partir de la versión 5 npm encontramos este archivo que nos permite tener ciertas configuraciones la cual nos permite saber que esta sucediendo a lo largo de nuestro proyecto sabiendo que versiones, que paquetes y que dependencias se encuentran en este, permitiendonos tener un versionado uno poco mas establecido, podremos compartir este documento con los demás desarrolladores y garantizar que las versiones que se están instalando sean las correctas, al igual nos sirve para cuando los proyectos estén en la nube y nuestro servidor instale de manera automática todas estas dependencias