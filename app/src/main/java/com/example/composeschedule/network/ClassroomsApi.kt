package com.example.composeschedule.network

import com.example.composeschedule.network.dto.CorpusDto
import retrofit2.http.GET


interface ClassroomsApi {
    @GET("api/classroom")
    suspend fun getClassroomsList(): List<CorpusDto>

}