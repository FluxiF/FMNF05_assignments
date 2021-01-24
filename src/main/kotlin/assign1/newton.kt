package assign1

import kotlin.math.*

fun newton(f: (Double) -> Double, f_prime: (Double) -> Double, x0: Double, root: Double) {
    var x = x0

    while (abs(root - x) > 1e-7) {
        val x_old = x
        x -= f(x) / f_prime(x)
        if (x != x_old)
            println(abs(root - x)/abs(root - x_old))
    }
    println(x)
}

fun main() {
    // Task 6
    val f: (Double) -> Double = {x -> exp(sin(x).pow(3)) + x.pow(6) - 2*x.pow(4) - x.pow(3) - 1}
    val f_prime: (Double) -> Double = {x -> exp(sin(x).pow(3))*sin(x).pow(2)*cos(x) + 6*x.pow(5) - 8*x.pow(3) - 3*x.pow(2)}

    val x1 = -1.3
    val r1 = -1.19762372213357
    newton(f,f_prime, x1, r1)

    val x2 = 0.00000001
    val r2 = 0.0
    newton(f, f_prime, x2, r2)

    val x3 = 1.7
    val r3 = 1.53013350816662
    newton(f, f_prime, x3, r3)
    //println(f_prime(r1))
    //println(f_prime(r2))
    //println(f_prime(r3))
}