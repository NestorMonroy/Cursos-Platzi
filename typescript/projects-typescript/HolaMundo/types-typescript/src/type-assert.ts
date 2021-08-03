export { };

// <> // Angle Bracket syntax;
let userName: any;
userName = 'nest';

// tenemos una cadena, TS confia en mi!
let message: string = (<string>userName).length > 5 ? `Welcome ${userName}!!` : 'Username is too short';
console.log(message);

let userNameWithId: any = 'nestorxx 1 ';
// Como obtener el username?

userName = (<string>userNameWithId).substring(0,7);
console.log('userName only', userName);


// Sintaxis "as"
message = (userName as string).length > 5 ? `Welcome ${userName}!!` : 'Username is too short';
console.log(message);

let helloUser:any;
helloUser = 'hello papa5a';
userName = (helloUser as string).substring(6);
console.log('username', userName);



