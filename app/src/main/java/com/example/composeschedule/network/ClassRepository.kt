package com.example.composeschedule.network

import com.example.composeschedule.network.dto.ClassRequestBody
import com.example.composeschedule.network.dto.GroupDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.http.Body
import retrofit2.http.Query

class ClassRepository {

    private val api: ClassApi = Network.getClassApi()

    suspend fun getClassList(@Query ("date_start") date_start : String, @Query ("group_id") group_id : Int?, @Query ("teacher_id") teacher_id : Int?, @Query ("classroom_id") classroom_id : Int?){
        val clas = api.getClassList(date_start, group_id, teacher_id, classroom_id)
        Network.clas = clas
    }
}