package com.example.mindbalance.data.local.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "empresa")
data class EmpresaLocal (
    @PrimaryKey val id: Int,
    @ColumnInfo(name="nombre_empresa") val nombre: String,
    @ColumnInfo(name="sector") val sector: String
)