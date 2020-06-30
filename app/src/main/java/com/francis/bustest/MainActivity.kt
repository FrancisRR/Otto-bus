package com.francis.bustest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.squareup.otto.Bus
import com.squareup.otto.Subscribe
import com.squareup.otto.ThreadEnforcer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG by lazy { MainActivity::class.java.simpleName }
    private var bus: Bus? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bus = AppController.bus
        bus?.register(this)
        tvName.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }


    @Subscribe
    fun dummyModel(bus: DummyModel) {
        Log.e(TAG, "Back Triggered")
        Toast.makeText(this, "BUS event Triggered", Toast.LENGTH_SHORT).show()
    }


    override fun onDestroy() {
        super.onDestroy()
        bus?.unregister(this)
    }
}