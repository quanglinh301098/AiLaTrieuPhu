package com.linhpham.ailatrieuphu.service.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.linhpham.ailatrieuphu.data.entites.User

data class LoginData(
    @SerializedName("user")
    val user: User,
    @SerializedName("access-token") val accessToken: String,
    @SerializedName("fcm-token") val fcmToken: String,
    @Expose val uid: String
)