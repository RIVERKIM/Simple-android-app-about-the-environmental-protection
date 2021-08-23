package com.example.teama.features.home

import android.content.Context
import android.content.Intent
import android.view.Window
import com.example.teama.R
import com.example.teama.core.platform.BaseActivity

class HomeActivity: BaseActivity() {


    companion object {
        fun callIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }

    override fun fragment() = HomeFragment()

}