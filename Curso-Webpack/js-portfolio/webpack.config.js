const path = require('path');

module.exports = {
    entry: './src/index.js', // punto de entrada
    output: {
        path: path.resolve(__dirname, 'dist'),
        filename: 'main.js', // nombre de la salida
    },
    resolve : {
        extensions: ['.js']
    }
}
