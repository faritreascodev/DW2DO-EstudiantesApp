package com.faritreascodev.appestudiantes

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faritreascodev.appestudiantes.data.DatosEstudiantes
import com.faritreascodev.appestudiantes.model.Estudiante

class ListaEstudiantesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaEstudiantesUI()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaEstudiantesUI() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Lista de Estudiantes") })
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(top = 80.dp, start = 16.dp, end = 16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(DatosEstudiantes.lista.size) { index ->
                val estudiante = DatosEstudiantes.lista[index]
                Log.i("Depurando", estudiante.nombres)
                CardEstudiante(estudiante)
            }
        }
    }
}

@Composable
fun CardEstudiante(est: Estudiante) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEFF7FF)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = est.fotoRes),
                contentDescription = "Foto estudiante",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    "${est.nombres} ${est.apellidos}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text("Edad: ${est.edad}", fontSize = 16.sp)
            }
        }
    }
}
