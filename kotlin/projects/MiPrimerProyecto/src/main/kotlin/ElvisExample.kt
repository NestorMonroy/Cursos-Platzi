fun ElvisExample(args: Array<String>) {
    var nombre: String? = null
    val caracteresDeNombre: Int = nombre?.length ?: 0 // Siempre devuelve un valor por defecto
    println(caracteresDeNombre)
}