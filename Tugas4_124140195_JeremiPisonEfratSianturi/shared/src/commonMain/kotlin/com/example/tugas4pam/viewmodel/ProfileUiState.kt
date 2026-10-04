package com.example.tugas4pam.viewmodel

import com.example.tugas4pam.data.Profile
import com.example.tugas4pam.data.profileAwal

// Semua state yang dibutuhkan UI dikumpulkan di satu data class
data class ProfileUiState(
    val profile: Profile = profileAwal,
    val isEditing: Boolean = false,
    val inputNama: String = "",
    val inputBio: String = "",
    val isDarkMode: Boolean = false
)
