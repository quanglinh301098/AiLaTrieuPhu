package com.linhpham.ailatrieuphu.backup.data.login.remote

import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import javax.inject.Inject

class GoogleSignIn @Inject constructor(
    private val auth: FirebaseAuth
) {
    private lateinit var signInRequest : BeginSignInRequest

    suspend fun login() {
         signInRequest = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setFilterByAuthorizedAccounts(true)
                    .build())
            .build()
    }

    fun signInCallBack(){
        val firebaseCredential = GoogleAuthProvider.getCredential("", null)
        auth.signInWithCredential(firebaseCredential).addOnCompleteListener {
            if (it.isSuccessful){
                //ở đây làm sao để em bắn interface ra ngoài được vậy anh luis
            }
        }
    }

    suspend fun getCurrentUser() : FirebaseUser?{
        return auth.currentUser
    }

    suspend fun signOut() {
        auth.signOut()
    }
}