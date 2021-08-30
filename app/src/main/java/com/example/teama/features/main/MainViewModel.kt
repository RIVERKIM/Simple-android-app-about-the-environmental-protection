package com.example.teama.features.main

import android.app.AlertDialog
import android.content.DialogInterface
import android.util.Log
import android.widget.AbsListView
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teama.AndroidApplication
import com.example.teama.R
import com.example.teama.features.database.Recycle
import com.example.teama.features.database.RecycleDatabaseDao
import kotlinx.coroutines.launch

class MainViewModel(val database: RecycleDatabaseDao): ViewModel() {

    private val _recycle = MutableLiveData<Recycle?>()

    val recycle:LiveData<Recycle?>
    get() = _recycle


    fun update() {
        val recycle = Recycle(AndroidApplication.user!!, AndroidApplication.co2!!, AndroidApplication.money!!, AndroidApplication.point!!)
        //10점당 -1 co2
        val point = AndroidApplication.point!! / 10.0
        if(AndroidApplication.point!! == 0) {
            AndroidApplication.co2 = 100.0
        }else if(AndroidApplication.co2!! < point) {
            AndroidApplication.co2 = 0.0
        }else {
            AndroidApplication.co2 = AndroidApplication.co2!! - point
        }

        viewModelScope.launch {
            database.update(recycle)
        }
    }

    fun reset() {
        _recycle.value = null
        AndroidApplication.co2 = null
        AndroidApplication.money = null
        AndroidApplication.point = null
    }

    fun delete() {
        viewModelScope.launch {
            database.delete(AndroidApplication.user!!)
        }
    }


}