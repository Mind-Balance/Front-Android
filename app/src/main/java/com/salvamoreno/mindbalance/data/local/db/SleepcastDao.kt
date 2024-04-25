package com.example.mindbalance.data.local.db

import androidx.room.Dao
import androidx.room.Query
import com.example.mindbalance.data.local.db.model.HemerotecaLocal
import com.example.mindbalance.data.local.db.model.SleepcastLocal

@Dao
interface SleepcastDao{
    @Query("SELECT * FROM sleepcasts")
    fun getAll(): List<SleepcastLocal>

    @Query("SELECT * FROM sleepcasts WHERE id = :id")
    fun getSleepcast(id: Int): SleepcastLocal

}