npm install redux react-redux

Se importa en el index.js

```js
\
import { createStore } from 'redux';
import { Provider } from 'react-redux';

const store = createStore(
  {}, // Reducers
  {}, // Estado inicial
);


```


Se crea la carpeta como :

src/reducers/ index.js 

```js
import { combineReducers } from 'redux';

export default combineReducers({
  
});
```

Se actuala index.js

```js
import reducers from './reducers';


const store = createStore(
  reducers, // Reducers
  {}, // Estado inicial
);

```

Se crea el reduxer usuariosReducer.js

```js
const INITIAL_STATE = {
  usuarios: []
};

export default (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case 'traer_usuarios':
      return { ...state, usuarios: action.payload };

    default: return state;
  };
};

```

se import en reducers/index.js
