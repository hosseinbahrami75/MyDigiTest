package com.android.mydigi.login

import android.app.Activity
import com.android.mydigi.utils.Constants
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse
import javax.inject.Singleton

@Singleton
object LoginRepository {

    fun authenticateSpotify(contextActivity: Activity) {
        val builder = AuthenticationRequest.Builder(
            Constants.CLIENT_ID,
            AuthenticationResponse.Type.TOKEN,
            Constants.REDIRECT_URI
        )

        builder.setScopes(arrayOf("app-remote-control"))
        val request = builder.build()
        AuthenticationClient.openLoginActivity(contextActivity, Constants.LOGIN_REQUEST_CODE, request)
    }

}