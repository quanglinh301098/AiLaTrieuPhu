package com.linhpham.ailatrieuphu.service.connect

import com.linhpham.ailatrieuphu.service.login.LoginResponse
import com.linhpham.ailatrieuphu.service.response.configure.ConfigResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface ConfigApiService {

    @GET("/v1/millionaire/mobile/configure")
    fun config (): Observable<Response<ConfigResponse>>

    @GET ("")
    fun login(): Observable<Response<LoginResponse>>

}