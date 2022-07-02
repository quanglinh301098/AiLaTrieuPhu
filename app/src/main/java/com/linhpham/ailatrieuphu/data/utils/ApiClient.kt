package com.linhpham.ailatrieuphu.data.utils

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiClient {
    @POST("/api/login")
    suspend fun login(@Body login: String): Response<String>
}