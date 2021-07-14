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
|git add       | Agrega todos los cambios en todos los archivos al área de staging|
|git checkout "numero de commit" "nombre del archivo" | me permite devolver en el tiempo un archivo a una version anterior sin borrar la actual o simplemente toda la carpeta
                                                        para que me muestre la version anterior en un archivo en especifico debo indicar al final el nombre del archivo |
|git checkout master |vuelve la rama al commit de master |
|git clone url_del_servidor_remoto| Nos permite descargar los archivos de la última versión de la rama principal y todo el historial de cambios en la carpeta .git|
|git commit -am | automaticanmente hace el commit, con los cambios|
|git commit -m  ""| se usa para añadir un commit a nuestra rama, también podemos ponerle un -m seguidamente ponemos entre comillas nuestro mensaje |
|git config | ver la configuración de git|
|git config --list| ver la configuración actual de git|
|git config --list --show-origin| ver donde esta guardada la configuracion|
|git config --global user.name "Tu Nombre" |Configura tu nombre de usuario|
|git config --global user.email "tu@email.com" |Configurar tu email|
|git diff | Para ver los cambios entre tu entorno de trabajo y tu área de ensayo (staging)|
|git diff | Git diff [referencia del commit escogido]: Al solo poner un solo parámetro (commit), comparara la versión inicial con la actual|
|git fetch| Lo usamos para traer actualizaciones del servidor remoto y guardarlas en nuestro repositorio local|
|git init     |inicializa el repositorio de git |
|git log |Muestra toda la historia|
|git log “nombre del archivo” | Muestra el historial de ese archivo|
|git log --stat | Cambios especificos a los archivos, apartir del commit|
|git log --oneline|Te muestra el id commit y el título del commit|
|git log --decorate|Te muestra donde se encuentra el head point en el log.|
|git log --stat |Explica el número de líneas que se cambiaron brevemente|
|git log -p|Explica el número de líneas que se cambiaron y te muestra que se cambió en el contenido|
|git log --graph --oneline --decorate y
git log --pretty=format:"%cn hizo un commit %h el dia %cd"|Muestra mensajes personalizados de los commits.|
|git log -3|Limitamos el número de commits.|
|git log --after=“2018-1-2” , git log --after=“today” y git log --after=“2018-1-2” --before=“today”|Commits para localizar por fechas.|
|git log --author=“Name Author”|Commits realizados por autor que cumplan exactamente con el nombre.|
|git log --grep=“INVIE” |Busca los commits que cumplan tal cual está escrito entre las comillas.|
|git log --grep=“INVIE” –i|Busca los commits que cumplan sin importar mayúsculas o minúsculas.|
|git log – index.html|Busca los commits en un archivo en específico.|
|git log -S “Por contenido”|Buscar los commits con el contenido dentro del archivo.|
|git log > log.txt|guardar los logs en un archivo txt|
|git shortlog|Indica que commits ha realizado un usuario, mostrando el usuario y el titulo de sus commits|
|git push | envía los cambios al repositorio remoto |
|git pull | Agrega los cambios del commit más nuevo al repositorio local Básicamente, git fetch y git merge al mismo tiempo|
|git reset "numero de commit" --hard| devuelve el projecto y elimina TODO lo realizado posteriormente a la version a la que estamos volviendo |
|git reset "numero de commit" -- soft| elimina los archivos del commit pero mantiene los archivos que tenemos en staging|
|git rm “nombre del archivo”   | lo usamos para borrar un archivo que hayamos añadido|
|git rm “nombre del archivo” --cached | para eliminarlo por completo de nuestra rama usamos|
|git show | Muestra el ultimo commit de la rama todos los cambios históricos hechos y sus detalles (qué cambió, cuándo y quién los hizo)|
|git show “nombre del archivo” | Muestra todos los cambios del archivo|
|git status | lo usamos para saber si tenemos un archivo añadido o borrado en nuestro proyecto, para saber en la rama en la que estamos y si tenemos commits. |


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


### Git reset vs. Git rm

Git reset y git rm son comandos con utilidades muy diferentes, pero aún así se confunden muy fácilmente.

