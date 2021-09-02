
fun ApplyExample(args: Array<String>) {
    // Permite realizar operaciones sobre una variable y luego regresar el valor, lo devuelve automáticamente
    val moviles = mutableListOf("Google Pixel 2XL", "Google Pixel 4A", "Huawei Redmi 9 ", "Xiaomi mi a3").apply {
        removeIf { movil -> movil.contains("Google") }
    }

    println(moviles)

    //val colores : MutableList<String>? = null
    //apply convertir los null a tipos no null

    val colores: MutableList<String>? = mutableListOf("Amarillo", "Azul", "Rojo")
    colores?.apply {
        println("Nuestros colores son $this")
        println("La cantidad de colores es $size")
    }

}
