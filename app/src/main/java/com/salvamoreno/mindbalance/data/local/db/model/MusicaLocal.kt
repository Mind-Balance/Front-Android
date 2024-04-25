package com.example.mindbalance.data.local.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "musica")
data class MusicaLocal(
    @PrimaryKey val id: Int,
    @ColumnInfo(name="titulo") val titulo: String,
    @ColumnInfo(name="duracion") val duracion: Int,
    @ColumnInfo(name = "favorito") val favorito: Boolean,
    @ColumnInfo(name = "descripcion") val descripcion: String,
)