package com.kotlindemo

interface Base {
    fun say()
}

class BaseImpl : Base {
    override fun say() {
        println("BaseImpl say")
    }
}

class Deir(b : Base) : Base by b {

}

fun main() {
    val d = Deir(BaseImpl())
    d.say()
}