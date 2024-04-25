package com.example.mindbalance.data.local.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tareas")
data class TareaLocal(
    @PrimaryKey val id: Int,
    @ColumnInfo(name="calificacion") val calificacion: Int,
    @ColumnInfo(name="prioridad") val prioridad: Int,
    @ColumnInfo(name = "kanban") val kanban: Boolean,
    @ColumnInfo(name = "descripcion") val descripcion: String,
)