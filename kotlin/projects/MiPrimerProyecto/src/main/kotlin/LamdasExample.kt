fun LamdasExample(args: Array<String>) {
    val myLambda: (String) -> Int = {
        //it.length
            valor ->
        valor.length
    }
    println(myLambda)
    val lamdbaEjecutada: Int = myLambda("Hola Nestor")
    println(lamdbaEjecutada)

    val saludos = listOf("Hello", "Hola", "Ciao")

    val longitudSaludos = saludos.map(myLambda)
    println(longitudSaludos)

}
