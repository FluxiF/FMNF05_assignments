package assign1

import kotlin.math.*

fun secant(f: (Double) -> Double, x0: Double, x1: Double): Pair<Double, Double> {
    var x = x1
    var x_old = x0
    var s = 0.0

    while (abs(x - x_old) > 1e-6) {
        val res = x - (f(x)*(x-x_old))/(f(x) - f(x_old))
        s = abs(res - x)/abs(x - x_old)
        x_old = x
        x = res
    }
    return Pair(x, s)
}

fun main() {
    val f: (Double) -> Double = {x -> exp(x) + sin(x) - 4}
    val x0 = 1.0
    val x1 = 2.0
    val res = secant(f, x0, x1)

    print("Result: x=${res.first}, approximated linear convergence rate S=${res.second}")
}