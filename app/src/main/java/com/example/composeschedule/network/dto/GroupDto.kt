package com.example.composeschedule.network.dto
@kotlinx.serialization.Serializable
data class GroupDto(
    val id: Int,
    val name: String,
    val created_at: String? = null,
    val updated_at: String? = null
)
