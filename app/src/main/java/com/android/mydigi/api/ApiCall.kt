package com.android.mydigi.api

import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.http.GET

/**
 * Created by HosseinBahrami at 1/24/2020
 */

interface ApiCall {

    @GET("pnfbu")
    fun getGamesAsync(): Deferred<List<ResponseBody>>

}
