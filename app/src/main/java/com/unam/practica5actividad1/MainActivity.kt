package com.unam.practica5actividad1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                CalculadoraScreen()
            }
        }
    }
}

@Composable
fun CalculadoraScreen() {
    val servicio = remember { OperacionesService() }

    var num1Str by remember { mutableStateOf("") }
    var num2Str by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("Resultado: ") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Actividad 1: Operaciones Simples",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = num1Str,
            onValueChange = { num1Str = it },
            label = { Text("Número 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = num2Str,
            onValueChange = { num2Str = it },
            label = { Text("Número 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                val a = num1Str.toDoubleOrNull() ?: 0.0
                val b = num2Str.toDoubleOrNull() ?: 0.0
                resultado = "Resultado (Suma): ${servicio.sumar(a, b)}"
            }) { Text("Sumar") }

            Button(onClick = {
                val a = num1Str.toDoubleOrNull() ?: 0.0
                val b = num2Str.toDoubleOrNull() ?: 0.0
                resultado = "Resultado (Resta): ${servicio.restar(a, b)}"
            }) { Text("Restar") }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                val a = num1Str.toDoubleOrNull() ?: 0.0
                val b = num2Str.toDoubleOrNull() ?: 0.0
                resultado = "Resultado (Multiplicación): ${servicio.multiplicar(a, b)}"
            }) { Text("Multiplicar") }

            Button(onClick = {
                val a = num1Str.toDoubleOrNull() ?: 0.0
                val b = num2Str.toDoubleOrNull() ?: 0.0
                resultado = try {
                    "Resultado (División): ${servicio.dividir(a, b)}"
                } catch (e: Exception) {
                    e.message ?: "Error"
                }
            }) { Text("Dividir") }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = resultado,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}