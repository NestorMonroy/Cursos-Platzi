fun FuncionesParametrosExample(args: Array<String>) {
    imprimirNombre(nombre = "Nestor", apellido = "Monroy", segundoNombre = "David")
}

fun imprimirNombre(nombre: String, segundoNombre: String = "", apellido: String) {
    println("Mi nombre completo es $nombre $segundoNombre $apellido ")
}
