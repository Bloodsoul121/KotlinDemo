package com.kotlindemo

fun main() {
    val text1 = """
    多行字符串
    多行字符串
    """
    println(text1)   // 输出有一些前置空格


    val text2 = """
    |多行字符串
    |菜鸟教程
    |多行字符串
    |Runoob
    """.trimMargin()
    println(text2)    // 前置空格删除了

    var a = 3

    for (i in 1..10 step 2) {
        print(i)
    }
    println()

    var max: Int?
    max = null
    println(max.hashCode())

    val v = if (a > 3) 2 else 3
    println("v = $v")

    when (v) {
        2 -> println("v 2")
        3 -> println("v 3")
        else -> println("v else")
    }

    val set = setOf("a", "b", "b") // 无序，不重复
    println("set size ${set.size}")

    loop@ for (i in 1..10) {
        for (j in 2..8) {
            if (j == 5) break@loop
        }
    }

    val man = Man("jay", 12)
    man.ask()
}

class Man(var name: String) {

    var age: Int = 0

    init {
        println("Man name $name")
    }

    constructor(name: String, age: Int) : this(name) {
        println("age is $age")
        this.age = age
    }

    fun ask() {
        println("$name age is ${this.age}" + name)
    }
}