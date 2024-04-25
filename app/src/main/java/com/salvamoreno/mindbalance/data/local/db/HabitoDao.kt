package com.example.mindbalance.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mindbalance.data.local.db.model.HabitoLocal

@Dao
interface HabitoDao{
    @Query("SELECT * FROM habitos ")
    fun getAll(): List<HabitoLocal>

    @Query("UPDATE habitos SET racha = :racha WHERE id = :idHabito")
    fun setRacha(racha: Int, idHabito: Int)

    @Query("SELECT * FROM habitos WHERE id = :id")
    fun getHabito(id: Int): HabitoLocal

    @Delete
    fun deleteHabitos(vararg habitos: HabitoLocal)

    @Insert
    fun insertHabito(habito: HabitoLocal)
}