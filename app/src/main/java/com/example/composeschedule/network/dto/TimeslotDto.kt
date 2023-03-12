package com.example.composeschedule.network.dto
@kotlinx.serialization.Serializable
data class TimeslotDto(
    val id : Int,
    val day : String,
    val start_time : String,
    val end_time : String,
    val created_at : String,
    val updated_at : String
)
