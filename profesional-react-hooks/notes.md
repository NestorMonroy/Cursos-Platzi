useRef nos permite:
R= Leer y modificar el valor de nuestros inputs directamente del DOM.

Un ejemplo correcto de cómo usar useState es:
R= const [state, setState] = React.useState(initialState);

useMemo nos permite:
R= Ejecutar una función cuando el componente cumple ciertas condiciones y obtener su valor memoizado cuando no se cumplen.

¿A partir de cuál versión de React.js podemos crear componentes con React Hooks?
R= A partir de la versión 16.8.

¿El custom hook useHomeData cumple con las reglas y convenciones de los React Hooks?
R= Verdadero

¿Cuál de las siguientes herramientas nos ayudan a manejar meta-etiquetas para trabajar el SEO de nuestra aplicación?
R= React Helmet

useContext nos permite:
R= Leer y modificar los mismos datos desde componentes en cualquier parte de la aplicación sin necesidad de props.

useEffect nos permite:
R= Ejecutar acciones como respuesta a un nuevo llamado o render de nuestro componente. Es muy parecido a componentDidMount y componentDidUpdate.

¿Cuál de los siguientes React Hooks es un impostor (no es oficial de React.js)?
R=useLifecycle

¿Cuál es el custom hook de React Router nos permite modificar o "empujar" la navegación de nuestra aplicación?
R=useHistory

¿Es posible crear componentes con hooks y componentes con clases en un mismo proyecto?
R= Verdadero

¿El custom hook getHomeData cumple con las reglas y convenciones de los React Hooks?
R= Falso

useReducer nos permite:
R= Agregar estado y modificarlo con reducers en componentes creados como funciones.

¿En cuál de los siguientes ejemplos nos aseguramos de que nuestro efecto se ejecuta solo una vez (cuando "montamos" el componente)?
R= useEffect(() => { /* … */ }, []);

¿Cuáles reglas debes seguir para crear tu propio custom hook?
R= Empezar el nombre de todos nuestros custom hooks con use.

useCallback nos permite:
R= Ejecutar una función cuando el componente cumple ciertas condiciones y obtener su callback memoizado cuando no se cumplen.

¿Cuál es el custom hook de Redux que nos permite elegir qué parte de nuestro estado leeremos en nuestro componente?
R= useSelector

¿Qué es memoization?
R= Una técnica de optimización para evitar que realicemos los mismos cálculos una y otra vez.

¿Cuál React Hook es más eficiente para "escuchar" los cambios o efectos de nuestro componente cuando también utilizamos useRef?
R= useLayoutEffect

¿Cuál es la diferencia entre useEffect y useLayoutEffect?
R= useEffect se ejecuta después de que el componente renderizado se "pinte" en pantalla. useLayoutEffect se ejecuta antes del "pintado".

¿Qué optimización podemos hacer con React.memo?
R= Evitar que nuestro componente haga render innecesariamente.

useState nos permite:
R= Agregar estado a componentes creados como funciones.

¿Cuál es el custom hook de React Router que funciona igual que el componente Route?
R= useRouteMatch

