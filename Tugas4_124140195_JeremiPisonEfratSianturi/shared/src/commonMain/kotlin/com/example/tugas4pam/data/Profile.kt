package com.example.tugas4pam.data

// Model data profil
data class Profile(
    val nama: String,
    val bio: String,
    val email: String,
    val telepon: String,
    val lokasi: String
)

// Data awal profil (sebelum diedit)
val profileAwal = Profile(
    nama = "Jeremi Pison Efrat Sianturi",
    bio = "Mahasiswa Teknik Informatika ITERA yang sedang belajar Pengembangan Aplikasi Mobile.",
    email = "jeremi.124140195@student.itera.ac.id",
    telepon = "085174204945",
    lokasi = "Lampung, Indonesia"
)
