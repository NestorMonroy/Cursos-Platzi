//Type: object
let user: object;
user = {}; // Object

user = {
    id: 1,
    userName:'otro',
    firstName: 'Nestor',
    isPro: true
}

console.log('user', user);
// Object vs object(Clase JS vs tipo TS)
const myObj = {
    id: 1,
    userName:'otro',
    firstName: 'Nestor',
    isPro: true
}

const isInstance = myObj instanceof Object; // Clase Object JavaScript
console.log('isInstance', isInstance);

//console.log('user.username', user.userName); // No se puede acceder al tipo de dato
console.log('user.username', myObj.userName); // No se puede acceder al tipo de dato