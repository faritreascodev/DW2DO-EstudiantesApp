package com.faritreascodev.appestudiantes

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.faritreascodev.appestudiantes.data.DatosEstudiantes
import com.faritreascodev.appestudiantes.model.Estudiante

class RegistroEstudianteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegistroEstudianteUI(this)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroEstudianteUI(context: Context) {
    var nombres by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Registrar Estudiante") })
        }
    ) {
        Column(
            modifier = Modifier
                .padding(top = 80.dp, start = 16.dp, end = 16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = nombres,
                onValueChange = { nombres = it },
                label = { Text("Nombres") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = apellidos,
                onValueChange = { apellidos = it },
                label = { Text("Apellidos") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = edad,
                onValueChange = { edad = it },
                label = { Text("Edad") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    Log.d("Depurando", "Nombres: $nombres, Apellidos: $apellidos, Edad: $edad")
                    if (nombres.isNotEmpty() && apellidos.isNotEmpty() && edad.isNotEmpty()) {
                        DatosEstudiantes.lista.add(
                            Estudiante(
                                nombres,
                                apellidos,
                                edad.toInt(),
                                R.drawable.estudiante1
                            )
                        )
                        Toast.makeText(context, "Estudiante registrado correctamente", Toast.LENGTH_SHORT).show()

                        // Limpiar campos
                        nombres = ""
                        apellidos = ""
                        edad = ""
                    } else {
                        Toast.makeText(context, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar")
            }
        }
    }
}
