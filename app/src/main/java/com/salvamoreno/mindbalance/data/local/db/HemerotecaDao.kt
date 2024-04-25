package com.example.mindbalance.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import com.example.mindbalance.data.local.db.model.HabitoLocal
import com.example.mindbalance.data.local.db.model.HemerotecaLocal

@Dao
interface HemerotecaDao{
    @Query("SELECT * FROM hemeroteca ")
    fun getAll(): List<HemerotecaLocal>

    @Query("SELECT * FROM hemeroteca WHERE id = :id")
    fun getHemeroteca(id: Int): HemerotecaLocal

}