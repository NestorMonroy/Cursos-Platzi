//Tipo explicito; 
//Solo cuando no conozca el tipo de valor valor dinamico
var idUser;
idUser = 1; // number
idUser = "1"; //string
console.log('idUser', idUser);
//Tipo inferido
var otherId;
otherId = 1;
otherId = "1";
otherId = true;
console.log('otherIde', otherId);
var suprise = 'Hello typescript';
//suprise.sayHello();// error
var res = suprise.substring(6);
console.log('res', res);
