fun whenExample(args: Array<String>) {
    var nombreColor = "Carmesi"

    when (nombreColor) {
        "Amarillo" -> println("Este color simboliza la alegría.")
        "Rojo", "Carmesi" -> println("Este color simboliza el calor.")
        else -> println("Error, No existe color.")
    }

    val codigo = 501

    when (codigo) {
        in 200..299 -> println("Todo OK")
        in 400..500 -> println("Algo fallo")
        else -> println("Código desconocido, valida")
    }

    val tallaDeZapatos = 46
    val mensaje = when (tallaDeZapatos) {
        in 41..43 -> println("Tenemos disponible")
        in 42..44 -> println("Casi no nos quedan!")
        45 -> println("No tememos")
        else -> println("Solo tenemos tallas 41, 42, 43, 44, 45")
    }
    println(mensaje)
}