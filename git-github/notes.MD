#### ¿Por qué usar un sistema de control de versiones como Git?

Un sistema de control de versiones como Git nos ayuda a guardar el historial de cambios y crecimiento de los archivos de nuestro proyecto.

* git init -> inicializa el repositorio de git
* git add -> Agrega todos los cambios en todos los archivos al área de staging
* git status -> Para ver el estado de la BD sí se han hecho cambios, pero no se han agregado, ahí saldrá
* git show -> Muestra todos los cambios históricos hechos y sus detalles (qé cambió, cuándo y quién los hizo)
* git log “nombre del archivo” -> Muestra el historial de ese archivo
* git commit -m -> Agrega definitivamente los cambios hechos al repositorio, se puede poner un comentario para indicar que cambió
git push -> envía los cambios al repositorio remoto
- git pull -> Agrega los cambios del commit más nuevo al repositorio local

Git solo funciona con texto plano

#### Introducción a la terminal y línea de comandos


|Comando| Resumen                  |
|-------|--------------------------|
|pwd    |nos muestra el path o ruta de la carpeta en donde nos encontramos ubicados |
|cd     |permite acceder (entrar) a una carpeta en un nivel o varios niveles  | 
|cd ..  | me permite salir de una carpeta en un nivel o varios niveles OJO los dos puntos deben ser separados por un espacio del comando cd |
|ls     |me muestra los archivos que contiene una carpeta, puede ser la ubicación actual o una ruta especifica, no muestra los archivos ocultos|
|ls -a  |  me muestra los archivos que contiene una carpeta, puede ser la ubicación actual o una ruta especifica, incluyendo los archivos ocultos |
|ls -l  | lista los archivos que contiene una carpeta con sus atributos, puede ser la ubicación actual o una ruta especifica, no muestra los archivos ocultos|
|ls -la | me lista los archivos que contiene una carpeta con sus atributos, puede ser la ubicación actual o una ruta especifica, incluyendo los archivos ocultos|
|clear  | limpiar la consola o terminal, o un shorcut crtl + L |
|mkdir <nombre carpeta> |nos permite crear una carpeta |
| touch <nombre del archivo> |nos permite crear un archivo |
| cat <nombre del archivo> | me permite visualizar el contenido del un archivo y lo muestra en el terminal |
| history | nos muestra un historial de los comandos que hemos utilizado|
|rm <nombre del archivo> |me permite borrar un archivo |
|comando -- help| obtener informacion sobre un comando en especifico|


