Para iniciar build con webpack

npm init -y  // iniciamos npm por defecto

npm i webpack webpack-cli -D // instalamos webpack
npx webpack // webpack de forma global
npx webpack --mode production 
npx webpack --mode development

una vez agregado webpack.config.js

npx webpack --config webpack.config.js

se agrega a package.json el script
  "scripts": {
    "build": "webpack --mode production --config webpack.config.js"
  },

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