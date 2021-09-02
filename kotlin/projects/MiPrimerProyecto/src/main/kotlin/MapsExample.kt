fun MapsExamples(args: Array<String>) {
    val edadDeSuperHeroes = mapOf(
        "Ironman" to 35,
        "Spiderman" to 21,
        "Capitan America" to 99
    ) //Crea mapas inmutables

    println(edadDeSuperHeroes)

    val edadDeSuperHeroesMutable = mutableMapOf(
        "Ironman" to 35,
        "Spiderman" to 21,
        "Capitan America" to 99
    )//Crea mapas mutables

    println(edadDeSuperHeroesMutable)
    //Adicionar elementos con put
    edadDeSuperHeroesMutable.put("Wolverine", 50)
    println(edadDeSuperHeroesMutable)

    //Otra forma de adicionar es convertir put en una asignación
    edadDeSuperHeroesMutable["Strom"] = 30
    println(edadDeSuperHeroesMutable)

    val edadIroman = edadDeSuperHeroesMutable["Ironman"]
    println(edadIroman)

    //Eliminar elementos del map
    edadDeSuperHeroesMutable.remove("Wolverine")
    println(edadDeSuperHeroesMutable)

    // Conocer todos los valores de map .keys solo regresa las claves
    println(edadDeSuperHeroesMutable.keys)
    // Conocer todos los valores de map .values solo regresa los valores
    println(edadDeSuperHeroesMutable.values)

}
