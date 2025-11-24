package com.example.medidores.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.medidores.R // Asegúrate de importar tu R
import com.example.medidores.data.RegistroMedidor
import com.example.medidores.viewmodel.MedidorViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaListado(navController: NavController, viewModel: MedidorViewModel) {
    val registros by viewModel.listaRegistros.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("formulario") }) {
                Icon(Icons.Default.Add, contentDescription = "Agregar")
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            // Lista Dinámica [cite: 1363]
            LazyColumn {
                items(registros) { registro ->
                    ItemMedidor(registro)
                    Divider()
                }
            }
        }
    }
}

@Composable
fun ItemMedidor(registro: RegistroMedidor) {
    val iconRes = when (registro.tipo) {
        "AGUA" -> R.drawable.ic_agua
        "LUZ" -> R.drawable.ic_luz
        else -> R.drawable.ic_gas
    }

    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = registro.tipo, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "${registro.valor}")
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = registro.fecha)
    }
}