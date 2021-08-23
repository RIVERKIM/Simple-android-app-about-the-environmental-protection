package com.example.teama

import android.app.Application
import android.content.Context

class AndroidApplication: Application() {

    init {
        instance = this
    }

    companion object {
        var user: String? = null
        var co2: Double? = null
        var money: Int? = null
        var point: Int? = null
        private var instance: AndroidApplication? = null
        fun getContext() : Context {
            return instance!!.applicationContext
        }
    }
}