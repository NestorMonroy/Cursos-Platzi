fun AlsoExample(args: Array<String>) {
    //Obtener una variable, ejecutar un código con esa variable, y devolverla como parámetro
    val moviles = mutableListOf("Google Pixel 2XL", "Google Pixel 4A", "Huawei Redmi 9 ", "Xiaomi mi a3").also {
            lista -> println("El valor origin al de la lista $lista")
    }.asReversed()
    println(moviles)

}
