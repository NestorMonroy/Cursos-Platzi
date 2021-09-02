fun ifExample(args: Array<String>) {
    val nombre = "li"

//    if(nombre.isNotEmpty()){
//        println("El largo de la variable es: ${nombre.length}")
//    }else{
//        println("Error, la variable esta vacía")
//    }
//
    if (nombre.isNotEmpty()) println("El largo de la variable es: ${nombre.length}") else println("Error, la variable esta vacía")

    val mensaje: String = if (nombre.length > 4) {
        "Tu nombre es largo"
    } else if (nombre.isEmpty()) {
        "El nombre esta vacío"
    } else {
        "Tu nombre es corto"
    }
    println(mensaje)

}