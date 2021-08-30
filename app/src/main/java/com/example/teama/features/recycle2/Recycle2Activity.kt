package com.example.teama.features.recycle2

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.example.teama.core.platform.BaseActivity

class Recycle2Activity: BaseActivity() {
    override fun fragment() = Recycle2_1_Fragment()

    companion object {
        fun callIntent(context: Context) = Intent(context, Recycle2Activity::class.java)
    }

}