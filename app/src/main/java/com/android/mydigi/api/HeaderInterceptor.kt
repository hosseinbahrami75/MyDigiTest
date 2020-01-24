package com.android.mydigi.api

import android.os.Build
import com.android.mydigi.utils.Constants
import okhttp3.Interceptor
import okhttp3.Response


/**
 * Created by HosseinBahrami at 1/24/2020
 * Set Header for Requests
 */

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val userAgent = "Android ${Build.MANUFACTURER} ${Build.BRAND} ${Build.MODEL} ${Build.VERSION.SDK_INT}"
        val request = chain.request().newBuilder()
            /**
             * SomeTimes No Needed Bearer Word in Authorization
             */
            .addHeader("Authorization", "Bearer ${Constants.ACCESS_TOKEN}")
            .addHeader("Accept", "application/json")
            .addHeader("User-Agent", userAgent)
            .build()
        return chain.proceed(request)
    }
}