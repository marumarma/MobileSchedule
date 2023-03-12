package com.example.composeschedule.network.dto
@kotlinx.serialization.Serializable
data class RegisterDto(
    val name : String,
    val email : String,
    val password : String,
    val password_confirmation : String,
    val group_id : Int
)