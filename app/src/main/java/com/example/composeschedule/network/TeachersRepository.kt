package com.example.composeschedule.network

import com.example.composeschedule.network.dto.GroupDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TeachersRepository {

    private val api: TeachersApi = Network.getTeachersApi()

    suspend fun getTeachersList(){
        val teachers = api.getTeachersList()
        Network.teachers = teachers
    }
}
