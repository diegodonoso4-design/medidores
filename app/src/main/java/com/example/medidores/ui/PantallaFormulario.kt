package com.example.medidores.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.medidores.R
import com.example.medidores.viewmodel.MedidorViewModel

@Composable
fun PantallaFormulario(navController: NavController, viewModel: MedidorViewModel) {
    // Variables de estado [cite: 850]
    var valor by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var tipoSeleccionado by remember { mutableStateOf("AGUA") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(R.string.titulo_registro), style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        // Radio Buttons para Tipo
        Row {
            listOf("AGUA", "LUZ", "GAS").forEach { tipo ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = (tipoSeleccionado == tipo),
                        onClick = { tipoSeleccionado = tipo }
                    )
                    Text(text = tipo)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = valor,
            onValueChange = { valor = it },
            label = { Text(stringResource(R.string.label_valor)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(8.dp))

        CampoFecha(
            fecha = fecha, // Tu variable de estado
            alCambiarFecha = { nuevaFecha -> fecha = nuevaFecha }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (valor.isNotEmpty() && fecha.isNotEmpty()) {
                    viewModel.agregarRegistro(tipoSeleccionado, valor.toDouble(), fecha)
                    navController.popBackStack() // Volver atrás
                }
            }
        ) {
            Text(stringResource(R.string.btn_guardar))
        }
    }
}