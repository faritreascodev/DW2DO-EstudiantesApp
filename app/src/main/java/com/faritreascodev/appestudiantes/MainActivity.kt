package com.faritreascodev.appestudiantes

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MenuPrincipal(this)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuPrincipal(context: Context) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Menú Principal") })
        }
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    Log.i("MainActivity", "Ver Estudiantes")
                    context.startActivity(
                        Intent(context, ListaEstudiantesActivity::class.java)
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ver Estudiantes")
            }

            Spacer(Modifier.height(20.dp))

            Button(
                onClick = {
                    Log.i("MainActivity", "Agregar Estudiante")
                    context.startActivity(
                        Intent(context, RegistroEstudianteActivity::class.java)
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Registrar Estudiante")
            }
        }
    }
}
