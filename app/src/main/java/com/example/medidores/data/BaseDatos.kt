package com.example.medidores.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RegistroMedidor::class], version = 1)
abstract class BaseDatos : RoomDatabase() {
    abstract fun medidorDao(): MedidorDao

    companion object {
        @Volatile
        private var INSTANCE: BaseDatos? = null

        fun obtenerInstancia(context: Context): BaseDatos {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    BaseDatos::class.java,
                    "medidores.db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}