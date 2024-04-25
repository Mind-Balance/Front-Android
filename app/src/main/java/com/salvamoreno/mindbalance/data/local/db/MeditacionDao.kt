package com.example.mindbalance.data.local.db

import androidx.room.Dao
import androidx.room.Query
import com.example.mindbalance.data.local.db.model.MeditacionLocal

@Dao
interface MeditacionDao{
    @Query("SELECT * FROM meditaciones ")
    fun getAll(): List<MeditacionLocal>

    @Query("SELECT * FROM hemeroteca WHERE id = :id")
    fun getMeditacion(id: Int): MeditacionLocal

}