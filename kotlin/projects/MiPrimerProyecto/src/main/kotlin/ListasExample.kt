fun listasExample(args: Array<String>) {
    // Lista inmutable
    val listaDeNombre = listOf("Nestor", "Joel", "Camila")
    println(listaDeNombre)

    // Lista mutable
    val listaVacia = mutableListOf<String>()
    println(listaVacia)
    listaVacia.add("Nestor") //.add agregar un valor a la lista
    println(listaVacia)

    val valorUsandoGet = listaVacia.get(0) //.get Obtener el valor de la lista
    println(valorUsandoGet)

    val valorUsandoOperador = listaVacia[0]
    println(valorUsandoOperador)


    val primerValor: String? = listaDeNombre.firstOrNull() // .first Obtener el  primer valor de una lista
    println(primerValor)

    listaVacia.removeAt(0) // removeAt Eliminar elementos de la una lista
    println(listaVacia)

    listaVacia.add("Joel")
    listaVacia.removeIf() { caracteres -> caracteres.length > 3 } // removeIf Solo cuando la condicion sea valida
    println(listaVacia)

    val myArray = arrayOf(1, 2, 3, 4, 5)
    println("Mi array $myArray")
    println("Array como lista ${myArray.toList()}")

    // Para performance utilizar siempre arrays ** de lo contraria utilizar listas
}
