package com.linhpham.ailatrieuphu.injection

import com.linhpham.ailatrieuphu.data.shared_preferences.SharedPreferencesHelper
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthorizationInterceptor @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        sharedPreferencesHelper.getCurrentUserId().takeIf { it.isNotEmpty() }?.let {
            request.addHeader("Authorization", "Bearer $it")
        }
        return chain.proceed(request.build())
    }
}