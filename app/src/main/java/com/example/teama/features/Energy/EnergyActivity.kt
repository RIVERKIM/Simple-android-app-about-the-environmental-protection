package com.example.teama.features.Energy

import android.content.Context
import android.content.Intent
import com.example.teama.core.platform.BaseActivity
import com.example.teama.features.home.HomeActivity
import com.example.teama.features.home.HomeFragment


class EnergyActivity: BaseActivity() {


    companion object {
        fun callIntent(context: Context) = Intent(context, EnergyActivity::class.java)
    }

    override fun fragment() = EnergyFragment()

}