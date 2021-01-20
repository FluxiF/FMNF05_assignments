package assign1

import kotlin.math.pow
var steps = 0

fun bisection(f: (Double) -> Double, x0: Double, x1: Double
              , tol: Double = 0.5e-6): Double {
    var a = x0
    var b = x1
    var c = 0.0

    while ((b - a)/2 > tol) {
        c = (a + b) / 2
        when {
            f(c) == 0.0 -> return c
            f(a)*f(c) < 0 -> b = c
            else -> a = c
        }
        steps++
    }
    return c
}

fun main() {
    val f: (Double) -> Double = {x -> x.pow(4) - x.pow(3) - 1}
    val res = bisection(f, -2.0 ,0.0)
    println(res)
    println(steps)
}