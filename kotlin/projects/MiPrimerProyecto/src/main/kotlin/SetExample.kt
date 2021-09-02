fun setExample(args: Array<String>) {
    //Set Es similar a una lista, pero sin elementos repetidos
    //Conjunto inmutable
    val vocalesRepidas = setOf("a", "e", "i", "o", "u", "a", "e", "i", "o", "u")
    println(vocalesRepidas)

    //Conjunto mutable
    val numerosFavoritos = mutableSetOf(1, 2, 3, 4)
    println(numerosFavoritos)
    numerosFavoritos.add(5)
    numerosFavoritos.add(5)
    println(numerosFavoritos)
    // Se elimina el elemento dependiendo del valor
    numerosFavoritos.remove(1)
    println(numerosFavoritos)

    val valorDelSet = numerosFavoritos.firstOrNull { num -> num > 2 }
    println(valorDelSet)
}
