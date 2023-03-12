package com.example.composeschedule.network.dto
@kotlinx.serialization.Serializable
data class GroupsDto(
    val id : Int,
    val name : String,
    val created_at : String,
    val updated_at : String,
    val pivot : PivotDto
)
