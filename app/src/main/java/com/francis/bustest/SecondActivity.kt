package com.francis.bustest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.otto.Bus

class SecondActivity : AppCompatActivity() {
    lateinit var bus: Bus
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bus = AppController.bus
    }

    override fun onBackPressed() {
        super.onBackPressed()
        bus.post(DummyModel())
    }
}