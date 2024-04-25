package com.example.mindbalance.data.local.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categoriasHemeroteca")
data class CategoriaHemerotecaLocal (
    @PrimaryKey val id: Int,
    @ColumnInfo(name="nombre") val nombre: String
)