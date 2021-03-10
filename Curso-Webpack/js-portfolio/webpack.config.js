const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
  entry: './src/index.js', // punto de entrada
  output: {
    path: path.resolve(__dirname, 'dist'),
    filename: 'main.js', // nombre de la salida
  },
  resolve: {
    extensions: ['.js']
  },
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
  },
  
  // Secion de plugins 
  plugins: [
    new HtmlWebpackPlugin({ // Configura el pluging
      inject: true, // Inyecta el bundle al template HTML 
      template: './public/index.html', // La ruta al template HTML
      filename: './index.html' // Nombre final del archivo
    })
  ]

}
