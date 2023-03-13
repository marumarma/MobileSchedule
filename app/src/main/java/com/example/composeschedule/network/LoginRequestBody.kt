package com.example.composeschedule.network
@kotlinx.serialization.Serializable
data class LoginRequestBody(
    val email: String,
    var password: String
)