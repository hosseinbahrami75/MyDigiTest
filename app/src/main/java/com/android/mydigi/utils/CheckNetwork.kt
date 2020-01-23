package com.android.mydigi.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 *  Create by HosseinBahrami at 1/23/2020
 * Check Connectivity Network Mobile or WIFI
 */

object CheckNetwork {
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return connectivityManager!!.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)?.state == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)?.state == NetworkInfo.State.CONNECTED
    }

}