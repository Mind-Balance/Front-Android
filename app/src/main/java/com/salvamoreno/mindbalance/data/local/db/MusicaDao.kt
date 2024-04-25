package com.example.mindbalance.data.local.db

import androidx.room.Dao
import androidx.room.Query
import com.example.mindbalance.data.local.db.model.MusicaLocal

@Dao
interface MusicaDao{
    @Query("SELECT * FROM musica")
    fun getAll(): List<MusicaLocal>

    @Query("SELECT * FROM musica WHERE id = :id")
    fun getMusica(id: Int): MusicaLocal

}