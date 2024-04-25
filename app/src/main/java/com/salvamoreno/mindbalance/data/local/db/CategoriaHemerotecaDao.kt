package com.example.mindbalance.data.local.db

import androidx.room.Dao
import androidx.room.Query
import com.example.mindbalance.data.local.db.model.CategoriaHemerotecaLocal

@Dao
interface CategoriaHemerotecaDao {
    @Query("SELECT * FROM categoriasHemeroteca WHERE id = :id")
    fun getCategoriaHemeroteca(id: Int): CategoriaHemerotecaLocal
}