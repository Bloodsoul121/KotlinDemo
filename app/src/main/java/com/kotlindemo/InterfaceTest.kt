package com.kotlindemo

open class A {
    open fun say() {
        println("A say")
    }
}

interface B {
    fun say() {
        println("B say")
    }
}

class C : A(), B {
    override fun say() {
//        super<A>.say()
//        super<B>.say()
        println("C say")
    }
}

fun main() {
    val c = C()
    c.say()
}

fun hello(): String {
    println("hello")
    return ""
}

fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String>
        where T : CharSequence,
              T : Comparable<T> {
    return list.filter { it > threshold }.map { it.toString() }
}