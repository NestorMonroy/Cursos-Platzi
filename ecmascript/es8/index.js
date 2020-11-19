// devolver los datos de una matriz
const data = {
	frontend: 'nestor',
	backend: 'Joel',
	desing: 'Ana'
};

const entries = Object.entries(data);
console.log(entries);

console.log(entries.length); // tamano de un objeto

const data = {
	frontend: 'nestor',
	backend: 'Joel',
	desing: 'Ana'
};

const values = Object.values(data);

console.log(values);
console.log(values.length);

const string = 'hello';
console.log(string.padStart(7, 'hi'));
console.log(string.padEnd(12, ' --------'));
console.log('food'.padEnd(12, ' --------'));

const obj = {
	name: 'nestor'
};

const helloWorld = () => {
	return new Promise((resolve, reject) => {
		true ? setTimeout(() => resolve('hello'), 3000) : reject(new Error('Test error'));
	});
};

const helloAsync = async () => {
	const hello = await helloWorld();

	console.log(hello);
};

helloAsync();

const anothorFuntion = async () => {
	try {
		const hello = await helloWorld();
		console.log(hello);
	} catch (error) {
		console.log(error);
	}
};

anothorFuntion()