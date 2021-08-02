//Void
//Explicito
function showInfo(user) {
    console.log('User Info', user.id, user.userName, user.firstName);
    //return 'hola';
}
showInfo({ id: 1, userName: 'abc1', firstName: 'Nestor' });
// Inferido
function showFormattedInfo(user) {
    console.log('User Info', "\n    id: " + user.id + "\n    userName: " + user.userName + "\n    firstName: " + user.firstName + "\n    ");
}
// tipo void, como tipo nde dato en variable
var unusable;
var unusable; // 
var unusable; //
