package com.android.mydigi.login

import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.spotify.sdk.android.authentication.AuthenticationResponse
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository) : ViewModel() {
    private var loginData: MutableLiveData<AuthenticationResponse> = MutableLiveData()

    fun getLoginLiveData(context: Activity) {
        loginRepository.authenticateSpotify(context)
    }
}