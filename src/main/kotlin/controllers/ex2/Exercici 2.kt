package controllers.ex2
import java.util.*

fun main(){
    val scan= Scanner(System.`in`)
    var opcion = mostrarMenu(scan)
    var accion = ejecutarAcion(opcion,scan)
}
fun crearSala() :MutableList<MutableList<String>> {
    var cine :MutableList<MutableList<String>> = mutableListOf()
    for (filas in 0..20){
        val asientos :MutableList<String> = mutableListOf()
        for (columna in 0..15){
            asientos.add("_")
        }
        cine.add(asientos)
    }
    return cine
}
fun mostrarMenu(scan:Scanner) :Int{
    val eleccion:Int
    println("1) Vaciar sala")
    println("2) visualizar asientos")
    println("3) Reservar asientos")
    println("4) Finalizar programa")
    print("Por favor seleccione la acccion quequiere realizar: ")
    eleccion = scan.nextInt()
    return eleccion
}
fun ejecutarAcion(eleccion:Int, scan: Scanner){
    val sala= crearSala()
    if (eleccion==1){

    }
    else if (eleccion==2){
        mostrarMatris(sala)
        var opcion = mostrarMenu(scan)
        var accion = ejecutarAcion(opcion,scan)
    }
    else if (eleccion==3)
        comprobarAsiento(scan, sala)
    else if (eleccion==4) println("Gracias")

}
fun recogerEntero(msg: String, scan: Scanner) :Int {
    print(msg)
    var numero :Int
    try {
        numero =scan.nextInt()
    }
    catch (errorLetra : InputMismatchException){
        val rojo = "\u001b[31m"
        val reset = "\u001b[0m" //devuelve el color por defecto
        numero= Int.MAX_VALUE
        println( rojo + "Error: Valor no valido ingresado" + reset)
    }
    return numero
}
fun comprobarAsiento(scan: Scanner, sala:MutableList<MutableList<String>>){
    var ocupado :Boolean
    ocupado= false
    val fila = recogerEntero("Por favor ingrese la fila del asiento:", scan)
    val columna = recogerEntero("Ahora ingrese la columna del asiento: ", scan)
    if (sala[fila][columna] == "X"){
        ocupado = true
    }
    if (!ocupado){
        reservaAsiento(sala, fila,columna)
    }
}
fun reservaAsiento(sala:MutableList<MutableList<String>>,fila :Int, columna:Int){
    sala[fila][columna].replace("_","X")
}
fun mostrarMatris(matris:MutableList<MutableList<String>>){
    for (fila in matris){
       println(fila.joinToString(" "))
    }
}
