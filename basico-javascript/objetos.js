var miAuto = {
	marca: "Toyota",
	modelo: "Corolla",
	annio: 2020
}

consolo.log(miAuto.marca) //Toyota


var miAuto = {
  marca: "Toyota",
  modelo: "Corolla",
  año: 2020, 

  detallesDelAuto: function () {
    console.log(`Auto ${this.modelo} ${this.año}`);

  }
}

console.log(miAuto.detallesDelAuto())