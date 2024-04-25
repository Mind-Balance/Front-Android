package com.example.mindbalance.data.local.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teleconsultas")
data class TeleconsultaLocal(
    @PrimaryKey val id: Int,
    @ColumnInfo(name="id_medico") val idMedico: Int,
    @ColumnInfo(name="id_valoracion") val idValoracion: Int,
    @ColumnInfo(name = "fecha") val fecha: String,
    @ColumnInfo(name="hora") val hora: String,
    @ColumnInfo(name = "estado") val estado: String,
)