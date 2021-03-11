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


Webpack en modo desarrollo

Se crea un archivo webpack.config.dev.js eliminando las optimizaciones, adicional en package.json se actualiza la llamada a este archivo

```js
{
  "scripts": {
    "dev": "webpack --config webpack.config.dev.js "
  },
}
```


Webpack en modo producción

Se puede limpiar la carpeta cada vez que hacemos un build, usando clean-webpack-plugin

npm install clean-webpack-plugin -D 

a la configuración de webpack agregamos los siguientes cambios a webpack.config.js

```js
const { CleanWebpackPlugin } = require('clean-webpack-plugin');
module.exports = {
	plugins: [
		new CleanWebpackPlugin()
	]
}

```

Webpack Watch

El modo watch hace que nuestro proyecto se compile de forma automática 


```js
module.exports = {
	...
	watch: true
}
```

Webpack Dev Server

con webpack deseamos ver los cambios en tiempo real en un navegador
Para tener esta característica esta webpack-dev-server

npm install  webpack-dev-server -D

agregar la siguiente configuración en webpack.config.dev.js

```js
module.exports = {
	...
  devServer: {
    contentBase: path.join(__dirname, 'dist'), // Le dice al servidor donde tiene que servir el contenido, solo es necesario si quieres servir archivos estáticos
    compress: true,  // Habilita la compresión gzip
    historyApiFallback: true, // cuando estas usando HTML5 History API la página index.html sera mostrada en vez de una respuesta 404
    port: 3000, // es el puerto donde vamos a realizar las peticiones
  }

}
```
Para comenzar a utilizarlo debes agregar el siguiente script a package.json


```js
{
	"scripts": {
	"start": "webpack serve --config webpack.config.dev.js"
	}
}
```

Se deshabilita ya que no es necesario 
watch: true,


Webpack Bundle Analyzer

Optimizar y entender el proyecto, optimizandolo

npm install webpack-bundle-analyzer -D

agregar la siguiente configuración en webpack.config.dev.js

```js

const BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin;

module.exports = {
	plugins: [
		new BundleAnalyzerPlugin()
	]
}
```

Se ejecutan para analizar y guardar el recurso en .json

npx webpack --profile --json > stats.json

con este comando se puede analizar el archivo

npx webpack-bundle-analyzer stats.json


Webpack DevTools
permite crear un mapa de tu proyecto y con el podemos
Leer a detalle
Analizar particularidades de lo que está compilando nuestro proyecto

En  webpack.config.dev.js
```js

module.exports = {
  mode: 'development',
  devtool: 'source-map'
}

```


React 

# Inicializar npm
npm init -y
# instalar dependencias
npm install react react-dom  -S

Instalación de dependencias

Babel
npm install -D @babel/core @babel/preset-env @babel/preset-react babel-loader

En el archivo .babelrc

```js
{
    "presets": [
        "@babel/preset-env",
        "@babel/preset-react"
    ]
}
```

Se instala WebPack

npm install -D webpack webpack-cli webpack-dev-server

En el archivo webpack.config.js

```js
const path = require('path');

module.exports = {
  entry: './src/index.js',
  output: {
    path: path.resolve(__dirname, 'dist'),
    filename: 'main.js'
  },
  resolve: {
    extensions: ['.js', '.jsx']
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /node_modules/,
        use: {
          loader: 'babel-loader'
        }
      }
    ]
  },
  devServer: {
    contentBase: path.join(__dirname, 'dist'),
    compress: true,
    port: 8080
  },
}
```

Configuracion de plugins y loaders para React

npm i -D html-loader html-webpack-plugin



En el archivo webpack.config.js

```js
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
	module: {
		rules: [
			{
				test: /\.html$/,
				use: {
					loader: 'html-loader'
				}
			}
		]
	},
	plugins: [
        new HtmlWebpackPlugin({
            template: './src/public/index.html',
            filename: 'index.html'
        })
    ]
}
```

Instalación de dependencias de css

npm install -D mini-css-extract-plugin css-loader style-loader sass sass-loader

En el archivo webpack.config.js

```js
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
module: {
  rules: [
      {
        test: /\.s[ac]ss$/,
        use: [
            'style-loader',
            'css-loader',
            'sass-loader'
        ]
      }
  ]
  plugins: [
      new MiniCssExtractPlugin({
          filename: '[name].css'
      })
  ]
}
```

Dependencias de optimización

npm install -D css-minimizer-webpack-plugin terser-webpack-plugin clean-webpack-plugin

