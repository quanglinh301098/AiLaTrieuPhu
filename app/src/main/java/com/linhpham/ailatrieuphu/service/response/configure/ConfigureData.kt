package com.linhpham.ailatrieuphu.service.response.configure

import com.google.gson.annotations.SerializedName

data class ConfigureData(
    val baseUrl: String,
    @SerializedName("android-min-version")
    val androidMinVersion: String,
    @SerializedName("android-latest-version")
    val androidLastedVersion: String
)
