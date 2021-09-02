
fun LetExample(args: Array<String>) {
    var nombre : String? = null

    // Solo cuando no sea nulo se ejecuta el código
    nombre?.let { valor -> println("El nombre no es nulo, es $valor") }

    nombre = "Nestor"
    nombre?.let { valor -> println("El nombre no es nulo, es $valor") }
}
