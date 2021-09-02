fun nullExample(args: Array<String>) {
    var nombre: String? = null

    try {
        throw NullPointerException("Referencia NULL")
    } catch (e: NullPointerException) {
        println("Ocurrió un error $e")
    } finally {
        println("Finalmente ha ocurrio un error")
    }

    val primerValor = 0
    val sugundoValor = 10
    val resultado: Int = try {
        primerValor / sugundoValor
    } catch (e: Exception) {
        0
    }
    println(resultado)
}