package com.example.medidores.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "registros_medidor")
data class RegistroMedidor(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val tipo: String, // "AGUA", "LUZ", "GAS"
    val valor: Double,
    val fecha: String
)