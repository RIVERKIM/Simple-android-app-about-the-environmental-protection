package com.example.teama.features.main

import android.util.Log
import android.widget.AbsListView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teama.AndroidApplication
import com.example.teama.features.database.Recycle
import com.example.teama.features.database.RecycleDatabaseDao
import kotlinx.coroutines.launch

class MainViewModel(val database: RecycleDatabaseDao): ViewModel() {

    private val _recycle = MutableLiveData<Recycle>()

    val recycle:LiveData<Recycle>
    get() = _recycle


    init {
        //initialize()
    }

    private fun initialize() {

        viewModelScope.launch {

            _recycle.value = database.get(AndroidApplication.user!!)

            Log.d("sa", _recycle.value.toString())

            if(_recycle.value == null) {
                val info = Recycle(AndroidApplication.user!!, 30.0, 100, 100)

                database.insert(info)

                _recycle.value = info
            }

            AndroidApplication.co2 = _recycle.value!!.co2_rate
            AndroidApplication.money = _recycle.value!!.money
            AndroidApplication.point = _recycle.value!!.point
        }




    }


    fun update() {
        val recycle = Recycle(AndroidApplication.user!!, AndroidApplication.co2!!, AndroidApplication.money!!, AndroidApplication.point!!)

        viewModelScope.launch {
            database.update(recycle)
        }
    }

}