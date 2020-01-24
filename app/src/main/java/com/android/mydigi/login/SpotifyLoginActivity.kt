package com.android.mydigi.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.android.mydigi.R
import com.android.mydigi.databinding.ActivityLoginBinding
import com.android.mydigi.utils.BaseActivity
import com.android.mydigi.utils.Constants
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationResponse

/**
 * SpotifyAuthentication not working in kotlin activityResult !!!!!
 */


class SpotifyLoginActivity : BaseActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        loginViewModel.requestAuthentication(this)
    }




    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Check if result comes from the correct activity
        if (requestCode === Constants.LOGIN_REQUEST_CODE) {
            val response = AuthenticationClient.getResponse(resultCode, intent)
            when (response.type) {
                AuthenticationResponse.Type.TOKEN -> {
                    Log.v("spotifyToken", response.accessToken)
                }
                AuthenticationResponse.Type.ERROR -> {
                    Log.v("spotifyToken", response.type.toString())
                }
                else -> {
                    Log.v("spotifyToken", response.type.toString())
                }
            }
        }
    }

}
