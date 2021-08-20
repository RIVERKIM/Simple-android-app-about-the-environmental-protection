package com.example.teama.core.platform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.example.teama.R
import kotlinx.coroutines.withContext

abstract class BaseFragment: Fragment() {

    abstract fun layoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layoutId(), container, false)

    internal fun showProgress() = progressStatus(View.VISIBLE)

    private fun progressStatus(viewStatus: Int) =
        with(activity) {
            if(this is BaseActivity) findViewById<ProgressBar>(R.id.progress).visibility = viewStatus
        }


    open fun onBackPressed() {}
}