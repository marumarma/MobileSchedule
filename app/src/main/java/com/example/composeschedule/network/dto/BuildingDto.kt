package com.example.composeschedule.network.dto
@kotlinx.serialization.Serializable
data class BuildingDto(
    val id : Int,
    val name : String,
    val address : String,
    val created_at : String,
    val updated_at : String
)