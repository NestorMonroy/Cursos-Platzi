/*
  .filter : nos permite filtrar solo los elementos que deseamos (según ciertos criterios) y devolverlos en un nuevo array.
  .map : crea un nuevo array con los resultados de la llamada a la función indicada aplicados a cada uno de sus elementos.
*/

var articulos = [
  { nombre: "celular", precio: 1000 },
  { nombre: "laptop", precio: 1500 },
  { nombre: "pantalla", precio: 2000 },
  { nombre: "telcado", precio: 100 },
  { nombre: "mouse", precio: 70 },
  { nombre: "carro", precio: 30000 },
];

//filter Genera un nuevo array
var articulosFiltrados = articulos.filter(function(articulo){
  return articulo.precio <= 500; //articulos con precio menor a 500 pesos
});
console.log(articulosFiltrados, 'filter')
//map Ayuda a mapear ciertos elementos de los articulos, es necesario generar nuevo array
var nombreArticulos = articulos.map(function(articulo){
  return articulo.nombre;
});
console.log(nombreArticulos, 'map')
//find Ayuda a encontrar algo dentro del array articulos
var encuentraArticulo = articulos.find(function(articulo){
  return articulo.nombre === "pantalla";
});
console.log(encuentraArticulo, 'find')
//forEach No es necesario generar nuevo array, se utiliza para realizar un recorrido de un array principal
articulos.forEach(function(articulo){
  console.log(articulo.nombre);
});

//some Se genera nuevo array, regresa un condición en Boolean
var articulosBaratos = articulos.some(function(articulo){
  return articulo.precio <= 700;
});
console.log(articulosBaratos, 'some')

