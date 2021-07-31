console.log("Hola con cambios")

// Number
// Explicito

let phone: number;
phone = 1;
phone = 954134;

//phone = 'Hola' -> Error

// Inferido

let phoneNumber = 54444;
phoneNumber = 544;
//phoneNumber = true -> Error

let hex: number = 0xf00d;
let binary: number = 0b1010;
let octal: number = 0o744;


//Tipo: Boolean
//Explicito
let isPro: boolean;
isPro = true;
// isPro = 1; -> error

//Inferido
let isUserPro = false;
isUserPro = true;
// isUserPro = 9; -> error

//Strings

let userName: string = "Nestor"
userName = "abc"
//userName = true; -> error 

//Template String
// Uso de back-tick `

let userInfo: string;

userInfo = `
    User Info:
    username: ${userName}
    firtsName: ${userName + 'Otro1'}
    phone: ${phone}
    isPro: ${isPro}
`;

console.log('userInfo', userInfo)

