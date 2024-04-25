package com.example.mindbalance.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mindbalance.data.local.db.model.HemerotecaLocal
import com.example.mindbalance.data.local.db.model.ProductividadLocal

@Dao
interface ProductividadDao{
    @Query("SELECT * FROM productividad")
    fun getAll(): List<ProductividadLocal>

    @Query("SELECT * FROM productividad WHERE id = :id")
    fun getProductividad(id: Int): ProductividadLocal

    @Insert
    fun insertProductividad(productividad: ProductividadLocal)
}