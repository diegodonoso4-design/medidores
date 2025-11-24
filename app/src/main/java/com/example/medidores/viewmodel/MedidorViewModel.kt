package com.example.medidores.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medidores.data.MedidorDao
import com.example.medidores.data.RegistroMedidor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MedidorViewModel(private val dao: MedidorDao) : ViewModel() {

    // Estado para la lista de registros
    private val _listaRegistros = MutableStateFlow<List<RegistroMedidor>>(emptyList())
    val listaRegistros: StateFlow<List<RegistroMedidor>> = _listaRegistros

    init {
        // Cargar datos al iniciar
        viewModelScope.launch {
            dao.obtenerTodos().collect { lista ->
                _listaRegistros.value = lista
            }
        }
    }

    fun agregarRegistro(tipo: String, valor: Double, fecha: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val nuevoRegistro = RegistroMedidor(tipo = tipo, valor = valor, fecha = fecha)
            dao.insertar(nuevoRegistro)
        }
    }
}