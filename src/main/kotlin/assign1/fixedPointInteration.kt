package assign1

import kotlin.math.*


fun FPI(g: (Double) -> Double, g_prime: (Double) -> Double,  r: Double, x0: Double): Double {
    if(!valid(g_prime, x0, r)) {
        throw Error("Invalid starting position x0")
    }
    var x = x0
    while (abs(r - x) > 1e-9) {
        println(abs(r - x))
        x = g(x)
    }
    return x
}

fun valid(g_prime: (Double) -> Double, x0: Double, r: Double) : Boolean
    = abs(g_prime(x0)) < 1 && abs(r - x0) <= 1

fun main() {
    val root = 1.12998049865083
    val g: (Double) -> Double = {x -> ln(4 - sin(x))} // Rewrittes base equation on the form g(x) = x
    val g_prime: (Double) -> Double = {x -> -cos(x)/(4- sin(x))} // Derivative of g(x)
    val x0 = 1.0 // Closest integer to solution

    print(FPI(g, g_prime, root, x0))
}