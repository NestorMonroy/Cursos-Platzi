//path. En este caso es un módulo que ya existe en node.
const path = require('path');
// instanciar los plugin 
const HtmlWebPackPlugin = require('html-webpack-plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');

module.exports = {
  //hacer referencia a nuestro archivo principal,
  entry: './src/index.js',
  //output, que es donde vamos a guardar nuestros archivos resultantes cuando hagamos la compilación
	output: {
    //path -> decirle dónde se va a guardar. (resolve) nos va a permitir detectar el directorio del que nos encontramos, pasándole un directorio en el cual vamos a guardar los archivos
    path: path.resolve(__dirname, 'dist'),
    //filename para ponerle un nombre a nuestro archivo principal.
		filename: 'bundle.js'
  },
  // resolver las extensiones que vamos a utilizar para nuestro proyecto.
	resolve: {
		extensions: [ '.js', '.jsx' ]
	},
	module: {
    //se crean reglas
		rules: [
			{
        //test: Aquí vamos a pasarle una expresión regular que nos permita a nosotros identificar nuestros archivos de .js y de .jsx
        test: /\.(js|jsx)$/,
        //pasar la exclusión de la carpeta de node_modules
        exclude: /node_modules/,
        //se usa el loader instalado
				use: {
					loader: 'babel-loader'
				}
      },
      //nueva regla que nos va a permitir a nosotros trabajar con los archivos de HTML.
			{
        //test: expresión regular que nos permita a nosotros identificar nuestros archivos html
				test: /\.html$/,
				use: [
					{
						loader: 'html-loader'
					}
				]
      },
      //nueva regla que nos va a permitir a nosotros trabajar con los archivos de css y scss.
			{
        //test: expresión regular que nos permita a nosotros identificar nuestros archivos css y scss
				test: /\.(s*)css$/,
				use: [
					{
						loader: MiniCssExtractPlugin.loader
					},
					'css-loader',
					'sass-loader'
				]
			}
		]
  },
  
  // se hace referencia a los plugins instalados 

	plugins: [
    //en este caso "html-webpack-plugin"
		new HtmlWebPackPlugin({
      //es donde está ubicado el template que tenemos
			template: './public/index.html',
			filename: './index.html'
    }),
    //mini-css-extract-plugin
    new MiniCssExtractPlugin({
      //como llamar el archivo resultante
      filename: 'assets/[name].css'

    })
	]
};


