#### ¿Por qué usar un sistema de control de versiones como Git?

Un sistema de control de versiones como Git nos ayuda a guardar el historial de cambios y crecimiento de los archivos de nuestro proyecto.

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


### Comandos git

|Comando| Resumen                  |
|-------------|--------------------------|
|git init     |inicializa el repositorio de git |
|git add       | Agrega todos los cambios en todos los archivos al área de staging|
|git status | lo usamos para saber si tenemos un archivo añadido o borrado en nuestro proyecto, para saber en la rama en la que estamos y si tenemos commits. |
|git rm “nombre del archivo”   | lo usamos para borrar un archivo que hayamos añadido|
|git rm “nombre del archivo” --cached | para eliminarlo por completo de nuestra rama usamos|
|git commit -m  ""| se usa para añadir un commit a nuestra rama, también podemos ponerle un -m seguidamente ponemos entre comillas nuestro mensaje |
|git push | envía los cambios al repositorio remoto |
|git pull | Agrega los cambios del commit más nuevo al repositorio local|
|git config | ver la configuración de git|
|git config --list| ver la configuración actual de git|
|git config --list --show-origin| ver donde esta guardada la configuracion|
|git config --global user.name "Tu Nombre" |Configura tu nombre de usuario|
|git config --global user.email "tu@email.com" |Configurar tu email|
|git log |Muestra toda la historia|
|git log --stat | Cambios especificos a los archivos, apartir del commit|
|git log “nombre del archivo” | Muestra el historial de ese archivo|
|git show | Muestra el ultimo commit de la rama todos los cambios históricos hechos y sus detalles (qué cambió, cuándo y quién los hizo)|
|git show “nombre del archivo” | Muestra todos los cambios del archivo|
|git diff | Para ver los cambios entre tu entorno de trabajo y tu área de ensayo (staging)|
|git diff | Git diff [referencia del commit escogido]: Al solo poner un solo parámetro (commit), comparara la versión inicial con la actual|
|git checkout "numero de commit" "nombre del archivo" | me permite devolver en el tiempo un archivo a una version anterior sin borrar la actual o simplemente toda la carpeta
para que me muestre la version anterior en un archivo en especifico debo indicar al final el nombre del archivo |
|git checkout master |vuelve la rama al commit de master |
|git merge |combina dos versiones|
|git reset "numero de commit" --hard| devuelve el projecto y elimina TODO lo realizado posteriormente a la version a la que estamos volviendo |
|git reset "numero de commit" -- soft| elimina los archivos del commit pero mantiene los archivos que tenemos en staging|

staging es el estado temporal donde agregas estados antes del repositorio (memoria ram)

### El flujo de Gitflow es así:

* En la rama master tendremos solo lo que se ha liberado.

* Se crea la rama develop, es la rama en la que estamos trabajando (lo que vamos a liberar).

* Liberar a producción con tu equipo de trabajo se crea una release desde develop.

* No se pasa directo de develop a master, Git Flow crea la nueva rama de release.

* Por cada petición o tarea se genera una rama llamada feature a partir de develop.

* Por ejemplo una pantalla nueva, se crea y está completa el feature de pantalla se cierra y se afusiona con develop.

* Cuando tienes la rama release terminada, fusionas con develop y master.

*Si hay problema en master se crea hotfix que son los cambios sobre algo que está en producción.

* Se crea una nueva rama se trabaja y se reintegra. Una vez que hotfix se completa, se fusiona a ambos develop y master.
