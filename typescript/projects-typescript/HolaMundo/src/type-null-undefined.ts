//Explicita

let nullVariable: null;
nullVariable = null;
//nullVariable = 1;// error

let otherVariable = null;
otherVariable = 'test'
console.log('nullVariable', nullVariable);

console.log('otherVariable', otherVariable);

// Undefined

let undefinedVariable: undefined = undefined;
//undefinedVariable = 'test'// Error

let otherUndefined = undefined;
otherUndefined = 1;

console.log('undefinedVaribale', undefinedVariable);
console.log('otherUndefined', otherUndefined);


//Null y undefined: Como subtipos

// --strictNullChecks
let albumName: string;
// albumName = null;
// albumName = undefined;


