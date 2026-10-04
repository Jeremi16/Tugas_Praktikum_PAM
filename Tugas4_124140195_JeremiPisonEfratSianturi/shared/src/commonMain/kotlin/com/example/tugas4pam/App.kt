package com.example.tugas4pam

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tugas4pam.ui.EditProfileScreen
import com.example.tugas4pam.ui.ProfileScreen
import com.example.tugas4pam.viewmodel.ProfileViewModel

@Composable
fun App(viewModel: ProfileViewModel = viewModel { ProfileViewModel() }) {
    // Ambil state terbaru dari ViewModel
    val uiState by viewModel.uiState.collectAsState()

    // Tema mengikuti state dark mode di ViewModel
    MaterialTheme(
        colorScheme = if (uiState.isDarkMode) darkColorScheme() else lightColorScheme()
    ) {
        Surface(modifier = Modifier.fillMaxSize()) {
            if (uiState.isEditing) {
                EditProfileScreen(
                    nama = uiState.inputNama,
                    bio = uiState.inputBio,
                    onNamaChange = viewModel::ubahNama,
                    onBioChange = viewModel::ubahBio,
                    onSave = viewModel::simpanProfile,
                    onCancel = viewModel::batalEdit
                )
            } else {
                ProfileScreen(
                    uiState = uiState,
                    onEditClick = viewModel::mulaiEdit,
                    onDarkModeChange = viewModel::toggleDarkMode
                )
            }
        }
    }
}
