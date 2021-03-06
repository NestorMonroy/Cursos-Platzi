//useInitialState por convención se tiene que poner use
import React from 'react';

const useInitialState = (API) => {
  /*
  useState ->  vamos añadirle el estado. 
  vamos a utilizar una constante y vamos a traer dos elementos. 
  El primer elemento va a ser vídeos, que va a ser el nombre de la variable que yo estoy asignando para guardar a mi estado. 
  Y el segundo elemento que yo necesito se llama setVideos, que me va a permitir a mí actualizar a este estado. 
  useState recibe como propiedad elementos para inicializar mi estado. Esto puede ser un string, un number, un booleano. O puede ser un objeto o un arreglo.  
  */
  const [videos, setVideos] = React.useState({ mylist: [], trends: [], originals: [] })

  /*
    useEffect, recibe una función anónima. 
    Esta función anónima lo que hace es que, aquí dentro, vamos a poder crear esa lógica que nosotros necesitamos. Y en esta lógica voy a utilizar fetch. 
    fetch  -> recibe una API. 
    .then. Cuando esta API resuelva la información
 
 
  */
  React.useEffect(() => {
    fetch(API)
      .then(response => response.json())
      // otro llamado, que me va a permitir decirle que a mi información que yo ya tengo se la voy a pasar a mi función llamada setVideos.
      .then(data => setVideos(data))
    // useEffect recibe otro parámetro, el cual se encarga de estar escuchando alguna propiedad que pueda cambiar y así volver a ejecutarse. Si nosotros no le pasamos esta propiedad, va a crear un loop infinito.  
    // lo que queremos es que se llame la primera vez. Y después poder, entonces, transmitir estos datos a nuestro estado. Para esto, lo que voy a hacer es pasarle ese segundo valor con un arreglo vacío. 
  }, []);

  return videos;
}

export default useInitialState