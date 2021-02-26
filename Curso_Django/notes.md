¿Qué método debe sobrescribirse en una vista que hereda de FormView para enviar un e-mail antes de salvar el formulario?

-- form_valid

Si se tuviera una plataforma con donde el username principal de los usuarios es el email. ¿De qué manera se debería diseñar el modelo?

-- A través de una clase que extienda de AbstractBaseUser y redefiniendo la variable USERNAME_FIELD

¿Con qué bases de datos funciona el ORM de Django?

-- El ORM está hecho para trabajar con bases de datos de tipo relacionar y por default puede trabajar con motores como: PostgreSQL, MySQL, SQLite3 y Oracle

¿Cuál es la mejor manera de crear un usuario?
-- User.objects.create_user(username=username, password=password)

¿Qué problema resuelve Django?
-- La creación de un proyecto web con múltiples especificaciones como: interacción constante con una base de datos y manejo de peticiones HTTP.

¿Qué es una vista?

-- Es el código llamado por la URL después de hacer el match del recurso solicitado y contiene toda la lógica para generar una respuesta HTTP con las operaciones necesarias como traer datos de la DB y pasarlos a un template para su presentación.

¿Qué es el MTV y qué significa?

-- El MTV es el patrón de diseño adoptado por Django para la construcción de aplicaciones web. Define que durante el creación de un sitio el modelo será el encargado de estructurar los datos y controlar su acceso, el template será el encargado de contener toda la lógica para mostrar los datos y la vista la conexión entre estos dos encargado de procesar la petición, traer los datos y pasárselos al template.

¿Por qué es importante utilizar entornos virtuales?

-- Porque nos ayuda a prevenir conflictos entre las múltiples bibliotecas y versiones de bibliotecas que los proyectos de nuestra computadora pueden usar.

¿Cuál es la diferencia entre las utilidades de django-admin y las de manage.py?

-- django-admin nos permite acceder a operaciones de Django para la línea de comandos y manage.py  nos permite acceder a las mismas operaciones pero todos los comandos son específicos al proyecto que contiene el archivo.

¿Qué son los templates de Django?
-- Es la forma en la que Django permite escribir la lógica de presentación de los datos dentro de HTML usando una sintaxis especial.

¿Cómo se modifican, crean o alteran las tablas la base de datos que usa el proyecto de Django?

-- A través de la definición de clases de Python que representan una tabla de la base de datos relacional y propiedades de la clase que representan los campos de dicha tabla.

Si deseamos consultar la lista de usuarios que se han creado dentro de los últimos 10 días, ¿Qué sentencia resuelve mejor el problema?

-- User.objects.filter(created__gte=ten_days_ago) 

¿Qué es una migración?

-- Definen el estado de una base de datos a través del tiempo, pueden depender de migraciones pasadas y listan las operaciones que se deben realizar en la base de datos para obtener el estado que representan. Las migraciones son creadas con el comando makemigrations después de cualquier cambio en los archivos de modelos.

¿Qué hace la variable DEBUG dentro del archivo settings.py?

-- Define el entorno en el que el proyecto está corriendo. Cuando DEBUG es True se agregan otras utilidades al servidor de desarrollo que nos facilitan hacer debugging

¿De qué nos sirven los path converters y cuál es la diferencia con usar expresiones regulares?

-- Los path converters hacen uso de una sintaxis especial para validar el tipo de datos pasados en las URLs y son diferentes a una expresión regular porque son más legibles y regresan el tipo de dato de Python listo para ser usado.

¿Qué es un patrón de diseño?

-- Es una solución común a un problema particular.

¿Qué valor tiene que ser enviado de manera obligatoria en todas las peticiones POST que salgan de un formulario?

-- El token criptográfico que protege la petición contra ataques de Cross Site Request Forgery

¿Qué es el dashboard de administración de Django?

-- Es una aplicación de Django incluida por de default durante la instalación que provee una interfaz gráfica para administrar los datos de los modelos de un proyecto

¿Cómo se pintan los campos de un Form separados en párrafos?

-- {{form.as_p}}

Si quisiéramos validar dos campos de un formulario que dependen entre sí, ¿qué método deberíamos usar para lograrlo?

-- Sobreescribir el método clean, usar los valores de cleaned_data y aplicar las validaciones

¿Cómo es que Django nos permite interactuar con los datos originales de una petición HTTP?

-- A través de una instancia de la clase HttpRequest que es pasada en cada vista como uno de los argumentos.

¿Cómo se puede acceder a los datos de una petición POST en Django?

-- A través del atributo POST de una instancia del objeto HttpRequest el cual regresa una estructura similar a un diccionario de Python

¿Qué concepto define mejor una aplicación en Django?

-- Es un módulo de Python que incluye código encargado resolver la funcionalidad de un área específica de un proyecto, por ejemplo: las vistas, las URLs, las pruebas y los modelos que únicamente están relacionados a las publicaciones de los usuarios de un proyecto como Platzigram

¿Qué es un middleware?

-- Es un sistema de plugins de bajo nivel que permite alterar la entrada o salida de Django a través del procesamiento de una petición HTTP


¿Cómo se debe crear un entorno virtual en Python3 >= 3.4?

-- python3 -m venv ENV_NAME

¿Qué son las vistas basadas en clases?
-- Son clases que están hechas para resolver un problema particular y son instanciadas desde la función de la vista para poder acceder a sus utilidades

Son vistas que heredan de clases que implementan funcionalidad común entre las aplicaciones web y que exponen atributos a sus hijos para facilitar su uso</p>


¿Cuál es el rol de Django en los formularios?

Proveer un conjunto de clases y utilidades que facilitan la validación y manejo de datos provenientes de un formulario HTML


¿Cómo se agregan validaciones adicionales a un campo de un formulario?
Sobreescribiendo el método clean_field_name

