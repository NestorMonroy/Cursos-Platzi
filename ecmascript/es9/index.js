// operador de reposo

const obj = {
	name: 'nestor',
	age: 30,
	country: 'MX'
};

let { country, ...all } = obj;
console.log(all);

const obj = {
	name: 'nestor',
	age: 30
};

const obj1 = {
	...obj,
	country: 'MX'
};
console.log(obj1);

const helloWorld = () => {
	return new Promise((resolve, reject) => {
		true ? setTimeout(() => resolve('hello', 3000)) : reject(new Error('error'));
	});
};

helloWorld()
	.then((response) => console.log(response))
	.catch((err) => console.log(err))
	.finally(() => console.log('finaliza'));

const regexData = /([0-9]{4})-([0-9]{2})-([0-9]{2})/;
const match = regexData.exec('2019-04-20');
const year = match[1];
const month = match[2];
const day = match[3];

console.log(year, month, day);


/*
	Notas

	spreand en objectos (...)
	Composicion de objectos
	finally en promesas
	regex

*/