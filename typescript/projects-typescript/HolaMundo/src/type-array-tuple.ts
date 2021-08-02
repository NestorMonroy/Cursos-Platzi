// Corchetes []


//Tipo Explicito

let users: string[];
users = ['ejemplo1', 'ejemplo2', 'ejemplo3']
//users = [1, 'ejemplo2', true] // Error

// TIpo Inferido
let otherUsers = ['ejemplo1.1', 'ejemplo2.2', 'ejemplo3.1']

//Array<Typo>
let pictureTitles: Array<string>;
pictureTitles = ['Favorite sunset', 'Vacation Time', '...']

// Accediento a los varlores en un Array
console.log('first user', users[0]);
console.log('first picture', pictureTitles[1]);

//Propiedades en Array
console.log('users.length', users.length);

// Uso de funciones en Arrays
users.push('aOtro') // Agrega
users.sort() // Ordera
console.log('users', users);
