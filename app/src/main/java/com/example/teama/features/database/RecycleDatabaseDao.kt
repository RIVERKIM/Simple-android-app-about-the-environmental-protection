package com.example.teama.features.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface RecycleDatabaseDao {

    @Insert
    suspend fun insert(data: Recycle)

    @Update
    suspend fun update(data: Recycle)

    @Query("select * from recycle where userId = :uid")
    suspend fun get(uid: String): Recycle?

    @Query("select * from recycle")
    suspend fun getAll(): List<Recycle>?

    @Query("delete from recycle")
    suspend fun clear()

    @Query("delete from recycle where userId= :uid")
    suspend fun delete(uid: String)

}