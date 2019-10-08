package com.kotlindemo

open class AA(name: String) {
    public open val y: String = name
}

interface BB {

}

val ab: AA = object : AA("AB"), BB {
    override val y = "y"
}

fun main() {
    println(ab.y)
}