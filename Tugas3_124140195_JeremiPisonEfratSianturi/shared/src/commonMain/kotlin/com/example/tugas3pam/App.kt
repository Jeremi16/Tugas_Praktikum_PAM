package com.example.tugas3pam

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource

import tugas3pam.shared.generated.resources.Res
import tugas3pam.shared.generated.resources.ic_email
import tugas3pam.shared.generated.resources.ic_location
import tugas3pam.shared.generated.resources.ic_phone
import tugas3pam.shared.generated.resources.foto

// Foto profil bulat dan nama
@Composable
fun ProfileHeader(nama: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(Res.drawable.foto),
            contentDescription = "Foto Profil",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(100.dp).clip(CircleShape)
        )
        Text(text = nama)
    }
}

// Satu baris info: ikon + teks
@Composable
fun InfoItem(icon: Painter, isi: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(painter = icon, contentDescription = null)
        Text(text = " $isi")
    }
}

// Kartu berisi teks
@Composable
fun ProfileCard(isi: String) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Text(text = isi, modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun App() {
    MaterialTheme {
        var diklik by remember { mutableStateOf(false) }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().safeContentPadding().padding(16.dp)
        ) {
            ProfileHeader("Jeremi")

            Box(modifier = Modifier.padding(8.dp)) {
                Text("Mahasiswa Teknik Informatika ITERA")
            }

            ProfileCard("Saya mahasiswa yang sedang belajar Pengembangan Aplikasi Mobile.")

            Column(modifier = Modifier.padding(16.dp)) {
                InfoItem(painterResource(Res.drawable.ic_email), "jeremi.124140195@student.itera.ac.id")
                InfoItem(painterResource(Res.drawable.ic_phone), "085174204945")
                InfoItem(painterResource(Res.drawable.ic_location), "Lampung, Indonesia")
            }

            Button(onClick = { diklik = !diklik }) {
                Text(if (diklik) "Sudah diklik" else "Klik Saya")
            }
        }
    }
}
