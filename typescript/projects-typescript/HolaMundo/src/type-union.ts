export {};
// 10, '10'
// Combinacions de tipo de dato con \
// let idUser: number | string;
// idUser = 10;
// idUser = '10';

// // Buscar userName dado un ID

// function getUserNameById(id:number|string){
//     //Logica de negocio, find the user
//     return 'nestor'
// }

// getUserNameById(20);
// getUserNameById('20');


// Alias de Tipos: TS 
type IdUser = number | string; 
type UserName = string;
let idUser: IdUser;
idUser = 10;
idUser = '10';

// Buscar userName dado un ID
function getUserNameById(id:IdUser):UserName{
    //Logica de negocio, find the user
    return 'nestor'
}

getUserNameById(20);
getUserNameById('20');

// Tipos Literales
// 100x100, 500x500, 1000x1000

type SquareSize = '100x100' | '500x500' |'1000x1000';
//let smallPicture:SquareSize = '200x200'; //Error

let smallPicture:SquareSize = '1000x1000';
let mediumPicture:SquareSize = '500x500';

