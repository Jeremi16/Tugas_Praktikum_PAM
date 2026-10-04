package com.example.tugas4pam.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel : ViewModel() {

    // _uiState hanya bisa diubah dari dalam ViewModel
    private val _uiState = MutableStateFlow(ProfileUiState())

    // uiState dibaca oleh UI (read-only)
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    // Buka form edit, isi TextField dengan data sekarang
    fun mulaiEdit() {
        _uiState.update {
            it.copy(
                isEditing = true,
                inputNama = it.profile.nama,
                inputBio = it.profile.bio
            )
        }
    }

    fun ubahNama(nama: String) {
        _uiState.update { it.copy(inputNama = nama) }
    }

    fun ubahBio(bio: String) {
        _uiState.update { it.copy(inputBio = bio) }
    }

    // Simpan isi form ke profile lalu tutup form
    fun simpanProfile() {
        _uiState.update {
            it.copy(
                profile = it.profile.copy(nama = it.inputNama, bio = it.inputBio),
                isEditing = false
            )
        }
    }

    fun batalEdit() {
        _uiState.update { it.copy(isEditing = false) }
    }

    fun toggleDarkMode(aktif: Boolean) {
        _uiState.update { it.copy(isDarkMode = aktif) }
    }
}
