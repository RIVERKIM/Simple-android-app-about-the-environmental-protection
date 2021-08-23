package com.example.teama.features.Recycle

import android.content.Context
import android.content.Intent
import com.example.teama.core.platform.BaseActivity
import com.example.teama.features.Energy.EnergyActivity
import com.example.teama.features.Energy.EnergyFragment

class RecycleActivity: BaseActivity() {


    companion object {
        fun callIntent(context: Context) = Intent(context, RecycleActivity::class.java)
    }

    override fun fragment() = RecycleFragment()

}