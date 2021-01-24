package assign1

import kotlin.math.*

fun newton(f: (Double) -> Double, f_prime: (Double) -> Double, x0: Double, root: Double) {
    var x = x0
    while (abs(root - x) > 1e-6) {
        x -= f(x) / f_prime(x)
    }
    print(x)
}

fun main() {
    val f: (Double) -> Double = {x -> exp(sin(x).pow(3)) + x.pow(6) - 2*x.pow(4) - x.pow(3) - 1}
    val f_prime: (Double) -> Double = {x -> exp(sin(x).pow(3))*sin(x).pow(2)*cos(x) + 6*x.pow(5) - 8*x.pow(3) - 3*x.pow(2)}

    val x1 = 0.0
    val r1 = 0.0
    newton(f,f_prime, x1, r1)

    val x2 = 0.0
    val r2 = 0.0
    newton(f, f_prime, x2, r2)

    val x3 = 0.0
    val r3 = 0.0
    newton(f, f_prime, x3, r3)
}