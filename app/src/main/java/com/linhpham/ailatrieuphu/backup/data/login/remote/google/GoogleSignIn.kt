package com.linhpham.ailatrieuphu.backup.data.login.remote.google

import com.google.firebase.auth.FirebaseUser

interface GoogleSignIn {
    fun login()
    fun userSigned() : FirebaseUser?
    fun signOut()
    fun signInCallBack()
}