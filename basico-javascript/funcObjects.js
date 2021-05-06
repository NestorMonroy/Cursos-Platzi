// function auto(marca, modelo, annio) {
//   this.marca = marca;
//   this.modelo = modelo;
//   this.annio = annio;
// }

// //new genera una instancia, una instacia es generar un objeto que proviene de un objeto:
// var numero = prompt("How many cars?");
// var autos = []; //array
// for (var i = 0; i < numero; i++) {
//   var marca = prompt("brand?");
//   var modelo = prompt("model?");
//   var annio = prompt("year?");
//   autos.push(new auto(marca, modelo, annio));
// }

// for (var i = 0; i < autos.length; i++) {
//   console.log(autos[i]);
// }

var brands = ['Toyota', 'Mazda', 'Renault']
var cars = []

function Car(brand, model, year) {
    this.brand = brand
    this.model = model
    this.year = year
}

for (var i = 0; i < 2; i++)
    cars.push(new Car(brands[Math.floor(i/10)], `Serie ${i % 10}`, 1999 + i % 10))

console.log(cars)
