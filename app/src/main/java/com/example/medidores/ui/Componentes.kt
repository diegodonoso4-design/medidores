package com.example.medidores.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

// Función auxiliar para formatear milisegundos a String (AAAA-MM-DD)
fun convertirFecha(millis: Long?): String {
    millis?.let {
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        formatter.timeZone = TimeZone.getTimeZone("UTC") // Evita problemas de zona horaria
        return formatter.format(Date(it))
    }
    return ""
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoFecha(
    fecha: String,
    alCambiarFecha: (String) -> Unit
) {
    var mostrarCalendario by remember { mutableStateOf(false) }
    val estadoCalendario = rememberDatePickerState()

    // Campo de texto de solo lectura (actúa como botón)
    OutlinedTextField(
        value = fecha,
        onValueChange = { },
        label = { Text("Fecha") },
        placeholder = { Text("AAAA-MM-DD") },
        readOnly = true, // Importante: no permite escribir manual
        trailingIcon = {
            IconButton(onClick = { mostrarCalendario = true }) {
                Icon(Icons.Default.DateRange, contentDescription = "Seleccionar fecha")
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .clickable { mostrarCalendario = true } // Abre al tocar el campo
    )

    if (mostrarCalendario) {
        DatePickerDialog(
            onDismissRequest = { mostrarCalendario = false },
            confirmButton = {
                TextButton(onClick = {
                    alCambiarFecha(convertirFecha(estadoCalendario.selectedDateMillis))
                    mostrarCalendario = false
                }) { Text("Aceptar") }
            },
            dismissButton = {
                TextButton(onClick = { mostrarCalendario = false }) { Text("Cancelar") }
            }
        ) {
            DatePicker(state = estadoCalendario)
        }
    }
}