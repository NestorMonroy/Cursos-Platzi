// Crear una Fotografica

// function createPicture(title, date, size){
//     title
// }

// Usamos TS, definimos tipos para parametros
type SqueareSize = '100x100' | '500x500' | '1000x10000'

// function createPicture(title:string, date:string, size:SqueareSize){
//     //Se crea la fotografia
//     console.log('Create Picture using',title,date, size );

// }

// createPicture('My Birthday', '2020-03-10', '500x500');

// createPicture('Colombia Trip', '2021-5-20'); 


//Parametros opcionales 
function createPicture(title?: string, date?: string, size?: SqueareSize) {
    //Se crea la fotografia
    console.log('Create Picture using', title, date, size);

}

createPicture('My Birthday', '2020-03-10', '500x500');
createPicture('Colombia Trip', '2021-5-20');
createPicture('Colombia Trip');
createPicture();


// Flat Array function

let createPic = (title: string, date: string, size: SqueareSize): object => {

    // return{
    //     title: title,
    //     date:date,
    //     size:size
    // };

    return { title, date, size }

};

const picture = createPic('Ejemplo 00', '2020-03-25', '1000x10000')
console.log('picture', picture);


// Tipo de retorno con TypeScript

function handleError(code: number, message: string): never | string {
    //Procesamiento del codigo. mensaje
    if (message == 'error') {
        throw new Error(`${message}. Code error: ${code}`)
    } else {
        return 'An error has ocurred'
    }
}

try {
    let result = handleError(200, 'OK') //String
    console.log('result', result);
    result = handleError(404, 'Error'); // nerver
    console.log('result', result);
} catch (error) {

}