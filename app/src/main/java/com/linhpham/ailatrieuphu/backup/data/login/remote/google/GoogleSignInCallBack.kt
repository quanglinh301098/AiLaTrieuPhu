package com.linhpham.ailatrieuphu.backup.data.login.remote.google

import com.google.firebase.auth.FirebaseUser

interface GoogleSignInCallBack {
    fun loginSuccess(fireBaseUser:FirebaseUser?)
}