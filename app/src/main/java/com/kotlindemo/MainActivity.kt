package com.kotlindemo

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Binder
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, ServiceConnection {

    private var mService: KotlinService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var s: String? = null
//        var ss: String = null

//        bind.text = "hello kotlin"
        bind.setOnClickListener(this)
        start.setOnClickListener(this)
        unbind.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.bind -> bindKotlinService()
            R.id.start -> startKotlinService()
            R.id.unbind -> unbindKotlinService()
        }
    }

    private fun unbindKotlinService() {
        unbindService(this)
    }

    private fun startKotlinService() {
        val i = Intent()
        i.setClass(this, KotlinService().javaClass)
        startService(i)
    }

    private fun bindKotlinService() {
        val i = Intent()
        i.setClass(this, KotlinService().javaClass)
        bindService(i, this, Context.BIND_AUTO_CREATE)
    }

    override fun onServiceDisconnected(name: ComponentName?) {

    }

    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        val binder = service as KotlinService.KotlinBinder
        mService = binder.service
        mService!!.sayHello()
    }

}
