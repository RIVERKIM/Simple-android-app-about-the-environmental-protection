package com.example.teama.features.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.teama.features.database.RecycleDatabase
import com.example.teama.features.database.RecycleDatabaseDao

class MainViewModelFactory(private val dataSource: RecycleDatabaseDao): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dataSource) as T
        }else {
            throw IllegalArgumentException("unknown")
        }
    }
}