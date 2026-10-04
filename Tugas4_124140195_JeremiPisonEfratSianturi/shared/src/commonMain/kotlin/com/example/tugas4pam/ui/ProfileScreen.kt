package com.example.tugas4pam.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tugas4pam.viewmodel.ProfileUiState
import org.jetbrains.compose.resources.painterResource

import tugas4pam.shared.generated.resources.Res
import tugas4pam.shared.generated.resources.ic_email
import tugas4pam.shared.generated.resources.ic_location
import tugas4pam.shared.generated.resources.ic_phone

// Halaman utama profil. Tidak menyimpan state, hanya menampilkan uiState
@Composable
fun ProfileScreen(
    uiState: ProfileUiState,
    onEditClick: () -> Unit,
    onDarkModeChange: (Boolean) -> Unit
) {
    val profile = uiState.profile

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().safeContentPadding().padding(16.dp)
    ) {
        // Toggle dark mode
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Dark Mode", modifier = Modifier.weight(1f))
            Switch(checked = uiState.isDarkMode, onCheckedChange = onDarkModeChange)
        }

        Spacer(Modifier.height(16.dp))
        ProfileHeader(profile.nama)
        Spacer(Modifier.height(16.dp))

        ProfileCard(profile.bio)

        Column(modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)) {
            InfoItem(painterResource(Res.drawable.ic_email), profile.email)
            InfoItem(painterResource(Res.drawable.ic_phone), profile.telepon)
            InfoItem(painterResource(Res.drawable.ic_location), profile.lokasi)
        }

        Button(onClick = onEditClick, modifier = Modifier.fillMaxWidth()) {
            Text("Edit Profile")
        }
    }
}
