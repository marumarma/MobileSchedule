package com.example.composeschedule.network

import com.example.composeschedule.network.dto.*
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


object Network {
    private const val BASE_URL = "http://185.46.8.41/"
    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    private fun getHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder().apply {
            connectTimeout(15, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
            addInterceptor(Interceptor())
            val logLevel = HttpLoggingInterceptor.Level.BODY
            addInterceptor(HttpLoggingInterceptor().setLevel(logLevel))
        }
        return client.build()
    }

    @OptIn(ExperimentalSerializationApi::class)
    private fun getRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                json.asConverterFactory("application/json".toMediaType()))

            .client(getHttpClient())
            .build()
        return retrofit
    }

    private val retrofit: Retrofit = getRetrofit()
    var groups : List<GroupDto> ?= null
    var teachers : List<TeacherDto> ?= null
    var classrooms : List<CorpusDto> ?= null
    var clas : List<ClassDto> = listOf()

    var token: TokenResponse? = null

    fun getGroupsApi(): GroupsApi = retrofit.create(GroupsApi::class.java)
    fun getTeachersApi(): TeachersApi = retrofit.create(TeachersApi::class.java)
    fun getClassroomsApi(): ClassroomsApi = retrofit.create(ClassroomsApi::class.java)
    fun getClassApi(): ClassApi = retrofit.create(ClassApi::class.java)

    fun getAuthApi(): AuthApi = retrofit.create(AuthApi::class.java)
}