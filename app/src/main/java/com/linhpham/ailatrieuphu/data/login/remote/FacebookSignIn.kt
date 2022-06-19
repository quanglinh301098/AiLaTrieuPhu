package com.linhpham.ailatrieuphu.data.login.remote

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class FacebookSignIn @Inject constructor(
    private val auth: FirebaseAuth
) {
    suspend fun login() {

    }

    suspend fun getCurrentUser() : FirebaseUser?{
        return auth.currentUser
    }

    suspend fun signOut() {
        auth.signOut()
    }
}