package com.example.teama.core.extension

import android.content.Context
import android.view.View
import com.example.teama.R
import com.example.teama.core.platform.BaseActivity
import com.example.teama.core.platform.BaseFragment

fun BaseFragment.close() = parentFragmentManager.popBackStack()

val BaseFragment.viewContainer: View
get() = (activity as BaseActivity).findViewById(R.id.fragmentContainer)

val BaseFragment.appContext: Context get() = activity?.applicationContext!!





