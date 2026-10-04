package com.example.tugas4pam.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource

import tugas4pam.shared.generated.resources.Res
import tugas4pam.shared.generated.resources.foto

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
        Spacer(Modifier.height(8.dp))
        Text(
            text = nama,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
    }
}

// Satu baris info: ikon + teks
@Composable
fun InfoItem(icon: Painter, isi: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Icon(painter = icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
        Text(text = "  $isi")
    }
}

// Kartu berisi teks
@Composable
fun ProfileCard(isi: String) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Text(text = isi, modifier = Modifier.padding(16.dp))
    }
}
