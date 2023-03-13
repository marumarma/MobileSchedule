package com.example.composeschedule.network

import android.media.session.MediaSession.Token
import com.example.composeschedule.network.dto.GroupDto
import com.example.composeschedule.network.dto.TokenResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface AuthApi {
    @POST("api/auth/login")
    suspend fun login(@Body body: LoginRequestBody): TokenResponse

    @POST("api/auth/register")
    suspend fun register(@Body body : RegisterRequestBody): TokenResponse

    @POST("api/auth/logout")
    suspend fun logout(): TokenResponse

}