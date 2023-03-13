package com.example.composeschedule.network.dto

import com.example.composeschedule.network.ClassroomsApi
import com.example.composeschedule.network.Network

class ClassroomsRepository {

    private val api: ClassroomsApi = Network.getClassroomsApi()

    suspend fun getClassroomsList(){
        val classrooms = api.getClassroomsList()
        Network.classrooms = classrooms
    }
}