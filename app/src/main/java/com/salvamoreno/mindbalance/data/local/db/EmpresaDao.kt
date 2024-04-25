package com.example.mindbalance.data.local.db

import androidx.room.Dao
import androidx.room.Query
import com.example.mindbalance.data.local.db.model.EmpresaLocal

@Dao
interface EmpresaDao{
    @Query("SELECT * FROM empresa WHERE id = :id")
    fun getEmpresa(id: Int): EmpresaLocal
}