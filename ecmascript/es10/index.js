let array = [ 1, 2, 3, [ 1, 2, 3, [ 1, 2, 3 ] ] ];

console.log(array.flat(2));

let array = [ 1, 2, 3, 4, 5 ];
console.log(array.flatMap((value) => [ value, value * 2 ]));

let hello = '          hello';

// elimina espacios de strings
console.log(hello);
console.log(hello.trimStart());

let hello = 'hello      ';

console.log(hello);
console.log(hello.trimEnd());

/* try {
    
} catch {
    
}
 */


let entries = [['name','David'], ["age", 30]]
console.log(Object.fromEntries(entries))

let mySimbol = `My Symbol`
let simbol = Symbol(mySimbol)
console.log(simbol.desciption)



/*
	Notas

	Array.flat
    Flatmap
    trimStart
    Optinal catch bind (no es necesario pasar error al catch)
	
    Object.fromEntries
    Symbol description

*/