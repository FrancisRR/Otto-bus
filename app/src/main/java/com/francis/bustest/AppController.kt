package com.francis.bustest

import android.app.Application
import com.squareup.otto.Bus
import com.squareup.otto.ThreadEnforcer

class AppController : Application() {


    companion object {
        lateinit var instance: AppController
        lateinit var bus: Bus

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        bus = Bus(ThreadEnforcer.ANY)
    }
}