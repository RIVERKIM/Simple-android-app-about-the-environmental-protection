package com.example.teama.features.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName="recycle")
data class Recycle(

    @PrimaryKey()
    @ColumnInfo(name="userId")
    var userId: String,

    @ColumnInfo(name="CO2_rate")
    val co2_rate: Double,

    @ColumnInfo(name="money")
    val money: Int,

    @ColumnInfo(name="point")
    val point: Int
):Parcelable