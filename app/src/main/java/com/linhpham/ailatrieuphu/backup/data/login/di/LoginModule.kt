package com.linhpham.ailatrieuphu.backup.data.login.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.linhpham.ailatrieuphu.backup.data.login.remote.google.GoogleSignIn
import com.linhpham.ailatrieuphu.backup.data.login.remote.google.GoogleSignInCallBack
import com.linhpham.ailatrieuphu.backup.data.login.remote.google.GoogleSignInImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
class LoginModule {

    @Provides
    fun provideFirebaseAuth() : FirebaseAuth = Firebase.auth

//    @Provides
//    fun provideGoogleSignInCallBack() : GoogleSignInCallBack = GoogleSignInCallBack

    @Provides
    fun provideGoogleSignIn(
        firebaseAuth: FirebaseAuth,
        googleSignInCallBack: GoogleSignInCallBack
    ): GoogleSignIn = GoogleSignInImp(firebaseAuth, googleSignInCallBack)
}