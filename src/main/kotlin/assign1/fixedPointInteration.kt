package assign1

import kotlin.math.*


fun FPI(g: (Double) -> Double, g_prime: (Double) -> Double,  r: Double, x0: Double): Pair<Double, Int> {
    var nbr = 0

    if(!valid(g_prime, x0, r)) {
        throw Error("Invalid starting position x0")
    }
    var x = x0
    while (abs(r - x) > 1e-6) {
        println(abs(r - g(x))/ abs(r-x))
        x = g(x)
        nbr++
    }
    return Pair(x, nbr)
}

fun valid(g_prime: (Double) -> Double, x0: Double, r: Double) : Boolean
    = abs(g_prime(x0)) < 1 && abs(r - x0) <= 1

fun main() {
    // Task 4
    val root1 = 1.12998049865083
    val g1: (Double) -> Double = { x -> ln(4 - sin(x))} // Rewrittes base equation on the form g(x) = x
    val g1_prime: (Double) -> Double = { x -> -cos(x)/(4- sin(x))} // Derivative of g(x)
    var x0 = 0.8 // Closest integer to solution

    // Task 5
    val root2 = 0.739085133215161
    val g2: (Double) -> Double = { x -> cos(x)}
    val g2_prime: (Double) -> Double = { x -> -sin(x)}

    val result = FPI(g2, g2_prime, root2, x0)
    print("Got solution ${result.first} with x0 = $x0 in ${result.second} number of steps")
}