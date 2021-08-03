export {};

// [1, 'Nestor']
let user: [number, string];
user = [1, 'Nestor'];

console.log('user', user);
console.log('userName', user[1]);
console.log('userName.length', user[1].length);
console.log('id', user[0]);

// Tuplas con varios valores
// id, userName, isPro

let userInfo: [number, string, boolean];
userInfo = [2,'Ejemplo2', true]
console.log('userInfo', userInfo);

//Arreglo de Tuplas
let array: [number, string][] = [];

array.push([1,'ejemplo1.1' ]);//0
array.push([2,'ejemplo2.1' ]);//1
array.push([3,'ejemplo3.1' ]);//2

console.log('array', array);

// Uso de funciones Array
// ejemplo3 -> ejemplo3.1
array[2][1] = array[2][1].concat('001'); //ejemplo3.1001
console.log('array', array);


