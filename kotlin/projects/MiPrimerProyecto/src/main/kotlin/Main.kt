fun main(args: Array<String>) {

    val fraseAleatoria = "Ejemplo de frase aleatoria"
    val fraseOrdernaAleatoriamente = fraseAleatoria.randomCase()

    println(fraseOrdernaAleatoriamente)

    imprimirFrase(fraseAleatoria.randomCase())
}

fun imprimirFrase(frase: String): Unit {
    //Unit = void
    println("Tu frase es : $frase")
}

fun String.randomCase(): String {
    val numeroAleatorio = 0..99
    val resultadoAleatorio = numeroAleatorio.random()

    return if (resultadoAleatorio.rem(2) == 0) {
        this.toUpperCase()
    } else {
        this.toLowerCase()
    }
}