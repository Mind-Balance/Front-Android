package com.example.mindbalance.data.local.db
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mindbalance.data.local.db.model.CategoriaHemerotecaLocal
import com.example.mindbalance.data.local.db.model.EmpresaLocal
import com.example.mindbalance.data.local.db.model.EspecialistaLocal
import com.example.mindbalance.data.local.db.model.HabitoLocal
import com.example.mindbalance.data.local.db.model.HemerotecaLocal
import com.example.mindbalance.data.local.db.model.MeditacionLocal
import com.example.mindbalance.data.local.db.model.MusicaLocal
import com.example.mindbalance.data.local.db.model.ProductividadLocal
import com.example.mindbalance.data.local.db.model.SleepcastLocal
import com.example.mindbalance.data.local.db.model.TareaLocal
import com.example.mindbalance.data.local.db.model.TeleconsultaLocal
import com.example.mindbalance.data.local.db.model.TestLocal
import com.example.mindbalance.data.local.db.model.ValoracionLocal

@Database(entities = [CategoriaHemerotecaLocal::class, EmpresaLocal::class, EspecialistaLocal::class,HabitoLocal::class, HemerotecaLocal::class, MeditacionLocal::class, MusicaLocal::class, ProductividadLocal::class, SleepcastLocal::class, TareaLocal::class, TeleconsultaLocal::class, TestLocal::class, ValoracionLocal::class ], version = 1)
abstract class Database: RoomDatabase(){

}