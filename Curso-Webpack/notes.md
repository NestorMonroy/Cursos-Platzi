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

MiniCssExtractPlugin

Este loader lo que nos permite es que en nuestro proyecto de desarrollo poder importar en los archivos JavaScript importar archivos CSS o de otros preprocesadores, al final webpack importara en nuestro HTML todo nuestro css.

npm i mini-css-extract-plugin css-loader -D

Se elimina la dependencia css del public/index.html
Se agrega el recurso a index.js


npm i stylus-loader -D


Se agregan nueva configuracion a webpack.config

```js
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
rules: [
  {
    test: /\.css|.styl$/i,
    use: [MiniCssExtractPlugin.loader,
      'css-loader'
    ],
  }
]
plugins: [
  new MiniCssExtractPlugin(),
]
```

Si deseamos posteriormente podemos agregar herramientas poderosas de CSS como ser:
pre procesadores
-Sass
-Less
-Stylus
post procesadores
-Post CSS

npm i stylus stylus-loader -D

npm i copy-webpack-plugin -D => nos servirá para copiar archivos y lanzarlos a la carpeta dist. //no es necesario si se llaman las imagenes desde el Loader


Se modifica webpack config
```js
const CopyPlugin = require('copy-webpack-plugin');

module.exports = {
	...
  plugins: [
    new CopyPlugin({
      patterns: [
        {
          from: path.resolve(__dirname, "src", "assets/images"),
          to: "assets/images"
        }
      ]
    }),
  ]
}

```

Loader de imágenes => genera el hash a los archivos,
solo modificando las rutas del template 

```js

module.exports = {
	...
  module: {
    rules: [
      {
        test: /\.(png|svg|jpg|jpeg|gif)$/i,
        type: "asset/resource"
      }
    ]
  },
}

```

Loaders de fuentes

Es importante que dentro de los estilos agregues @font-face
```css
@font-face {
	font-family: "Ubuntu";
	src: url("../assets/fonts/ubuntu-regular.woff2") format('woff2'),
			 url("../assets/fonts/ubuntu-regular.woff") format('woff');
	font-weight: 400;
	font-style: normal;
}
```

Por ello es importante usarlo dentro de webpack
Para esta tarea instalaras y usaras “file-loader” y “url-loader”

npm install url-loader file-loader -D

Se agrega una nueva salida y una nueva regla
```js

module.exports = {
  output: {
  //para insertar el cambio y mover las fuentes a otra carpte lohacemos aqui
  assetModuleFilename: 'assets/images/[hash][ext][query]'
  }
	
  module: {
    rules: [
			...
      {
        test: /\.(woff|woff2)$/,
        use: {
          loader: "url-loader",
          options: {
            // limit => limite de tamaño
            limit: 10000,
            // Mimetype => tipo de dato
            mimetype: "application/font-woff",
            // name => nombre de salida
            name: "[name].[ext]",
            // outputPath => donde se va a guardar en la carpeta final
            outputPath: "./assets/fonts/",
            publicPath: "./assets/fonts/",
            esModule: false,
          }
        }
      }
    ]
  },
	...
}
```

Unos de las razones por que utilizamos webpack es porque nos permite optimizar y comprimir nuestro proyecto


npm i css-minimizer-webpack-plugin terser-webpack-plugin -D
se agrega a la configuracion webpack config

```js

const CssMinimizerPlugin = require('css-minimizer-webpack-plugin');
const TerserPlugin = require('terser-webpack-plugin');

module.exports = {
	...
	optimization: {
    minimize: true,
    minimizer: [
      new CssMinimizerPlugin(),
      new TerserPlugin()
    ]
  }
}

filename: '[name].[contenthash].js', // nombre de la salida

```

vamos a identificar cada bild de nuestro proyecto con un hash

se anade en output
en fuentes
y lo añadimos en la instancia de la dependencia que compila nuestro css

```js
new MiniCssExtracPlugin({
  filename: 'assets/[name].[contenthash].css'

}),

```

Webpack Alias

Usamos alias para que cuando tengamos que mandar a llamar un archivo que se encuentra en una carpetea muy lejana, evitemos algo como import ../../../../

```js
module.exports = {
	...
	resolve: {
		...
    alias: {
      '@nombreDeAlias': path.resolve(__dirname, 'src/<directorio>'),
    },
	}
}

```

Variables de entorno

las variables de entorno va a ser un espacio seguro donde podemos guardar datos sensibles 

npm install dotenv-webpack -D

Posteriormente debemos crear un archivo .env donde estarán la clave para acceder a la misma y el valor que contendrán

debemos agregar la siguiente configuración en webpack.config.js

```js

const Dotenv = require('dotenv-webpack');
module.exports = {
	...
	plugins: [
		new Dotenv()
  ],
}

```

