package com.example.mindbalance.data.local.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meditaciones")
data class MeditacionLocal(
    @PrimaryKey val id: Int,
    @ColumnInfo(name="duracion") val duracion: Int,
    @ColumnInfo(name="descripcion") val descripcion: String,
    @ColumnInfo(name = "titulo") val titulo: String,
    @ColumnInfo(name = "favorito") val favorito: Boolean
)