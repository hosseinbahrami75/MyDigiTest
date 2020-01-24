package com.android.mydigi.api

import com.android.mydigi.api.models.response.SearchResultBean
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by HosseinBahrami at 1/24/2020
 */

interface ApiCall {

//    Search in Spotify
    @GET("/v1/search?type=artist")
    fun searchAsync(@Query("q") keyWord: String): Deferred<SearchResultBean>

}
