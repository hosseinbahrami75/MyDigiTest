package com.android.mydigi.utils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

/**
 *  Created by HosseinBahrami at 1/23/2020
 */

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //CheckInternet
    protected fun inNetworkConnected(): Boolean {
        return CheckNetwork.isNetworkAvailable(this)
    }

    protected fun showLongToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    protected fun showShortToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}
