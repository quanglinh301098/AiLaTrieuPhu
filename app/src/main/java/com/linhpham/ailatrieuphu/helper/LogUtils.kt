package com.linhpham.ailatrieuphu.helper

import android.util.Log
import androidx.viewbinding.BuildConfig

object LogUtils {
    fun d(message: String){
        if (BuildConfig.DEBUG){
            Log.d("LogApplication",message)
        }
    }
}