package com.example.mindbalance.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mindbalance.data.local.db.model.TeleconsultaLocal
import com.example.mindbalance.data.local.db.model.TestLocal

@Dao
interface TestDao{
    @Query("SELECT * FROM tests")
    fun getAll(): List<TestLocal>

    @Query("UPDATE tests SET id_valoracion = :idValoracion WHERE id = :idTest")
    fun setValoracion(idValoracion: Int, idTest: Int)

    @Query("SELECT * FROM tests WHERE id = :id")
    fun getTest(id: Int):TestLocal

    @Delete
    fun deleteTest(vararg test: TestLocal)

    @Insert
    fun insertTest(test: TestLocal)
}