#### ¿Por qué usar un sistema de control de versiones como Git?

Un sistema de control de versiones como Git nos ayuda a guardar el historial de cambios y crecimiento de los archivos de nuestro proyecto.

Git solo funciona con texto plano

#### Introducción a la terminal y línea de comandos

| Comando| Resumen|
------------- | -------------
| pwd | nos muestra el path o ruta de la carpeta en donde nos encontramos ubicados|
| cd | permite acceder (entrar) a una carpeta en un nivel o varios niveles                                                                                    |
| cd ..                      | me permite salir de una carpeta en un nivel o varios niveles OJO los dos puntos deben ser separados por un espacio del comando cd                      |
| ls                         | me muestra los archivos que contiene una carpeta, puede ser la ubicación actual o una ruta especifica, no muestra los archivos ocultos                 |
| ls -a                      | me muestra los archivos que contiene una carpeta, puede ser la ubicación actual o una ruta especifica, incluyendo los archivos ocultos                 |
| ls -l                      | lista los archivos que contiene una carpeta con sus atributos, puede ser la ubicación actual o una ruta especifica, no muestra los archivos ocultos    |
| ls -la                     | me lista los archivos que contiene una carpeta con sus atributos, puede ser la ubicación actual o una ruta especifica, incluyendo los archivos ocultos |
| clear                      | limpiar la consola o terminal, o un shorcut crtl + L                                                                                                   |
| mkdir <nombre carpeta>     | nos permite crear una carpeta                                                                                                                          |
| touch <nombre del archivo> | nos permite crear un archivo                                                                                                                           |
| cat <nombre del archivo>   | me permite visualizar el contenido del un archivo y lo muestra en el terminal                                                                          |
| history                    | nos muestra un historial de los comandos que hemos utilizado                                                                                           |
| rm <nombre del archivo>    | me permite borrar un archivo                                                                                                                           |
| comando -- help            | obtener informacion sobre un comando en especifico                                                                                                     |

### Comandos git

