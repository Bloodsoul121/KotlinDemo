package com.kotlindemo

import kotlinx.coroutines.*

fun main() {

    println("${System.currentTimeMillis()} >>>> 1")

    GlobalScope.launch {
//        delay(500)
        println("${System.currentTimeMillis()} >>>> launch")

        withContext(Dispatchers.Default) {
            delay(200)
            println("${System.currentTimeMillis()} >>>> withContext1")
        }

        withContext(Dispatchers.Default) {
            delay(200)
            println("${System.currentTimeMillis()} >>>> withContext2")
        }
    }

    println("${System.currentTimeMillis()} >>>> 2")

    Thread.sleep(200)
    println("${System.currentTimeMillis()} >>>> end")

}