package com.example.mindbalance.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mindbalance.data.local.db.model.TeleconsultaLocal

@Dao
interface TeleconsultaDao{
    @Query("SELECT * FROM teleconsultas")
    fun getAll(): List<TeleconsultaLocal>

    @Query("UPDATE teleconsultas SET id_valoracion = :idValoracion WHERE id = :idTeleconsulta")
    fun setValoracion(idValoracion: Int, idTeleconsulta: Int)

    @Query("SELECT * FROM teleconsultas WHERE id = :id")
    fun getTeleconsulta(id: Int): TeleconsultaLocal

    @Delete
    fun deleteConsulta(vararg consulta: TeleconsultaLocal)

    @Insert
    fun insertConsulta(tarea: TeleconsultaLocal)
}