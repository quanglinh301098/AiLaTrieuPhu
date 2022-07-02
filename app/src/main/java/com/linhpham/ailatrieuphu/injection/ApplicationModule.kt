package com.linhpham.ailatrieuphu.injection

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.linhpham.ailatrieuphu.data.shared_preferences.SharedPreferencesHelper
import com.linhpham.ailatrieuphu.data.shared_preferences.SharedPreferencesImp
import com.linhpham.ailatrieuphu.data.utils.ApiClient
import com.linhpham.ailatrieuphu.utils.LogUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.Authenticator
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(context.packageName + "_preferences", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideSharedPreferencesHelper(sharedPreferences: SharedPreferences): SharedPreferencesHelper =
        SharedPreferencesImp(sharedPreferences)


    @Provides
    @Singleton
    fun provideAuthorizationInterceptor(sharedPreferencesHelper: SharedPreferencesHelper) =
        AuthorizationInterceptor(
            sharedPreferencesHelper
        )

    @Provides
    @Singleton
    fun provideApiClient(
        BASE_URL: String,
        authorizationInterceptor: AuthorizationInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): ApiClient = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(
            OkHttpClient.Builder()
                // A zero value means no timeout at all.
                // This is enforced because our client isn't able to send/receive a request body/response body always to/from the server within the defined timeout.
                // This guarantees that whatever the size of the image being uploaded is, it won't get `SocketTimeoutException` unless the server itself has issues.
                .writeTimeout(0, TimeUnit.SECONDS)
                .readTimeout(0, TimeUnit.SECONDS)
                .addInterceptor(authorizationInterceptor)
                .addInterceptor(loggingInterceptor)
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiClient::class.java)

}