| Comando| Resumen|
------------- | -------------
| git add| Agrega todos los cambios en todos los archivos al área de staging|
| git branch "nombre_rama"| Crear una nueva rama|
| git branch -l| Lista todas las ramas existentes|
| git branch -d "nombre_rama"| Elimina la rama con -D se fuerza el borrado|
| git branch -m "nombre_rama" "nuevo_nombre_rama" | Permite renombrar el nombre de la rama|
| git checkout "numero de commit" "nombre del archivo" | me permite devolver en el tiempo un archivo a una version anterior sin borrar la actual o simplemente toda la carpeta para que me muestre la version anterior en un archivo en especifico debo indicar al final el nombre del archivo |
| git checkout nombre_rama | permite moverse entre ramas  |
| git checkout -b nombre_rama | Crea una nueva rama nombre_rama y se posiciona en ella.|
| git checkout master | vuelve la rama al commit de master|
| git clone url_del_servidor_remoto| Nos permite descargar los archivos de la última versión de la rama principal y todo el historial de cambios en la carpeta .git|
| git commit -am | Agrega los archivos a git repository desde el working directory, solo funciona si a los archivos se les a hecho git add previamente |
| git commit -m ""| se usa para añadir un commit a nuestra rama, también podemos ponerle un -m seguidamente ponemos entre comillas nuestro mensaje |
| git config| ver la configuración de git|
| git config --list| ver la configuración actual de git|
| git config --list --show-origin | ver donde esta guardada la configuracion|
| git config --global user.name "Tu Nombre" | Configura tu nombre de usuario|
| git config --global user.email "tu@email.com" | Configurar tu email|
| git diff | Para ver los cambios entre tu entorno de trabajo y tu área de ensayo (staging)|
| git diff| Git diff [referencia del commit escogido]: Al solo poner un solo parámetro (commit), comparara la versión inicial con la actual|
| git fetch | Lo usamos para traer actualizaciones del servidor remoto y guardarlas en nuestro repositorio local|
| git init| inicializa el repositorio de git |
| git log| Muestra toda la historia|
|git log --all| muestra toda la historia |
| git log “nombre del archivo”| Muestra el historial de ese archivo|
| git log --stat| Cambios especificos a los archivos, apartir del commit|
| git log --oneline| Te muestra el id commit y el título del commit|
| git log --decorate| Te muestra donde se encuentra el head point en el log.|
| git log --stat| Explica el número de líneas que se cambiaron brevemente|
| git log -p| Explica el número de líneas que se cambiaron y te muestra que se cambió en el contenido|
|git log --graph |Muestra como han funcionado las ramas|
|git log --graph --oneline --decorate|Muestra la historia decorada|
|git log --pretty=format:"%cn hizo un commit %h el dia %cd"|Muestra mensajes personalizados de los commits.|
|git log -3|Limitamos el número de commits.|
|git log --after=“2018-1-2” , git log --after=“today” y git log --after=“2018-1-2” --before=“today”|Commits para localizar por fechas.|
|git log --author=“Name Author”|Commits realizados por autor que cumplan exactamente con el nombre.|
|git log --grep=“INVIE” |Busca los commits que cumplan tal cual está escrito entre las comillas.|
|git log --grep=“INVIE” –i|Busca los commits que cumplan sin importar mayúsculas o minúsculas.|
|git log – index.html|Busca los commits en un archivo en específico.|
|git log -S “Por contenido”|Buscar los commits con el contenido dentro del archivo.|
|git log > log.txt|guardar los logs en un archivo txt|
|git shortlog|Indica que commits ha realizado un usuario, mostrando el usuario y el titulo de sus commits|
|git merge|[combinar lo del repositorio remoto con mi directorio de trabajo] [combinar ramas]|
|git push | envía los cambios al repositorio remoto |
|git push origin --tags|Publicar un tag en el repositorio remoto|
|git pull | Agrega los cambios del commit más nuevo al repositorio local Básicamente, git fetch y git merge al mismo tiempo|
|git reset "numero de commit" --hard| devuelve el projecto y elimina TODO lo realizado posteriormente a la version a la que estamos volviendo |
|git reset "numero de commit" -- soft| elimina los archivos del commit pero mantiene los archivos que tenemos en staging|
|git rm “nombre del archivo” | lo usamos para borrar un archivo que hayamos añadido|
|git rm “nombre del archivo” --cached | para eliminarlo por completo de nuestra rama usamos|
|git stash|guarda el trabajo actual del Staging en una lista diseñada para ser temporal llamada Stash, para que pueda ser recuperado en el futuro|
|git stash apply stash@{<num_stash>}|Para retomar los cambios de una posición específica del Stash, Donde el <num_stash> lo obtienes desden el git stash list|
|git stash clear|eliminar todos los elementos del stash|
|git stash save "mensaje identificador del elemento del stashed"|Podemos poner un mensaje en el stash, para asi diferenciarlos|
|git stash list|Listado de elementos en el stash|
|git stash pop|recuperar los últimos cambios desde el stash a tu staging|
|git stash pop stash@{<num_stash>}|Para aplicar los cambios de un stash específico y eliminarlo del stash|
|git stash branch <nombre_de_la_rama>|Crear una rama con el stash|
|git stash branch nombre_de_rama stash@{<num_stash>}|crear una rama y asignarla a un stash específico |
|git stash drop|Eliminar elementos del stash|
|git stash drop stash@{<num_stash>}|si se conoce el índice del stash que quieres borrar (mediante git stash list),Donde el <num_stash> es el índice del cambio guardado.|

|git show | Muestra el ultimo commit de la rama todos los cambios históricos hechos y sus detalles (qué cambió, cuándo y quién los hizo) muestra el HEAD|
| git show-branch|Muestra la historia de las ramas|
| git show-branch --all|Muestra mas informacion|
|git show “nombre del archivo” | Muestra todos los cambios del archivo|
|git status | lo usamos para saber si tenemos un archivo añadido o borrado en nuestro proyecto, para saber en la rama en la que estamos y si tenemos commits. |
|git tag -a nombre-del-tag -m "Mensage del tag" id-del-commit|Crear un nuevo tag y asignarlo a un commit|
|git tag -d nombre-del-tag|Borrar un tag en el repositorio local|
|git tag o git show-ref --tags|Listar los tags de nuestro repositorio local|
|git tag -d nombre-del-tag | Borrar un tag del repositorio remoto|
|git push origin :refs/tags/nombre-del-tag|Borrar un tag del repositorio remoto|


staging es el estado temporal donde agregas estados antes del repositorio (memoria ram)

### El flujo de Gitflow es así:

- En la rama master tendremos solo lo que se ha liberado.

- Se crea la rama develop, es la rama en la que estamos trabajando (lo que vamos a liberar).

- Liberar a producción con tu equipo de trabajo se crea una release desde develop.

