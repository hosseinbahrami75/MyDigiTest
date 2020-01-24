package com.android.mydigi.utils

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.mydigi.App
import com.android.mydigi.api.ApiCall
import kotlinx.coroutines.*
import javax.inject.Inject
import javax.inject.Named

/**
 *  Created by HosseinBahrami at 1/23/2020
 */

open class BaseActivity : AppCompatActivity() {
    @field:[Inject Named("non-cached")]
    lateinit var apiCall: ApiCall

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
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


    protected fun <T> callApi(
        request: Deferred<T>,
        onSuccess: (T) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        GlobalScope.launch {
            try {
                val response = request.await()
                withContext(Dispatchers.Main) {
                    onSuccess(response)
                }
            } catch (e: Throwable) {
                withContext(Dispatchers.Main) {
                    onError(e)
                }
            }
        }
    }

}
