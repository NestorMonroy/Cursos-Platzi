//Void

//Explicito
function showInfo(user: any) {
    console.log('User Info', user.id, user.userName, user.firstName);
    //return 'hola';
}


showInfo({ id: 1, userName: 'abc1', firstName: 'Nestor' })

// Inferido

function showFormattedInfo(user: any) {
    console.log('User Info', `
    id: ${user.id}
    userName: ${user.userName}
    firstName: ${user.firstName}
    `);

}

// tipo void, como tipo de dato en variable
let unusable: void;
unusable = null; // 
unusable = undefined;//


// Tipo:Never

function handleError(code: number, message: string) {

    // Process your code here
    // Generate a message
    throw new Error(`${message}. Code: ${code}`);
}

// Cacha el error y no regresa valor
try {
    handleError(404, "Not Found")
} catch (error) {

}

function sumNumbers(limit:number): never{
    let sum = 0;

    while(true){
        sum++;
    };
    // return sum nunca estamos la suma

}

//Bloque de codigo infinito
sumNumbers(10);