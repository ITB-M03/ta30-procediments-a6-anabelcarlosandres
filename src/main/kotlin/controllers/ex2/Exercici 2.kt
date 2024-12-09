package controllers.ex2
import java.util.*

fun main(){
    val scan= Scanner(System.`in`)
    val sala= crearSala()
    var opcion = 0
    while (opcion != 4){//el programa no parara hasta que el usuario no selecione la opcion 4
        opcion = mostrarMenu(scan)
        println()
        var accion = ejecutarAcion(opcion,scan, sala)
    }
}
/**
 * @author Carlos vargas
 *@param msg Mensaje que informa al usuario que debe ingresar un numero entero
 *@param scan Elemento que nos perimte escanear el teclado dentro de la funcion
 *@return Retorna un numero Entero (Int)
 *@exception InputMismatchException Error que sucede en los casos de que el usuario ingresa un valor diferente a un Int
 */
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
/**
 * @author Carlos vargas
 *@return Retorna una matris de listas mutables, en total 20 filas y cada fila con 15 valores
 */
fun crearSala() :MutableList<MutableList<String>> {
    var cine :MutableList<MutableList<String>> = mutableListOf()
    for (filas in 0..19){
        val asientos :MutableList<String> = mutableListOf()
        for (columna in 0..14){
            asientos.add("_")
        }
        cine.add(asientos)
    }
    return cine
}
/**
 * @author Carlos vargas
 * @param scan Elemento que nos permite escanear el teclado del usuario para saber la opcion que escogio
 *@return Retorna un numero entero, el cual, es la opcion escogida por el usuario.
 */
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
/**
 * @author Carlos vargas
 * @param scan Elemento que nos permite escanear el teclado, de esta forma usaremos la funcion de recogerEntero.
 * @param sala Matris que representa la sala de cine, se usa para comprobar si en la matris tiene un valor "X"
 * y para uso de la  funcion reservaAsiento.
 *@return Otorga un resultado segun del valor del Bolean ocupado,si es true imprimira un mensaje por pantalla, en caso contrario, usara
 *la funcion reservaAsiento.
 */
fun comprobarAsiento(scan: Scanner, sala:MutableList<MutableList<String>>){
    var ocupado :Boolean
    ocupado= false
    val fila = recogerEntero("Por favor, ingrese el numero de la fila del asiento (del 1 al 20):", scan)
    val columna = recogerEntero("Ahora ingrese el numero de la columna del asiento (del 1 al 15): ", scan)
    if (sala[fila][columna] == "X"){
        ocupado = true
        println("Este asiento no esta disponible")
    }
    if (!ocupado){
        reservaAsiento(sala, fila-1,columna-1) // restamos uno para contar desde 0
    }
}
/**
 * @author Carlos vargas
 *@param sala  Matris que representa la sala de cine
 *@param fila Numero que indica el indice de filas de la matris
 *@param columna Numero que indica el indice del valor en una  fila de la matris
 *@exception InputMismatchException Error que sucede en los casos de que el usuario ingresa un numero que supera los limites de la matriz
 */
fun reservaAsiento(sala:MutableList<MutableList<String>>,fila :Int, columna:Int){
    try {
        sala[fila][columna] = "X"
    }
    catch (errorIndex :IndexOutOfBoundsException){
        val rojo = "\u001b[31m"
        val reset = "\u001b[0m" //devuelve el color por defecto
        println( rojo + "Error: index no valido detectado" + reset)

    }
}
/**
 * @author Carlos vargas
 *@param matris  Matris que representa la sala de cine
 *@return Retorna la matriz en forma de String por pantalla
 */
fun mostrarMatris(matris:MutableList<MutableList<String>>){
    for (fila in matris){
       println(fila.joinToString(" "))
    }
}
/**
 * @author Carlos vargas
 *@param eleccion Numero recogido de la funcion mostrarMenu, segun su valor se ejecutara otra funcion o se mostrara un mensaje en pantalla
 *@param scan Elemento para escanea el teclado del suuario, se encuentra sobretodo para podejer ejecutar las funciones ajenas correctamente
 *@param sala Matriz que representa la sala de cine y con la que trabajaran todas las funciones referenciadas
 *@return Segun el valor de  la eleccion, remplazara todos los elementos de la matris, usara una funcion ajena o
 * mostrara cierto mensaje en pantalla
 */
fun ejecutarAcion(eleccion:Int, scan: Scanner, sala:MutableList<MutableList<String>>){
    if (eleccion==1){
        for (listas in sala){
            listas.replaceAll { "_" }
        }
    }
    else if (eleccion==2){
        mostrarMatris(sala)
    }
    else if (eleccion==3)
        comprobarAsiento(scan, sala)
    else if (eleccion==4) println("Gracias por su tiempo")
    else println("Por favor, ingrese una opcion correcta")
}
