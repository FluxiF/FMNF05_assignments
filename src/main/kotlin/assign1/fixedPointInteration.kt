package assign1

import java.lang.Math.PI
import java.lang.Math.pow
import kotlin.math.*


fun FPI(g: (Double) -> Double, f: (Double) -> Double, x0: Double): Double {
    var x = x0
    while (abs(f(x)) > 0.5e-8) {
        x = g(x)
    }
    return x
}

fun validate() {

}

fun main() {
    val g: (Double) -> Double = {x -> ln(4 - sin(x))} // Rewrittes base equation on the form g(x) = x
    val f: (Double) -> Double = {x -> exp(x) + sin(x) - 4}

    val g1: (Double) -> Double = {x -> cos(x)}
    val f1: (Double) -> Double = {x -> cos(x) - x}
    val x0 = 1.0 // The integer that is closest to the solution
    print(FPI(g1, f1, x0))
}