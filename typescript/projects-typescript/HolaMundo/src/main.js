console.log("Hola con cambios");
// Number
// Explicito
var phone;
phone = 1;
phone = 954134;
//phone = 'Hola' -> Error
// Inferido
var phoneNumber = 54444;
phoneNumber = 544;
//phoneNumber = true -> Error
var hex = 0xf00d;
var binary = 10;
var octal = 484;
//Tipo: Boolean
//Explicito
var isPro;
isPro = true;
// isPro = 1; -> error
//Inferido
var isUserPro = false;
isUserPro = true;
// isUserPro = 9; -> error
//Strings
var userName = "Nestor";
userName = "abc";
//userName = true; -> error 
//Template String
// Uso de back-tick `
var userInfo;
userInfo = "\n    User Info:\n    username: " + userName + "\n    firtsName: " + (userName + 'Otro1') + "\n    phone: " + phone + "\n    isPro: " + isPro + "\n";
console.log('userInfo', userInfo);
