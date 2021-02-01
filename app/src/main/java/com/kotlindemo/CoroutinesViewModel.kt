package com.kotlindemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutinesViewModel : ViewModel() {

    fun request() {

        println(">>>>>>> request")

        viewModelScope.launch {

            delay(200)

            println(">>>>>>> launch ${Thread.currentThread().name}")

            // 会挂起（可以理解为阻塞）协程
            withContext(Dispatchers.IO) {
                println(">>>>>>> withContext ${Thread.currentThread().name}")
            }

            delay(200)

            println(">>>>>>> launch end ${Thread.currentThread().name}")

        }

        println(">>>>>>> request end")

    }

}