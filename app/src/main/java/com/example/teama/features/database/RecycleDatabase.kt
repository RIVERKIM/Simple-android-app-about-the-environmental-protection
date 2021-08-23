package com.example.teama.features.database

import android.content.Context
import android.os.strictmode.InstanceCountViolation
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.internal.synchronized

@Database(entities=[Recycle::class], version = 1, exportSchema = false)
abstract class RecycleDatabase: RoomDatabase() {

    abstract fun recycleDatabaseDao(): RecycleDatabaseDao


    companion object {
        private var INSTANCE: RecycleDatabase? = null

        fun getInstance(context: Context): RecycleDatabase {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RecycleDatabase::class.java,
                        "recycle_database"
                    ).build()

                    INSTANCE = instance
                }
                return instance
        }
    }
}