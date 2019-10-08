package com.kotlindemo

object Singleton {
    fun say() {
        println("hello")
    }
}

fun main() {
    Singleton.say()

    val s = Singleton
    s.say()
}