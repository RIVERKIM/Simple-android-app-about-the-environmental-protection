package com.example.teama.features.main

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.example.teama.core.platform.BaseActivity
import com.example.teama.features.home.HomeActivity

class MainActivity: BaseActivity() {

    companion object {
        fun callIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun fragment() = MainFragment()
}