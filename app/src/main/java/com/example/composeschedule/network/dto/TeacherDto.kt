package com.example.composeschedule.network.dto
@kotlinx.serialization.Serializable
data class TeacherDto(
    val id : Int,
    val name : String,
    val phone : String,
    val created_at : String,
    val updated_at : String
)