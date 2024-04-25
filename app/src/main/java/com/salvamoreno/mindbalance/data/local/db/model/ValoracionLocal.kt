package com.example.mindbalance.data.local.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "valoraciones")
data class ValoracionLocal(
    @PrimaryKey val id: Int,
    @ColumnInfo(name="titulo") val titulo: String,
    @ColumnInfo(name = "descripcion") val descripcion: String,
)