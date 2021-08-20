package com.example.teama

import android.app.Application
import android.content.Context

class AndroidApplication: Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: AndroidApplication? = null
        fun getContext() : Context {
            return instance!!.applicationContext
        }
    }
}