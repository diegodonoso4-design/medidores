package com.example.medidores

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.medidores.data.BaseDatos
import com.example.medidores.ui.PantallaFormulario
import com.example.medidores.ui.PantallaListado
import com.example.medidores.viewmodel.MedidorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar BD y ViewModel
        val db = BaseDatos.obtenerInstancia(applicationContext)
        val viewModel = MedidorViewModel(db.medidorDao())

        setContent {
            val navController = rememberNavController()

            // Configuración de Navegación [cite: 127]
            NavHost(navController = navController, startDestination = "lista") {
                composable("lista") {
                    PantallaListado(navController, viewModel)
                }
                composable("formulario") {
                    PantallaFormulario(navController, viewModel)
                }
            }
        }
    }
}