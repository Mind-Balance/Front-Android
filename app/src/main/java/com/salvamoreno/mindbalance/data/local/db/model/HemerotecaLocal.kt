package com.example.mindbalance.data.local.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hemeroteca")
data class HemerotecaLocal(
    @PrimaryKey val id: Int,
    @ColumnInfo(name="titulo") val titulo: String,
    @ColumnInfo(name="id_categoria") val idCategoria: Int,
    @ColumnInfo(name = "favorito") val favorito: Boolean,
    @ColumnInfo(name = "descripcion") val descripcion: String,
)