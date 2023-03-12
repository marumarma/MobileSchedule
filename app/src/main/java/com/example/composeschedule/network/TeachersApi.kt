package com.example.composeschedule.network

import com.example.composeschedule.network.dto.GroupDto
import com.example.composeschedule.network.dto.TeacherDto
import retrofit2.http.GET


interface TeachersApi {
    @GET("api/teacher")
    suspend fun getTeachersList(): List<TeacherDto>

}