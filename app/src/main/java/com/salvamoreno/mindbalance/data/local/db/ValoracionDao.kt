package com.example.mindbalance.data.local.db
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mindbalance.data.local.db.model.TeleconsultaLocal
import com.example.mindbalance.data.local.db.model.ValoracionLocal

@Dao
interface ValoracionDao{
    @Query("SELECT * FROM valoraciones")
    fun getAll(): List<ValoracionLocal>

    @Query("SELECT * FROM valoraciones WHERE id = :id")
    fun getValoracion(id: Int): ValoracionLocal

    @Delete
    fun deleteValoracion(vararg valoracion: ValoracionLocal)

    @Insert
    fun insertValoracion(valoracion: ValoracionLocal)
}