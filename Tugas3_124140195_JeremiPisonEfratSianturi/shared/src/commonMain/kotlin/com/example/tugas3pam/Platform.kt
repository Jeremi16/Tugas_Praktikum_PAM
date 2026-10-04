package com.example.tugas3pam

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform