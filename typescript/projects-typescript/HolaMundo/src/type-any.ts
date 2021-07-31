//Tipo explicito; Solo cuando no conozca el tipo de valor

let idUser: any;
idUser = 1; // number
idUser = "1"; //string
console.log('idUser', idUser)

//Tipo inferido
let otherId;
otherId = 1;
otherId = "1"
otherId = true;
console.log('otherIde', otherId);

let suprise: any = 'Hello typescript'
//suprise.sayHello();// error
const res =suprise.substring(6);

console.log('res', res);



