package com.linhpham.ailatrieuphu.backup.data.login.remote.google

import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.linhpham.ailatrieuphu.helper.Constant
import javax.inject.Inject

class GoogleSignInImp @Inject constructor(
    private val auth : FirebaseAuth,
    private val googleSignInCallBack: GoogleSignInCallBack
) : GoogleSignIn {

    private var signInRequest : BeginSignInRequest = BeginSignInRequest.builder()
        .setGoogleIdTokenRequestOptions(
            BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                .setSupported(true)
                // Your server's client ID, not your Android client ID.
//                    .setServerClientId(getString(R.string.your_web_client_id))
                // Only show accounts previously used to sign in.
                .setFilterByAuthorizedAccounts(true)
                .build())
        .build()

    override fun login() {

    }

    override fun signInCallBack(){
        val firebaseCredential = GoogleAuthProvider.getCredential("", null)
        auth.signInWithCredential(firebaseCredential).addOnCompleteListener {
            if (it.isSuccessful){
                googleSignInCallBack.loginSuccess(auth.currentUser)
            }
        }
    }

    override fun userSigned(): FirebaseUser? {
       return auth.currentUser
    }

    override fun signOut() {
        auth.signOut()
    }

}