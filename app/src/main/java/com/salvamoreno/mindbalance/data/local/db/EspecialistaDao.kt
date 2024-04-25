package com.example.mindbalance.data.local.db

import androidx.room.Dao
import androidx.room.Query
import com.example.mindbalance.data.local.db.model.EspecialistaLocal

@Dao
interface EspecialistaDao{
    @Query("SELECT * FROM especialistas")
    fun getAll(): List<EspecialistaLocal>
}