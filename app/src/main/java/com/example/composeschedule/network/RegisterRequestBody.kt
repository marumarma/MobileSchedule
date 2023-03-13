package com.example.composeschedule.network
@kotlinx.serialization.Serializable
data class RegisterRequestBody(
    val name: String,
    val email: String,
    var password: String,
    val password_confirmation: String,
    val group_id: Int
)