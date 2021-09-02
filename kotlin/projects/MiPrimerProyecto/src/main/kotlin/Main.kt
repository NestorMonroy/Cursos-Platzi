//Declarando valores de las respuestas
const val AFFIRMATIVE_ANSWER = "✅"
const val NEGATIVE_ANSWER = "❌"
const val DOUBTFUL_ANSWER = "?"

//uniendo las respuestas con sus valores
val answers = mapOf(
    "Yes" to AFFIRMATIVE_ANSWER,
    "It's true" to AFFIRMATIVE_ANSWER,
    "Totally" to AFFIRMATIVE_ANSWER,
    "Undoubtedly" to AFFIRMATIVE_ANSWER,
    "Ask in an other moment" to DOUBTFUL_ANSWER,
    "I can't say you in this moment" to DOUBTFUL_ANSWER,
    "Maybe yes, or maybe not" to DOUBTFUL_ANSWER,
    "It's not going to happen" to NEGATIVE_ANSWER,
    "Do not count on it" to NEGATIVE_ANSWER,
    "Definitely not" to NEGATIVE_ANSWER,
    "I don't believe it" to NEGATIVE_ANSWER
)

fun main(args: Array<String>) {
    println(
        """
        "Hello, I'm the Kotlin 8 ball. What do you want to do?"
        1. Ask something
        2. Check answers
        3. Exit
    """.trimIndent()
    )

    val input = readLine()
    when (input) {
        "1" -> askSomething()
        "2" -> showAnswers()
        "3" -> exit()
        else -> showError()
    }
}

fun askSomething() {
    println("Que pregunta deseas realizar?")
    readLine()
    println("Asi que esa era tu pregunta ... La respuesta a eso es: ")
    val respuestaGenerada = answers.keys.random()
    println(respuestaGenerada)
}

fun showAnswers() {
    println(
        """
        "Selecciona una opción "
        1. Revisar todas las respuestas
        2. Revisar solo las respuestas afirmativas
        3. Revisar solo las respuestas dudosas
        4. Revisar solo las respuestas negativas
    """.trimIndent()
    )

    val opcionIngresada = readLine()
    when (opcionIngresada) {
        "1" -> mostrarRespuestasPorTipo()
        "2" -> mostrarRespuestasPorTipo(tipoDeRespuesta = AFFIRMATIVE_ANSWER)
        "3" -> mostrarRespuestasPorTipo(tipoDeRespuesta = NEGATIVE_ANSWER)
        "4" -> mostrarRespuestasPorTipo(tipoDeRespuesta = DOUBTFUL_ANSWER)
        else -> println("Respuesta no valida, Adios.")
    }

}

fun mostrarRespuestasPorTipo(tipoDeRespuesta: String = "TODOS") {
    when (tipoDeRespuesta) {
        "TODOS" -> answers.keys.forEach { respuesta -> println(respuesta) }
        AFFIRMATIVE_ANSWER -> answers.filterValues { values -> values == AFFIRMATIVE_ANSWER }
            .also { respuestasPositivas -> println(respuestasPositivas.keys) }
        NEGATIVE_ANSWER -> answers.filterValues { values -> values == NEGATIVE_ANSWER }
            .also { respuestasNegativas -> println(respuestasNegativas.keys) }
        DOUBTFUL_ANSWER -> answers.filterValues { values -> values == DOUBTFUL_ANSWER }
            .also { respuestasDudosas -> println(respuestasDudosas.keys) }
    }
}

fun exit() {
    println("Adios!")
}

fun showError() {
    println("Esto es un Error")
}


fun miFuncion(nombre: String,  apellido: String) = nombre + apellido