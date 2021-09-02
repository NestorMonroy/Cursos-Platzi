fun forExample(args:Array<String>) {
    val listDeFrutas = listOf<String>("Manzana", "Pera", "Frambuesa", "Platano")
//    for (fruta in listDeFrutas){
//        println("Hoy voy a comer una fruta llamada $fruta")
//    }
    for (fruta in listDeFrutas) println("Hoy voy a comer una fruta llamada $fruta")

    listDeFrutas.forEach {fruta -> println("Hoy voy a comer una fruta nueva llamada $fruta") }

    val caracteresDeFrutas: List<Int> = listDeFrutas.map { fruta -> fruta.length }
    println(caracteresDeFrutas)

    val listaFiltrada = caracteresDeFrutas.filter { frutaCaracteres -> frutaCaracteres > 5 }
    println(listaFiltrada)
}