package com.example.composeschedule.network

import com.example.composeschedule.network.dto.ClassDto
import com.example.composeschedule.network.dto.ClassRequestBody
import com.example.composeschedule.network.dto.GroupDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query


interface ClassApi {
    @GET("api/class")
    suspend fun getClassList(@Query ("date_start") date_start : String, @Query ("group_id") group_id : Int?, @Query ("teacher_id") teacher_id : Int?, @Query ("classroom_id") classroom_id : Int? ): List<ClassDto>

}