package com.example.tugas4pam.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Form edit profil (state hoisting):
// nilai TextField dan event perubahannya dioper dari luar (ViewModel),
// jadi composable ini tidak menyimpan state sendiri
@Composable
fun EditProfileScreen(
    nama: String,
    bio: String,
    onNamaChange: (String) -> Unit,
    onBioChange: (String) -> Unit,
    onSave: () -> Unit,
    onCancel: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().safeContentPadding().padding(16.dp)
    ) {
        Text("Edit Profile", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = nama,
            onValueChange = onNamaChange,
            label = { Text("Nama") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = bio,
            onValueChange = onBioChange,
            label = { Text("Bio") },
            minLines = 3,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedButton(onClick = onCancel, modifier = Modifier.weight(1f)) {
                Text("Batal")
            }
            // Tombol simpan nonaktif kalau nama kosong
            Button(
                onClick = onSave,
                enabled = nama.isNotBlank(),
                modifier = Modifier.weight(1f)
            ) {
                Text("Simpan")
            }
        }
    }
}
