Estoy utilizando un ServiceWorker para optimizar las requests a una API REST. ¿Cuál estrategia sería la más adecuada para optimizar tiempos de carga y mantener soporte offline?
R = staleWhileRevalidate

Quiero agregar Web Share API a mi aplicación pero no está funcionando en Android 7 al entrar a http://misitio.com. ¿Cuál es el problema más probable que deba resolver?
R = El sitio no está siendo servido por HTTPS

Mi aplicación envía push notifications, pero no están funcionando en iOS. ¿Qué tengo que hacer para que funcionen?
R = No se puede, en iOS no hay soporte para notificaciones

Verónica tiene una aplicación y quiere ver si cumple con los requisitos necesarios para calificar como una Progressive Web App. ¿Qué herramienta debería usar?
R = Google Lighthouse

Estoy utilizando un ServiceWorker para optimizar las requests a un API que brinda datos en tiempo real que cambian rápidamente. ¿Cuál estrategia sería la mejor para este caso?
R = networkOnly

¿Cómo debo llamar a la Web Share API en mi código?
R = En respuesta a una acción del usuario, con navigator.share()

Estoy probando mi PWA en un iPhone, pero no me sale el cartelito de agregar a la home screen. ¿Qué tengo que hacer para que funcione?
R = No se puede, en iOS no hay soporte para el install banner

Quiero que mi PWA muestre un banner para instalar una app del Play Store de Android en lugar de agregar mi web app. ¿Cómo debería hacerlo?
R = En el manifest debo configurar related_applications y prefer_related_applications

¿Cuál es el principal motivo por el que deberíamos crear una Progressive Web App?
R = Para ofrecer experiencias de usuario excelentes en web mobile

Estoy utilizando un ServiceWorker para optimizar las requests a Google Fonts. ¿Cuál es la mejor estrategia para este caso?
R = cacheFirst

¿Cuál es la forma más adecuada de detectar si el navegador soporta la Web Share API?
R = if(navigator.share)

Tengo un sitio que en Lighthouse tiene un Time To First Meaningful Paint de 4 segundos. ¿Qué significa esto?
R = Que tarda 4 segundos en empezar a mostrar el sitio

¿Qué función debo llamar para tener autorización para enviar notificaciones?
R = Notification.requestPermission()

Quiero mostrar un banner que avisa al usuario que no tiene conexión a internet. ¿Cuál es la forma más adecuada de hacerlo?
R = Agregando un event listener en window para los eventos offline y online

Quiero poder agregar mi web app a la home screen en Android. ¿Qué debería sumar a mi app para poder activar esta feature?
R = Un web manifest con un icono

Quiero enviar notificaciones desde mi aplicación al usuario. ¿Qué pasos debo seguir para poder enviar notificaciones?
R = Debo chequear soporte, pedir permiso y verificar si tengo el permiso

Quiero saber si tengo permiso para enviar notificaciones, pero sin tener que preguntárselo al usuario. ¿Con qué variable o método puedo enterarme de ello?
R = Notification.permission

Tengo Google Analytics instalado, pero quiero que trackee todo aún cuando los usuarios están sin conexión. ¿Qué debería hacer para que funcione?
R = Llamando workbox.googleAnalytics.initialize() desde mi ServiceWorker con Workbox

Quiero mostrar notificaciones en mi aplicación. ¿Cómo puedo detectar si el browser soporta notificaciones?
R = if(‘Notification’ in window)

Quiero agregar HTTPS a mi sitio, pero no conozco un buen proveedor de certificados gratuito. ¿Cuál me recomendarías?
R =  Let’s Encrypt

Quiero que mi PWA muestre un banner para agregarla a la home screen en Android. ¿Qué debo tener en cuenta para que esto suceda?
R = Debo cumplir todos los requisitos de PWA de Google Lighthouse

Quiero mostrar un banner que informa al usuario que su celular está sin conexión a internet con modo avión o similar. ¿Cómo puedo saberlo desde mi código?
R = Agregando un event listener en window para los eventos offline y online

Tengo una SPA en React que quiero que esté funcionando offline, pero las URLs internas que se implementaron con React Router no funcionan correctamente cuando no tengo conexión. ¿Qué debería hacer para resolverlo?
R = Configurar un navigationRoute() en Workbox

Estás utilizando un ServiceWorker para optimizar los requests a una API REST. ¿Cuál estrategia sería la mejor para asegurar que siempre tienes la última información pero manteniendo soporte offline?
R  = networkFirst

¿Para qué sirve el web manifest?
R = Para configurar el Add to Home Screen

¿Cuál de estas opciones nos dice si el browser soporta notificaciones y tenemos permiso para recibir notificaciones?
R = if(‘Notification’ in window && Notification.permission === ‘granted’)

Quiero precargar los archivos de mi PWA para acelerar los tiempos de carga. ¿Qué método me conviene usar para lograrlo?
R = workbox.precaching

Tengo un iPhone y quiero agregar mi web app a la home screen. ¿Qué debería sumar para que el icono funcione adecuadamente?
R = Un web manifest y los meta tags de iOS como apple-touch-icon

Quiero agregar Notificaciones en mi aplicación. ¿Cuál es la forma más amigable de pedir permiso para enviarlas?
R = Cuando el usuario clickea un botón pidiendo querer recibir notificaciones