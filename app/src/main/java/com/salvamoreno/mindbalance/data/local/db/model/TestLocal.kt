package com.example.mindbalance.data.local.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tests")
data class TestLocal(
    @PrimaryKey val id: Int,
    @ColumnInfo(name="titulo") val titulo: String,
    @ColumnInfo(name="id_valoracion") val idValoracion: Int
)