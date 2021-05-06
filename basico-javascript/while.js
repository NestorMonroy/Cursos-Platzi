var estudiantes = ["Maria", "Sergio", "Rosa", "Daniel"];

function saludarEstudiante(estudiante) {
  console.log(`Hola ${estudiante}`);
}

var i = 0;

//do-while
do {
  saludarEstudiante(estudiantes[i]);
  i++;
} while (i < estudiantes.length)

//while
while (estudiantes.length > 0) {
  var estudiante = estudiantes.shift();
  saludarEstudiante(estudiante);
}