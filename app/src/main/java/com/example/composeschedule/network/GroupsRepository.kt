package com.example.composeschedule.network

import com.example.composeschedule.network.dto.GroupDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GroupsRepository {

    private val api: GroupsApi = Network.getGroupsApi()

    suspend fun getGroupsList(){
        val groups = api.getGroupsList()
        Network.groups = groups
    }
}