package com.example.teama.features.transport

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.example.teama.core.platform.BaseActivity

class TransportActivity:BaseActivity() {

    companion object {
        fun callIntent(context: Context) = Intent(context, TransportActivity::class.java)
    }

    override fun fragment() = TransportFragment()
}