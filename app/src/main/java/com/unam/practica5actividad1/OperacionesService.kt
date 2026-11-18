package com.unam.practica5actividad1

class OperacionesService {
    fun sumar(a: Double, b: Double): Double = a + b
    fun restar(a: Double, b: Double): Double = a - b
    fun multiplicar(a: Double, b: Double): Double = a * b
    fun dividir(a: Double, b: Double): Double {
        require(b != 0.0) { "Error: No se puede dividir entre cero." }
        return a / b
    }
}