package com.example.composeschedule.network.dto
@kotlinx.serialization.Serializable
data class PivotDto(
    val class_id : Int,
    val group_id : Int,
    val created_at : String,
    val updated_at : String
)
