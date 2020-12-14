import React from 'react';
import ReactDOM from 'react-dom';
import App from './containers/App';

/*
  render recibe dos parámetros. 
  Uno es el componente. Y el otro es dónde voy a empujar que este componente. Que en este caso se verá en un elemento particular del HTML  
*/
ReactDOM.render(<App />, document.getElementById('app'))