- No se pasa directo de develop a master, Git Flow crea la nueva rama de release.

- Por cada petición o tarea se genera una rama llamada feature a partir de develop.

- Por ejemplo una pantalla nueva, se crea y está completa el feature de pantalla se cierra y se afusiona con develop.

- Cuando tienes la rama release terminada, fusionas con develop y master.

\*Si hay problema en master se crea hotfix que son los cambios sobre algo que está en producción.

- Se crea una nueva rama se trabaja y se reintegra. Una vez que hotfix se completa, se fusiona a ambos develop y master.

### Git reset vs. Git rm

Git reset y git rm son comandos con utilidades muy diferentes, pero aún así se confunden muy fácilmente.

#### git rm

Este comando nos ayuda a eliminar archivos de Git sin eliminar su historial del sistema de versiones. Esto quiere decir que si necesitamos recuperar el archivo solo debemos “viajar en el tiempo” y recuperar el último commit antes de borrar el archivo en cuestión.

Recuerda que git rm no puede usarse así nomás. Debemos usar uno de los flags para indicarle a Git cómo eliminar los archivos que ya no necesitamos en la última versión del proyecto:

- git rm --cached: Elimina los archivos del área de Staging y del próximo commit pero los mantiene en nuestro disco duro.
- git rm --force: Elimina los archivos de Git y del disco duro. Git siempre guarda todo, por lo que podemos acceder al registro de la existencia de los archivos, de modo que podremos recuperarlos si es necesario (pero debemos usar comandos más avanzados).

#### git reset

Este comando nos ayuda a volver en el tiempo. Pero no como git checkout que nos deja ir, mirar, pasear y volver. Con git reset volvemos al pasado sin la posibilidad de volver al futuro. Borramos la historia y la debemos sobreescribir. No hay vuelta atrás.

Este comando es muy peligroso y debemos usarlo solo en caso de emergencia. Recuerda que debemos usar alguna de estas dos opciones:

Hay dos formas de usar git reset: con el argumento --hard, borrando toda la información que tengamos en el área de staging (y perdiendo todo para siempre). O, un poco más seguro, con el argumento --soft, que mantiene allí los archivos del área de staging para que podamos aplicar nuestros últimos cambios pero desde un commit anterior.

- git reset --soft: Borramos todo el historial y los registros de Git pero guardamos los cambios que tengamos en Staging, así podemos aplicar las últimas actualizaciones a un nuevo commit.
- git reset --hard: Borra todo. Todo todito, absolutamente todo. Toda la información de los commits y del área de staging se borra del historial.

¡Pero todavía falta algo!

- git reset HEAD: Este es el comando para sacar archivos del área de Staging. No para borrarlos ni nada de eso, solo para que los últimos cambios de estos archivos no se envíen al último commit, a menos que cambiemos de opinión y los incluyamos de nuevo en staging con git add, por supuesto.

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

### Fusión de ramas con Git merge

El comando git merge nos permite crear un nuevo commit con la combinación de dos ramas (la rama donde nos encontramos cuando ejecutamos el comando y la rama que indiquemos después del comando).
un merge es un commit--

```py
# Crear un nuevo commit en la rama master combinando
# los cambios de la rama cabecera:
git checkout master
git merge cabecera
```

```py
# Crear un nuevo commit en la rama cabecera combinando
# los cambios de cualquier otra rama:
git checkout cabecera
git merge cualquier-otra-rama
```

Asombroso, ¿verdad? Es como si Git tuviera super poderes para saber qué cambios queremos conservar de una rama y qué otros de la otra. El problema es que no siempre puede adivinar, sobretodo en algunos casos donde dos ramas tienen actualizaciones diferentes en ciertas líneas en los archivos. Esto lo conocemos como un conflicto y aprenderemos a solucionarlos en la siguiente clase.

Recuerda que al ejecutar el comando git checkout para cambiar de rama o commit puedes perder el trabajo que no hayas guardado. Guarda tus cambios antes de hacer git checkout.

### Resolución de conflictos al hacer un merge

Git nunca borra nada a menos que nosotros se lo indiquemos. Cuando usamos los comandos git merge o git checkout estamos cambiando de rama o creando un nuevo commit, no borrando ramas ni commits (recuerda que puedes borrar commits con git reset y ramas con git branch -d).

