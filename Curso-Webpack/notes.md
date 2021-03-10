Para iniciar build con webpack

npm init -y  // iniciamos npm por defecto

npm i webpack webpack-cli -D // instalamos webpack
npx webpack // webpack de forma global
npx webpack --mode production 
npx webpack --mode development

Generar una estructura en carpetas => src / public / dist/ 

se agrega el archivo webpack.config.js

```js
const path = require('path');

module.exports = {
    entry: './src/index.js', // punto de entrada
    output: {
        path: path.resolve(__dirname, 'dist'),
        filename: 'main.js', // nombre de la salida
    },
    resolve : {
        extensions: ['.js']
    },
    
}
```

npx webpack --config webpack.config.js

se agrega a package.json el script
```js
  "scripts": {
    "build": "webpack --mode production --config webpack.config.js",    
  },
```

se ejecuta ahora con npm run build

Babel te permite hacer que tu código JavaScript sea compatible con todos los navegadores

babel-loader => nos permite usar babel con webpack
@babel/core => es babel en general
@babel/preset-env => trae y te permite usar las ultimas características de JavaScript
@babel/plugin-transform-runtime => te permite trabajar con todo el tema de asincronismo como ser async y await

Debes crear el archivo de configuración de babel el cual tiene como nombre .babelrc

npm install babel-loader @babel/core @babel/preset-env @babel/plugin-transform-runtime -D

Se crea el archivo de configuración de babel el cual tiene como nombre .babelrc

Se agregan nueva configuracion a webpack.config

```js
  module: {
    rules: [
      {
        // Test => declara que extensión de archivos aplicara el loader
        test: /\.m?js$/, // LEE LOS ARCHIVOS CON EXTENSION .JS
        // Use es un arreglo u objeto donde dices que loader aplicaras
        use: {
          loader: 'babel-loader'
        },
        // Exclude => permite omitir archivos o carpetas especificas
        exclude: /node_modules/
      }
    ]
  }
```

HtmlWebpackPlugin

Es un plugin para inyectar javascript, css, favicons, y nos facilita la tarea de enlazar los bundles a nuestro template HTML.
Instalación

npm i html-webpack-plugin -D

Se agregan nueva configuracion a webpack.config

```js
const HtmlWebpackPlugin = require('html-webpack-plugin');

// Secion de plugins 
plugins: [
    new HtmlWebpackPlugin({ // Configura el pluging
        inject: true, // Inyecta el bundle al template HTML 
        template: './public/index.html', // La ruta al template HTML
        filename: './index.html' // Nombre final del archivo
    })
]

```

se agrega a package.json el script
```js
  "scripts": {
    "dev": "webpack --mode development"
  },
```