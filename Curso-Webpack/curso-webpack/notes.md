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