#### git rm
Este comando nos ayuda a eliminar archivos de Git sin eliminar su historial del sistema de versiones. Esto quiere decir que si necesitamos recuperar el archivo solo debemos “viajar en el tiempo” y recuperar el último commit antes de borrar el archivo en cuestión.

Recuerda que git rm no puede usarse así nomás. Debemos usar uno de los flags para indicarle a Git cómo eliminar los archivos que ya no necesitamos en la última versión del proyecto:

* git rm --cached: Elimina los archivos del área de Staging y del próximo commit pero los mantiene en nuestro disco duro.
* git rm --force: Elimina los archivos de Git y del disco duro. Git siempre guarda todo, por lo que podemos acceder al registro de la existencia de los archivos, de modo que podremos recuperarlos si es necesario (pero debemos usar comandos más avanzados).

#### git reset

Este comando nos ayuda a volver en el tiempo. Pero no como git checkout que nos deja ir, mirar, pasear y volver. Con git reset volvemos al pasado sin la posibilidad de volver al futuro. Borramos la historia y la debemos sobreescribir. No hay vuelta atrás.

Este comando es muy peligroso y debemos usarlo solo en caso de emergencia. Recuerda que debemos usar alguna de estas dos opciones:

Hay dos formas de usar git reset: con el argumento --hard, borrando toda la información que tengamos en el área de staging (y perdiendo todo para siempre). O, un poco más seguro, con el argumento --soft, que mantiene allí los archivos del área de staging para que podamos aplicar nuestros últimos cambios pero desde un commit anterior.

* git reset --soft: Borramos todo el historial y los registros de Git pero guardamos los cambios que tengamos en Staging, así podemos aplicar las últimas actualizaciones a un nuevo commit.
* git reset --hard: Borra todo. Todo todito, absolutamente todo. Toda la información de los commits y del área de staging se borra del historial.

¡Pero todavía falta algo!

* git reset HEAD: Este es el comando para sacar archivos del área de Staging. No para borrarlos ni nada de eso, solo para que los últimos cambios de estos archivos no se envíen al último commit, a menos que cambiemos de opinión y los incluyamos de nuevo en staging con git add, por supuesto.

### ¿Por qué esto es importante?

Imagina el siguiente caso:

Hacemos cambios en los archivos de un proyecto para una nueva actualización. Todos los archivos con cambios se mueven al área de staging con el comando git add. Pero te das cuenta de que uno de esos archivos no está listo todavía. Actualizaste el archivo pero ese cambio no debe ir en el próximo commit por ahora.

¿Qué podemos hacer?

Bueno, todos los cambios están en el área de Staging, incluido el archivo con los cambios que no están listos. Esto significa que debemos sacar ese archivo de Staging para poder hacer commit de todos los demás.

¡Al usar git rm lo que haremos será eliminar este archivo completamente de git! Todavía tendremos el historial de cambios de este archivo, con la eliminación del archivo como su última actualización. Recuerda que en este caso no buscábamos eliminar un archivo, solo dejarlo como estaba y actualizarlo después, no en este commit.

En cambio, si usamos git reset HEAD, lo único que haremos será mover estos cambios de Staging a Unstaged. Seguiremos teniendo los últimos cambios del archivo, el repositorio mantendrá el archivo (no con sus últimos cambios pero sí con los últimos en los que hicimos commit) y no habremos perdido nada.

Conclusión: Lo mejor que puedes hacer para salvar tu puesto y evitar un incendio en tu trabajo es conocer muy bien la diferencia y los riesgos de todos los comandos de Git.


### Introducción a las ramas o branches de Git

Las ramas son la forma de hacer cambios en nuestro proyecto sin afectar el flujo de trabajo de la rama principal. Esto porque queremos trabajar una parte muy específica de la aplicación o simplemente experimentar.

La cabecera o HEAD representan la rama y el commit de esa rama donde estamos trabajando. Por defecto, esta cabecera aparecerá en el último commit de nuestra rama principal. Pero podemos cambiarlo al crear una rama (git branch rama, git checkout -b rama) o movernos en el tiempo a cualquier otro commit de cualquier otra rama con los comandos (git reset id-commit, git checkout rama-o-id-commit).