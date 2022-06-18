package com.linhpham.ailatrieuphu.data.shared_preferences

import androidx.lifecycle.MutableLiveData

interface SharedPreferencesHelper {
    val currentUserId : MutableLiveData<String>
    fun setCurrentUserId(storeId: String)
    fun getCurrentUserId(): String

}