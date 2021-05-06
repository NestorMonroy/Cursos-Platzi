var estudiantes = ["Maria", "Sergio", "Rosa", "Daniel"];

function saludarEstudiantes(alumno) {
  console.log(`Hola, ${alumno}`);
}
// for(var i = 0; i < estudiantes.length; i++){
//   saludarEstudiantes(estudiantes[i])
// }

for (var alumno of estudiantes) {
  saludarEstudiantes(alumno);
}
