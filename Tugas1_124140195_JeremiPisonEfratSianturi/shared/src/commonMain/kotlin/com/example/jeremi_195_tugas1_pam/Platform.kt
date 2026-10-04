package com.example.jeremi_195_tugas1_pam

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform