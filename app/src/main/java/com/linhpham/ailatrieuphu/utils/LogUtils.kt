package com.linhpham.ailatrieuphu.utils

import android.util.Log
import com.linhpham.ailatrieuphu.BuildConfig

object LogUtils {
    fun d(message: String){
        if (BuildConfig.DEBUG){
            Log.d("LogApplication",message)
        }
    }
}