Git es muy inteligente y puede resolver algunos conflictos automáticamente: cambios, nuevas líneas, entre otros. Pero algunas veces no sabe cómo resolver estas diferencias, por ejemplo, cuando dos ramas diferentes hacen cambios distintos a una misma línea.

Esto lo conocemos como conflicto y lo podemos resolver manualmente, solo debemos hacer el merge, ir a nuestro editor de código y elegir si queremos quedarnos con alguna de estas dos versiones o algo diferente. Algunos editores de código como VSCode nos ayudan a resolver estos conflictos sin necesidad de borrar o escribir líneas de texto, basta con hundir un botón y guardar el archivo.

Recuerda que siempre debemos crear un nuevo commit para aplicar los cambios del merge. Si Git puede resolver el conflicto hará commit automáticamente. Pero, en caso de no pueda resolverlo, debemos solucionarlo y hacer el commit.

Los archivos con conflictos por el comando git merge entran en un nuevo estado que conocemos como Unmerged. Funcionan muy parecido a los archivos en estado Unstaged, algo así como un estado intermedio entre Untracked y Unstaged, solo debemos ejecutar git add para pasarlos al área de staging y git commit para aplicar los cambios en el repositorio.

------
Desde el 1 de octubre de 2020 GitHub cambió el nombre de la rama principal: ya no es “master” -como aprenderás en el curso- sino main.

git branch -M main

-M = mueve todos los cambios existentes en tu rama master a la nueva rama main

-----

### Uso de GitHub

GitHub es una plataforma que nos permite guardar repositorios de Git que podemos usar como servidores remotos y ejecutar algunos comandos de forma visual e interactiva (sin necesidad de la consola de comandos).

Luego de crear nuestra cuenta, podemos crear o importar repositorios, crear organizaciones y proyectos de trabajo, descubrir repositorios de otras personas, contribuir a esos proyectos, dar estrellas y muchas otras cosas.

El README.md es el archivo que veremos por defecto al entrar a un repositorio. Es una muy buena práctica configurarlo para describir el proyecto, los requerimientos y las instrucciones que debemos seguir para contribuir correctamente.

Para clonar un repositorio desde GitHub (o cualquier otro servidor remoto) debemos copiar la URL (por ahora, usando HTTPS) y ejecutar el comando git clone + la URL que acabamos de copiar. Esto descargara la versión de nuestro proyecto que se encuentra en GitHub.

Sin embargo, esto solo funciona para las personas que quieren empezar a contribuir en el proyecto. Si queremos conectar el repositorio de GitHub con nuestro repositorio local, el que creamos con git init, debemos ejecutar las siguientes instrucciones:

```py
# Primero: Guardar la URL del repositorio de GitHub
# con el nombre de origin
git remote add origin URL

# Segundo: Verificar que la URL se haya guardado
# correctamente:
git remote
git remote -v

# Updates were rejected because the remote constains work that you do not have locally

git pull origin master

# Tercero: Traer la versión del repositorio remoto y
# hacer merge para crear un commit con los archivos
# de ambas partes. Podemos usar git fetch y git merge
# o solo el git pull con el flag --allow-unrelated-histories:
git pull origin master --allow-unrelated-histories

# Por último, ahora sí podemos hacer git push para guardar
# los cambios de nuestro repositorio local en GitHub:
git push origin master

```

### Cómo funcionan las llaves públicas y privadas

Las llaves públicas y privadas nos ayudan a cifrar y descifrar nuestros archivos de forma que los podamos compartir sin correr el riesgo de que sean interceptados por personas con malas intenciones.

La forma de hacerlo es la siguiente:

Ambas personas deben crear su llave pública y privada.
Ambas personas pueden compartir su llave pública a las otras partes (recuerda que esta llave es pública, no hay problema si la “interceptan”).
La persona que quiere compartir un mensaje puede usar la llave pública de la otra persona para cifrar los archivos y asegurarse que solo puedan ser descifrados con la llave privada de la persona con la que queremos compartir el mensaje.
El mensaje está cifrado y puede ser enviado a la otra persona sin problemas en caso de que los archivos sean interceptados.
La persona a la que enviamos el mensaje cifrado puede usar su llave privada para descifrar el mensaje y ver los archivos.
Puedes compartir tu llave pública pero nunca tu llave privada.


### Configura tus llaves SSH en local

Primer paso: Generar tus llaves SSH. Recuerda que es muy buena idea proteger tu llave privada con una contraseña.

```
ssh-keygen -t rsa -b 4096 -C "tu@email.com"
```

