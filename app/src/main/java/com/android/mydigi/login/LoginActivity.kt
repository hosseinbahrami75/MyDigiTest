package com.android.mydigi.login

import android.content.Intent
import android.os.Bundle
import com.android.mydigi.R
import com.android.mydigi.utils.BaseActivity
import com.android.mydigi.utils.Constants
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse


class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Check if result comes from the correct activity
        if (requestCode === Constants.LOGIN_REQUEST_CODE) {
            val response = AuthenticationClient.getResponse(resultCode, intent)
            when (response.type) {
                AuthenticationResponse.Type.TOKEN -> {

                }
                AuthenticationResponse.Type.ERROR -> {

                }
                else -> {

                }
            }
        }
    }

}
