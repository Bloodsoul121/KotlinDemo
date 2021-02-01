package com.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.coroutines.*

class CoroutinesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)
    }

    fun clickBtn1(view: View) {
        val result = dotask1()
        println(">>>> result")
    }

    private fun dotask1(): Int {
        println(">>>> 1")

        GlobalScope.launch {
            delay(500)
            println(">>>> launch")

            withContext(Dispatchers.Default) {
                delay(200)
                println(">>>> withContext1")
            }

            withContext(Dispatchers.Default) {
                delay(200)
                println(">>>> withContext2")
            }
        }

        Thread.sleep(200)
        println(">>>> end")
        
        return 1
    }

}