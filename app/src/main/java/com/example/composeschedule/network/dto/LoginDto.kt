package com.example.composeschedule.network.dto
@kotlinx.serialization.Serializable
data class LoginDto(
    val email : String,
    val password : String
)
