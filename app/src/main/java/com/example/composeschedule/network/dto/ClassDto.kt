package com.example.composeschedule.network.dto
@kotlinx.serialization.Serializable
data class ClassDto(
    val id : Int,
    val subject_id : Int,
    val teacher_id : Int,
    val classroom_id : Int,
    val timeslot_id : Int,
    val date_start : String,
    val date_end : String,
    val period : Int,
    val created_at : String,
    val updated_at : String,
    val date : String,
    val subject : SubjectDto,
    val teacher : TeacherDto,
    val classroom : PlaceDto,
    val timeslot : TimeslotDto,
    val groups : List<GroupsDto>

)


