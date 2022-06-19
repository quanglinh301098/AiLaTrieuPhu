package com.linhpham.ailatrieuphu.data.login.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
@Singleton
class LoginModule {

    @Provides
    @Singleton
    fun provideAuthenticator(): FirebaseAuth {
        return Firebase.auth
    }


}