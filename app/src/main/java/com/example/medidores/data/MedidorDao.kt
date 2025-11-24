package com.example.medidores.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MedidorDao {
    // Retorna un Flow para actualizar la lista automáticamente
    @Query("SELECT * FROM registros_medidor ORDER BY id DESC")
    fun obtenerTodos(): Flow<List<RegistroMedidor>>

    @Insert
    suspend fun insertar(registro: RegistroMedidor)
}