Segundo paso: Terminar de configurar nuestro sistema.

En Windows y Linux:

```
# Encender el "servidor" de llaves SSH de tu computadora:
eval $(ssh-agent -s)

# Añadir tu llave SSH a este "servidor":
ssh-add ruta-donde-guardaste-tu-llave-privada(~/.ssh/id_rsa)
En Mac:

# Encender el "servidor" de llaves SSH de tu computadora:
eval "$(ssh-agent -s)"

# Si usas una versión de OSX superior a Mac Sierra (v10.12)
# debes crear o modificar un archivo "config" en la carpeta
# de tu usuario con el siguiente contenido (ten cuidado con
# las mayúsculas):
Host *
        AddKeysToAgent yes
        UseKeychain yes
        IdentityFile ruta-donde-guardaste-tu-llave-privada

# Añadir tu llave SSH al "servidor" de llaves SSH de tu
# computadora (en caso de error puedes ejecutar este
# mismo comando pero sin el argumento -K):
ssh-add -K ruta-donde-guardaste-tu-llave-privada(~/.ssh/id_rsa)
```

### Conexión a GitHub con SSH

Luego de crear nuestras llaves SSH podemos entregarle la llave pública a GitHub para comunicarnos de forma segura y sin necesidad de escribir nuestro usuario y contraseña todo el tiempo.

Para esto debes entrar a la Configuración de Llaves SSH en GitHub, crear una nueva llave con el nombre que le quieras dar y el contenido de la llave pública de tu computadora.

Ahora podemos actualizar la URL que guardamos en nuestro repositorio remoto, solo que, en vez de guardar la URL con HTTPS, vamos a usar la URL con SSH:

```
git remote set-url origin url-ssh-del-repositorio-en-github
```
posterior de la configuracion con shh, devemos de obtener los archivos del repositorio remoto

```
git pull origin main
```


### Tags y versiones en Git y GitHub

Los tags o etiquetas nos permiten asignar versiones a los commits con cambios más importantes o significativos de nuestro proyecto.

Comandos para trabajar con etiquetas:

* Crear un nuevo tag y asignarlo a un commit: git tag -a nombre-del-tag id-del-commit.
* Borrar un tag en el repositorio local: git tag -d nombre-del-tag.
* Listar los tags de nuestro repositorio local: git tag o git show-ref --tags.
* Publicar un tag en el repositorio remoto: git push origin --tags.
* Borrar un tag del repositorio remoto: git tag -d nombre-del-tag y git push origin :refs/tags/nombre-del-tag.


### Manejo de ramas en GitHub

Puedes trabajar con ramas que nunca envías a GitHub, así como pueden haber ramas importantes en GitHub que nunca usas en el repositorio local. Lo importante es que aprendas a manejarlas para trabajar profesionalmente.

Crear una rama en el repositorio local: git branch nombre-de-la-rama o git checkout -b nombre-de-la-rama.
Publicar una rama local al repositorio remoto: git push origin nombre-de-la-rama.
Recuerda que podemos ver gráficamente nuestro entorno y flujo de trabajo local con Git usando el comando gitk.

### Configurar múltiples colaboradores en un repositorio de GitHub

Por defecto, cualquier persona puede clonar o descargar tu proyecto desde GitHub, pero no pueden crear commits, ni ramas, ni nada.

Existen varias formas de solucionar esto para poder aceptar contribuciones. Una de ellas es añadir a cada persona de nuestro equipo como colaborador de nuestro repositorio.

Solo debemos entrar a la configuración de colaboradores de nuestro proyecto (Repositorio > Settings > Collaborators) y añadir el email o username de los nuevos colaboradores.

### Flujo de trabajo profesional con Pull requests

En un entorno profesional normalmente se bloquea la rama master, y para enviar código a dicha rama pasa por un code review y luego de su aprobación se unen códigos con los llamados merge request.

Para realizar pruebas enviamos el código a servidores que normalmente los llamamos staging develop (servidores de pruebas) luego de que se realizan las pruebas pertinentes tanto de código como de la aplicación estos pasan a el servidor de producción con el ya antes mencionado merge request.


### Pull request

Es una funcionalidad de github (en gitlab llamada merge request y en bitbucket push request), en la que un colaborador pide que revisen sus cambios antes de hacer merge a una rama, normalmente master.

Al hacer un pull request se genera una conversación que pueden seguir los demás usuarios del repositorio, así como autorizar y rechazar los cambios.

