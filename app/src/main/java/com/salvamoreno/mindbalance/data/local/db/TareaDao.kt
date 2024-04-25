package com.example.mindbalance.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mindbalance.data.local.db.model.HabitoLocal
import com.example.mindbalance.data.local.db.model.TareaLocal

@Dao
interface TareaDao{
    @Query("SELECT * FROM tareas ")
    fun getAll(): List<TareaLocal>

    @Query("UPDATE tareas SET calificacion = :calificacion WHERE id = :idTarea")
    fun setCalificacion(calificacion: Int, idTarea: Int)

    @Query("SELECT * FROM tareas WHERE id = :id")
    fun getTarea(id: Int): TareaLocal

    @Delete
    fun deleteTareas(vararg tareas: TareaLocal)

    @Insert
    fun insertTarea(tarea: TareaLocal)
}