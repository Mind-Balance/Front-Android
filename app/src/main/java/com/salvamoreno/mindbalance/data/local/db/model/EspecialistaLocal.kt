package com.example.mindbalance.data.local.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "especialistas")
data class EspecialistaLocal(
    @PrimaryKey val id: Int,
    @ColumnInfo(name="nombre") val nombre: String,
    @ColumnInfo(name="especialidad") val especilidad: String,
    @ColumnInfo(name = "email") val email: String
)