El flujo del pull request es el siguiente

* Se trabaja en una rama paralela los cambios que se desean (```git checkout -b <rama>```)
* Se hace un commit a la rama (```git commit -am '<Comentario>'```)
* Se suben al remoto los cambios (```git push origin <rama>```)
* En GitHub se hace el pull request comparando la rama master con la rama del fix.
* Uno, o varios colaboradores revisan que el código sea correcto y dan feedback (en el chat del pull request)
* El colaborador hace los cambios que desea en la rama y lo vuelve a subir al remoto (automáticamente jala la historia de los cambios que se hagan en la rama, en remoto)
* Se aceptan los cambios en GitHub
* Se hace merge a master desde GitHub

Importante: Cuando se modifica una rama, también se modifica el ```pull request```.


### Forks o Bifurcaciones

Es una característica única de GitHub en la que se crea una copia exacta del estado actual de un repositorio directamente en GitHub, éste repositorio podrá servir como otro origen y se podrá clonar (como cualquier otro repositorio), en pocas palabras, lo podremos utilizar como un git cualquiera.

Un fork es como una bifurcación del repositorio completo, tiene una historia en común, pero de repente se bifurca y pueden variar los cambios, ya que ambos proyectos podrán ser modificados en paralelo y para estar al día un colaborador tendrá que estar actualizando su fork con la información del original.

Al hacer un fork de un proyecto en GitHub, te conviertes en dueñ@ del repositorio fork, puedes trabajar en éste con todos los permisos, pero es un repositorio completamente diferente que el original, teniendo alguna historia en común.

Los forks son importantes porque es la manera en la que funciona el open source, ya que, una persona puede no ser colaborador de un proyecto, pero puede contribuír al mismo, haciendo mejor software que pueda ser utilizado por cualquiera.

Al hacer un fork, GitHub sabe que se hizo el fork del proyecto, por lo que se le permite al colaborador hacer pull request desde su repositorio propio.

Trabajando con más de 1 repositorio remoto
Cuando trabajas en un proyecto que existe en diferentes repositorios remotos (normalmente a causa de un fork) es muy probable que desees poder trabajar con ambos repositorios, para ésto puedes crear un remoto adicional desde consola.

```
git remote add <nombre_del_remoto> <url_del_remoto> 
git remote upstream https://github.com/freddier/hyperblog

```

Al crear un remoto adicional podremos, hacer pull desde el nuevo origen (en caso de tener permisos podremos hacer fetch y push)

```py
"""
git pull <remoto> <rama>
git pull upstream master

Éste pull nos traerá los cambios del remoto, por lo que se estará al día en el proyecto, el flujo de trabajo cambia, en adelante se estará trabajando haciendo pull desde el upstream y push al origin para pasar a hacer pull request.
"""

git pull upstream master
git push origin master
```

### Ignorar archivos en el repositorio con .gitignore

No todos los archivos que agregas a un proyecto deberían ir a un repositorio, por ejemplo cuando tienes un archivo donde están tus contraseñas que comúnmente tienen la extensión .env o cuando te estás conectando a una base de datos; son archivos que nadie debe ver.

git pull
git push


### Git Rebase: reorganizando el trabajo realizado

El comando rebase es una mala práctica, nunca se debe usar, pero para efectos del curso te lo vamos a enseñar para que hagas tus propios experimentos. Con rebase puedes recoger todos los cambios confirmados en una rama y ponerlos sobre otra.

```py
# Cambiamos a la rama que queremos traer los cambios
git checkout experiment
# Aplicamos rebase para traer los cambios de la rama que queremos 
git rebase master
```

```
# avancemos en master. Insertar "master 1" en historia.txt
$ git commit -am "Master 1"

# crear rama experimento
$ git branch experimento
$ git checkout experimento

# insertar "exp 1" en historia.txt
$ git commit -am "exp 1"
# insertar "exp 2" en historia.txt
$ git commit -am "exp 2"

# hecho lo anterior, vuelvo a master y sigo avanzando
$ git checkout master
$ git commit -am "Master 2"

# la base de la rama experimento esta un commit atras de master.
# hago primero rebase en experimento para que parezca que nacio en el ultimo commit de master y no en el penultimo
$ git checkout experimento
$ git rebase master

# ahora si la rama experimento parece haber nacido en el ultimo commit de master.
# puedo hacer rebase ahora pero a master, para integrar los cambios hechos en la rama experimento
$ git checkout master
$ git rebase experimento

# con lo anterior todos los cambios quedan como si se hubieran hecho linealmente en master.
# aparece primero el commit de master que le hacia falta a experimento
# aparecen luego los dos commits que habia hecho en experimento
# con lo anterior ya me sobra la rama experimento, asi que la borro
$ git branch -D experimento
$ git branch
$ git pull origin master
$ git push oorigin master

```


