package com.example.composeschedule.network.dto
@kotlinx.serialization.Serializable
data class ClassroomDto(
    val id : Int,
    val name: String,
    val building_id : Int,
    val created_at : String,
    val updated_at : String
)