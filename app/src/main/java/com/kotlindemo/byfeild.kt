package com.kotlindemo

import kotlin.reflect.KProperty

class Example {
    var p : String by Delegate()
    var q : String by Delegate()
}

class Delegate {
    operator fun getValue(example: Example, property: KProperty<*>): String {
        return "$example, 这里委托了 ${property.name} 属性 "
    }

    operator fun setValue(example: Example, property: KProperty<*>, s: String) {
        println("$example 的 ${property.name} 属性赋值为 $s")
    }

}

fun main(args: Array<String>) {
    val e = Example()
    println(e.p)     // 访问该属性，调用 getValue() 函数

    e.p = "Runoob"   // 调用 setValue() 函数
    println(e.p)
}