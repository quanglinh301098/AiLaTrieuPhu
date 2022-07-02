package com.linhpham.ailatrieuphu.view.activity

import androidx.lifecycle.MutableLiveData
import com.linhpham.ailatrieuphu.backup.data.shared_preferences.SharedPreferencesHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val sharedPreferencesHelper: SharedPreferencesHelper) :
    BaseActivityViewModel() {


    private val _currentUserId = MutableLiveData<String>()
    val currentUserId = _currentUserId

    fun setCurrentUser(user: String) {
        sharedPreferencesHelper.setCurrentUserId(user)
        getCurrentUser()
    }

    fun getCurrentUser() {
        currentUserId.value = sharedPreferencesHelper.getCurrentUserId()
    }

}