### Git Stash: Guardar cambios en memoria y recuperarlos después

El stashed nos sirve para guardar cambios para después, Es una lista de estados que nos guarda algunos cambios que hicimos en Staging para poder cambiar de rama sin perder el trabajo que todavía no guardamos en un commit

Ésto es especialmente útil porque hay veces que no se permite cambiar de rama, ésto porque porque tenemos cambios sin guardar, no siempre es un cambio lo suficientemente bueno como para hacer un commit, pero no queremos perder ese código en el que estuvimos trabajando.

El stashed nos permite cambiar de ramas, hacer cambios, trabajar en otras cosas y, más adelante, retomar el trabajo con los archivos que teníamos en Staging pero que podemos recuperar ya que los guardamos en el Stash.

```py

"""
El comando git stash guarda el trabajo actual del Staging en una lista diseñada para ser temporal llamada Stash, para que pueda ser recuperado en el futuro.
"""
git stash

#Para agregar los cambios al stash se utiliza el comando:

git stash
"""
Podemos poner un mensaje en el stash, para asi diferenciarlos en git stash list por si tenemos varios elementos en el stash. Ésto con:

git stash save "mensaje identificador del elemento del stashed"
"""


```




git stash save "mensaje identificador del elemento del stashed"

Obtener elementos del stash
El stashed se comporta como una Stack de datos comportándose de manera tipo LIFO (del inglés Last In, First Out, «último en entrar, primero en salir»), así podemos acceder al método pop.

El método pop recuperará y sacará de la lista el último estado del stashed y lo insertará en el staging area, por lo que es importante saber en qué branch te encuentras para poder recuperarlo, ya que el stash será agnóstico a la rama o estado en el que te encuentres, siempre recuperará los cambios que hiciste en el lugar que lo llamas.

Para recuperar los últimos cambios desde el stash a tu staging area utiliza el comando:

```
git stash pop
```
Para aplicar los cambios de un stash específico y eliminarlo del stash:

```
git stash pop stash@{<num_stash>}
```
Para retomar los cambios de una posición específica del Stash puedes utilizar el comando:

```
git stash apply stash@{<num_stash>}
Donde el <num_stash> lo obtienes desden el git stash list
```
Listado de elementos en el stash
Para ver la lista de cambios guardados en Stash y así poder recuperarlos o hacer algo con ellos podemos utilizar el comando:

```
git stash list
```
Retomar los cambios de una posición específica del Stash || Aplica los cambios de un stash específico

Crear una rama con el stash
Para crear una rama y aplicar el stash mas reciente podemos utilizar el comando

```
git stash branch <nombre_de_la_rama>
```

Si deseas crear una rama y aplicar un stash específico (obtenido desde git stash list) puedes utilizar el comando:

```
git stash branch nombre_de_rama stash@{<num_stash>}
```
Al utilizar estos comandos crearás una rama con el nombre <nombre_de_la_rama>, te pasarás a ella y tendrás el stash especificado en tu staging area.

Eliminar elementos del stash
Para eliminar los cambios más recientes dentro del stash (el elemento 0), podemos utilizar el comando:

```
git stash drop
```
Pero si en cambio conoces el índice del stash que quieres borrar (mediante git stash list) puedes utilizar el comando:

```
git stash drop stash@{<num_stash>}
```
Donde el <num_stash> es el índice del cambio guardado.

Si en cambio deseas eliminar todos los elementos del stash, puedes utilizar:

```
git stash clear
```
Consideraciones:

El cambio más reciente (al crear un stash) SIEMPRE recibe el valor 0 y los que estaban antes aumentan su valor.
Al crear un stash tomará los archivos que han sido modificados y eliminados. Para que tome un archivo creado es necesario agregarlo al Staging Area con git add [nombre_archivo] con la intención de que git tenga un seguimiento de ese archivo, o también utilizando el comando git stash -u (que guardará en el stash los archivos que no estén en el staging).
Al aplicar un stash este no se elimina, es buena práctica eliminarlo.