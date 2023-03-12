package com.example.composeschedule.network

import com.example.composeschedule.network.dto.GroupDto
import retrofit2.http.GET


interface GroupsApi {
    @GET("api/group")
    suspend fun getGroupsList(): List<GroupDto>

}