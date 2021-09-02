fun LambdasExample(args: Array<String>) {
    val myLambda: (String) -> Int = {
        //it.length
            valor ->
        valor.length
    }
    println(myLambda)
    val lambdaEjecutada: Int = myLambda("Hola Nestor")
    println(lambdaEjecutada)

    val saludos = listOf("Hello", "Hola", "Ciao")

    val longitudSaludos = saludos.map(myLambda)
    println(longitudSaludos)

}
