package com.example.mindbalance.data.local.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habitos")
data class HabitoLocal(
    @PrimaryKey val id: Int,
    @ColumnInfo(name="descripcion") val descripcion: String,
    @ColumnInfo(name = "racha") val racha: Int,
    @ColumnInfo(name = "meta") val meta: Int
)