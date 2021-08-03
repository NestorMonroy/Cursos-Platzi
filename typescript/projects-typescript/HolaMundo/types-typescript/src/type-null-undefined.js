//Explicita
var nullVariable;
nullVariable = null;
nullVariable = 1; // error
var otherVariable = null;
otherVariable = 'test';
console.log('nullVariable', nullVariable);
console.log('otherVariable', otherVariable);
// Undefined
var undefinedVariable = undefined;
//undefinedVariable = 'test'// Error
var otherUndefined = undefined;
otherUndefined = 1;
console.log('undefinedVaribale', undefinedVariable);
console.log('otherUndefined', otherUndefined);
//Null y undefined: Como subtipos
// --strictNullChecks
var albumName;
albumName = null;
albumName = undefined;
