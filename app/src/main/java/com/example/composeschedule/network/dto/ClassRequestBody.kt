package com.example.composeschedule.network.dto
@kotlinx.serialization.Serializable
data class ClassRequestBody(
    val date_start : String,
    val group_id : Int? = null,
    val teacher_id : Int? = null,
    val classroom_id : Int? = null
)
