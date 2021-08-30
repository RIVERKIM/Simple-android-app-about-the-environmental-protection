package com.example.teama.features.myPage

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.example.teama.core.platform.BaseActivity

class MyPageActivity: BaseActivity() {
    override fun fragment() = MyPageFragment()

    companion object {
        fun callIntent(context: Context) = Intent(context, MyPageActivity::class.java)
    }

}