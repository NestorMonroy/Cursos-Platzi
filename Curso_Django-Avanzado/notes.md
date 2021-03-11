¿Por qué no se debe usar autenticación por medio de sesiones cuando se está creando un REST API?

R= Sí se puede usar mientras que las sesiones no sean utilizadas como una fuente de almacenamiento de estados. El objetivo de un REST API es permanecer stateless

La frase “Una twelve-factor app no hace distinciones entre local y producción cuando se trata acerca de ellos, una twelve-factor app realiza la conexión y desconexión de manera indiferente” ¿A qué principio se refiere?

R= Backing services

Tu aplicación realiza múltiples tareas de manera constante dependiendo el recurso que se esté accediendo, por ejemplo tareas como Administrador, tareas como Profesor, tareas como Político. Realmente los datos de cada uno de estos usuarios son exactamente los mismos y no existe diferencie dentro de la base de datos, todos viven bajo el esquema de “Humano”. Si quieres agrupar este comportamiento por “tipos de usuario”, ¿qué tipo de herencia de usuarios deberías ocupar? Justifica.

R= Herencia con modelos proxy ya que únicamente estamos añadiendo funcionalidad a los mismos datos

¿Cuál es la diferencia entre Request y HttpRequest?

R= Request es la clase que se encarga del parsing de las peticiones HTTP, es proveída por Django REST Framework y hereda de HttpRequest proveída por Django

Completa la oración: “A través del archivo local.yml podemos…”

R= Definir el conjunto de servicios que conforman la aplicación de Django, así como la dependencia entre ellos y las formas en que se deben configurar

¿“Todas las aplicaciones de Django deberían usar la misma configuración que este proyecto” es una declaración falsa o verdadera? Justifica

R= Falsa, la configuración actual es útil para nuestro caso particular y puede ser para la mayoría pero eventualmente cada proyecto tendrá necesidades diferentes

¿Qué desventajas tiene JWT?

R= Una vez emitidos los tokens, se pierde control sobre su uso ya que no existe ningún registro local de ellos. Se pueden implementar estrategias de blacklisting pero pueden llegar a ser ineficientes o terminar persistiendo información sensible

Este principio habla acerca de como una app puede convertirse en el “backing service” de cualquier otra app.

R= Port binding

¿Cuándo es útil usar request.user y cuándo es útil usar request.auth?

R= request.user regresa una instancia del modelo de usuario correspondiente al usuario que está haciendo la petición y request.auth contiene información adicional sobre el contexto de la autenticación

Cuando se está deserializando información siempre…

R= Se tiene que llama a is_valid() primero

Un campo de un Serializer puede ser…

R= Otro serializer

Estás realizando la migración de datos de una plataforma como Firebase a una base de datos real usando Django. Has diseñado ya un esquema que puede representar los datos de manera correcta y te das cuenta que existen múltiples datos que te gustaría guardar por cada registro, datos como ID en Firebase, fecha de creación en Firebase y clase del Documento del que proviene. Usando herencia de clases, ¿de qué manera implementarías una solución para almacenar esos datos? Justifica

R= Usaría herencia de modelos abstractos porque evitará que tenga que escribir esos datos en cada modelo de la aplicación.

Este tipo de autenticación es el más apropiado para configuraciones del tipo cliente-servidor, tal como aplicaciones nativas de escritorio o aplicaciones móviles.

R= Token Authentication

¿Qué tenemos que hacer para poder dividir nuestro modelo en múltiples archivos?
 
R= Al igual que un módulo de Python, crear un folder models con un __init__.py que exponga los modelos de los archivos individuales.

“Permite convertir tipos de datos complejos como querysets e instancias de clases a datos nativos de Python” describe mejor a:

R= Serializers

¿Qué ventaja tiene usar APIView sobre View cuando estamos construyendo las vistas basadas en clases de un API?

R= APIView nos permite tratar las peticiones como instancias del la clase Request, aplicar las reglas de autenticación y permisos correspondientes, y puede transformar excepciones del tipo APIException en respuestas HTTP

Incluir la propiedad exp en el payload del token nos permite

R= Realizar una validación automática de la fecha de expiración de un token generado por PyJWT

¿Cuál es la función de django-environ?

R= Permite utilizar variables de entorno (inspiradas en 12factor) para configurar una aplicación de Django

“Estos son una serie de clases que permiten aceptar múltiples tipos de contenido mientras que el opuesto te permite responder a peticiones con diferentes formatos” se refiere a

R= Parsers y renderers respectivamente

¿Qué función tiene el decorador @api_view sobre una vista basada en una función?

R= Se asegura que la función reciba un request de tipo Request y permite que la vista regrese un response de tipo Response

¿Cuál es la diferencia entre request.data y request.query_params

R= request.data regresa el contenido “parseado” de la peticiones POST, PUT y PATCH. request.query_params es equivalente al anterior pero sólo de peticiones GET

required, allow_null, source, initial y validators son atributos de la clase:

R=  Field

Es el mecanismo por el cual se asocia una petición entrante a un conjunto de credenciales

R=  Autenticación

Facilita el envío de emails a través de múltiples proveedores del servicio como Sendgrid, Mailgun, etc. Permite utilizar la misma interfaz entre los múltiples proveedores

R=  Django Anymail


Quieres que los datos de tu aplicación puedan ser accesados por otras aplicaciones siempre y cuando el dueño de los datos haya autorizado su uso. ¿Qué tipo de autenticación será la más adecuada para este caso? Justifica

R= OAuth porque permite delegar permisos a terceros sin tener que compartir las credenciales del usuario

Si queremos definir el comportamiento de una clase que herede de Serializer cuando se mande a llamar el método save() debemos:

R= Sobreescribir el método create y/o update para controlar lo que sucede con los datos ya validados y los datos de retorno

Estás trabajando en un proyecto que registra lugares y por cada lugar registras datos como nombre y dirección. Eventualmente deciden que quieren registrar restaurantes y que estos restaurantes almacenarán los mismos datos de un lugar, más datos como horario y menú. En la plataforma pueden existir lugares que no sean restaurantes, restaurantes que pertenezcan a un lugar y restaurantes que tengan nombre y dirección pero no estén registrados como lugar. Usando herencia de modelos ¿Qué técnica de herencia creerías que es la más apropiada? Justifica.

R= Usaría herencia multi tabla ya que genera una relación OneToOne a la clase hija de manera automática y esta relación no necesariamente tiene que contener datos.

¿Por qué heredamos de AbstractUser cuando queremos extender datos del usuario?

R= Porque además de cambiar datos queremos editar el comportamiento de algunos datos fundamentales como el username. Además, es altamente recomendado para proyectos que van iniciando.

“Resources over actions” se refiere a:

R= Que las URLs de un API deben estar en función de sus esquemas de datos y no en función de las acciones que puedes realizar en ellos

Docker es utilizado durante el curso porque…

R= Nos permite apegarnos a los principios de una twelve-factor app al mismo tiempo que facilita el control y distribución de nuestro proyecto














































