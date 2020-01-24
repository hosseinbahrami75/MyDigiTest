package com.android.mydigi.login

import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.spotify.sdk.android.authentication.AuthenticationResponse
import javax.inject.Inject

class LoginViewModel : ViewModel() {
    private var loginData: MutableLiveData<AuthenticationResponse> = MutableLiveData()

    fun requestAuthentication(context: Activity) {
        LoginRepository.authenticateSpotify(context)
    }

    fun getAuthenticationResponseData(): LiveData<AuthenticationResponse> {
        return loginData
    }

    fun setAuthenticationResponse(authenticationResponse: AuthenticationResponse) {
        loginData.value = authenticationResponse
    }

}