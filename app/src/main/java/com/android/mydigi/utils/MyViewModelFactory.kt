package com.android.mydigi.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.mydigi.api.ApiCall
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyViewModelFactory @Inject constructor(
    private val apiCall: ApiCall
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BaseViewModel::class.java)) {
            return BaseViewModel() as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class [$modelClass]")
        }
    }

}