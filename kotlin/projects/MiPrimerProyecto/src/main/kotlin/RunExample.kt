fun RunExample(args: Array<String>) {
    //Ejecuta una serie de operaciones, luego de declarar una variable
    //Serie de operaciones en lista
    val moviles = mutableListOf("Google Pixel 2XL", "Google Pixel 4A", "Huawei Redmi 9 ", "Xiaomi mi a3")
        .run {
            removeIf{movil -> movil.contains("Google")}
            this
        }
    println(moviles)
}
