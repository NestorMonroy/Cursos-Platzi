fun OrderListExample(args: Array<String>) {
    val numerosDeLoteria = listOf(11, 15, 30, 66, 5)

    //Ordenar ascendentemente con sorted
    val numerosSorted = numerosDeLoteria.sorted()
    println(numerosSorted)

    //Ordenar descendentemente con sortedDescending
    val numerosDescendientes = numerosDeLoteria.sortedDescending()
    println(numerosDescendientes)

    //Ordenar dependiendo de una condición con sortedBy
    val ordenarPorMultipos = numerosDeLoteria.sortedBy { num -> num < 50 }
    println(ordenarPorMultipos)

    //Ordenar de forma aleatoria
    val numerosAletorios = numerosDeLoteria.shuffled()
    println(numerosAletorios)

    //Ordenar de forma inversa
    val numerosEnReversa = numerosDeLoteria.reversed()
    println(numerosEnReversa)


    //Funciones de programación funcional

    //Map - Convertir un elemento de un tipo a otro tipo // siempre devuelve el ultimo valor

    val mensajesDeNumeros = numerosDeLoteria.map { num -> "Tu numero de lotería es $num" }
    println(mensajesDeNumeros)

    //Filtrar elementos dependiendo de condiciones con filter
    val numerosFiltrados = numerosDeLoteria.filter { num -> num > 50 }
    println(numerosFiltrados)
}
