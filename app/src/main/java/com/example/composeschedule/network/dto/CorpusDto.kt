package com.example.composeschedule.network.dto
@kotlinx.serialization.Serializable
data class CorpusDto(
    val id : Int,
    val name : String,
    val address : String,
    val created_at : String,
    val updated_at : String,
    val classrooms : List<ClassroomDto>
)
