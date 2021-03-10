const path = require('path');

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
  }

}