En el archivo webpack.config.js  este es a produccion
Se crea la copia para desarrollo
```js


const CssMinimizerWebpackPlugin = require('css-minimizer-webpack-plugin');
const TerserWebpackPlugin = require('terser-webpack-plugin');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');


module.exports = {

  resolve: {
    alias: {
      "@components": path.resolve(__dirname, 'src/components/'),
      "@styles": path.resolve(__dirname, 'src/styles/')
    }
  },
  mode: 'production',

  plugins: [
    new CleanWebpackPlugin()
  ],
  optimization: {
    minimize: true,
    minimizer: [
      new CssMinimizerWebpackPlugin(),
      new TerserWebpackPlugin()
    ]
  }
}


```

Se actualiza el package.json
------------------------------------
¿Cuál es el comando de webpack-cli para ejecutar nuestro proyecto en modo de producción?
R= webpack --mode production

¿A qué nos ayuda clean-webpack-plugin?
R= A limpiar nuestra carpeta del build cada vez que volvemos a transpilar el proyecto.

¿Con cuál comando creamos nuestro package.json?
R= npm init -y

¿Cuál es el comando de webpack-cli para ejecutar nuestro proyecto en modo de desarrollo?
R= webpack --mode development

¿Con qué repositorios te puedes conectar a Netlify?
R1= Todas las respuestas son correctas

¿En cuál archivo habilitamos el watch en nuestro proyecto?
R= webpack.config.js

¿Cuáles loaders usamos para trabajar en Webpack con CSS?
R=css-loader y style-loader

¿Cuál es la expresión regular para que Webpack transpile nuestros archivos .css y .styl con su loader correspondiente?
R= /\.css|.styl$/


Después de hacer un import de las imágenes, ¿cómo las llamamos?
R= Como variables.

¿Qué es Webpack?
R= Un module bundler que nos permite trabajar con gran variedad de archivos en nuestros proyectos.

¿Para qué sirven los loaders y plugins en Webpack?
R= Agregar funcionalidades o configuraciones para trabajar con nuestros recursos.

Netlify es la única plataforma en la que se puede desplegar un proyecto hecho con React.js. Esta afirmación es:
R= Falsa

¿Qué dependencia adicional agregamos a nuestro proyecto para entender la sintaxis de React y JSX?
R= @babel/preset-react

¿Con qué comando puedes instalar Webpack en tu proyecto como dependencia de desarrollo?
R= npm install webpack webpack-cli -D

¿Cómo conseguimos que nuestro código de JavaScript sea compatible con todos los navegadores?
R= Integrando Babel a nuestro proyecto y babel-loader a la configuración de Webpack para archivos .js.

¿Cuál es el script adecuado que nos permitirá habilitar nuestro proyecto en un entorno de desarrollo local y no de producción?
R= "start" : "webpack serve"

¿En dónde establecemos la configuración, loaders y plugins que usamos en Webpack?
R= webpack.config.js

¿Cuál es la función de las variables de entorno?
R=  Crear un espacio seguro para la configuración de nuestro proyecto que no queremos exponer en nuestro código. 

¿Para qué sirven los Alias en Webpack?
R= Para identificar más fácilmente el "path" de los archivos con los que trabajamos en el proyecto.

¿Cuáles loaders usamos para trabajar en Webpack con fuentes?
R= url-loader y file-loader

¿Debemos usar expresiones regulares para definir la extensión de los archivos que afectarán nuestros loaders?
R= Verdadero


Son los loaders necesarios para ejecutar nuestro proyecto de webpack con SASS
R= style-loader, css-loader, sass-loader

¿Qué propiedad agregamos al archivo de configuración para indicarle a Webpack que trabajaremos en modo desarrollo?
R= mode: “development”

¿Cuál es la función del source-map?
R= Crear un mapa para encontrar las piezas de nuestro código por separado y hacer más fácilmente debugging.

¿Cuál es la propiedad del archivo de configuración de Webpack que guarda las opciones de optimización?
R= module.exports = { [...] optimization: { minimize: true, minimizer: [ new CssMinimizerPlugin(), new TerserPlugin() ] } }


¿Cuál plugin nos ayuda a mover archivos a la carpeta de distribution?
R= CopyWebpack


¿Cuál plugin nos permite minificar nuestros estilos CSS?
R2 = CssMinimizerPlugin

La propiedad template en nuestro plugin HTMLWebpackPlugin se refiere al archivo FINAL que se ejecuta como resultado de las configuraciones que le aplicamos al HTML de nuestro proyecto:
R= Falso

¿Con qué comando puedes instalar Webpack Dev Server?
r2 = npm install webpack-dev-server --save-dev
