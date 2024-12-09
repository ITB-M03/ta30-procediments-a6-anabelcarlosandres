package controllers.ex1

import java.text.DecimalFormat
import java.util.*

data class Punt(
    var x: Float,
    var y: Float,
)

fun main() {
    var punt1: Punt = Punt(2.0f, 0.2f)
    mostrarPunt(punt1)
    var punt2: Punt = Punt(1f, 1f)
    translacio(punt1, punt2)
    mostrarPunt(punt1)
    escala(punt1, 2)
    mostrarPunt(punt1)
    if (igualtat(punt1, punt2))
        println("SI")
    else println("NO")


}

/**
 * Funció que mostra en pantalla les coordenades d'un punt en un format específic
 * @param p1 Primer punt definit
 * @author Anabel
 */
fun mostrarPunt(p1: Punt) {
    val df = DecimalFormat("0.000000")
    println("(${df.format(p1.x)}, ${df.format(p1.y)})")
}

/**
 * Funció per modificar un punt fent-li una suma
 * @param p1 Primer punt definit
 * @param p2 Segon punt definit
 * @author Anabel
 */
fun translacio(p1: Punt, p2: Punt) {
    p1.x = p1.x + p2.x
    p1.y = p1.y + p2.y
}

/**
 * Funció que per modificar un punt fent-li una multiplicació
 * @param p1 Primer punt definit després de la translació
 * @param factor Número pel qual multiplicarem
 * @author Anabel
 */
fun escala(p1: Punt, factor: Int) {
    p1.x = p1.x * factor
    p1.y = p1.y * factor
}

/**
 * Funció per comprovar la igualtat entre dos punts
 * @param p1 Primer punt definit
 * @param p2 Segon punt definit
 * @return Resultat de la comparació
 * @author Anabel
 */
fun igualtat(p1: Punt, p2: Punt): Boolean {
    var resultat: Boolean = false
    if (p1.x == p2.x && p1.y == p2.y) {
        resultat = true
    }
    return resultat
}

