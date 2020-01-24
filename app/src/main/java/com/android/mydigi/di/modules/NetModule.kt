package com.android.mydigi.di.modules

import com.android.mydigi.api.ApiCall
import com.android.mydigi.api.HeaderInterceptor
import com.android.mydigi.utils.Constants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


/**
 * Created by HosseinBahrami at 1/24/2020
 * Configuration Retrofit
 */

@Module
class NetModule {
    private var retrofit: Retrofit? = null

    @Provides
    @Named("non-cached")
    @Singleton
    fun getService(): ApiCall {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(HeaderInterceptor())
                        .connectTimeout(Constants.CONNECT_TIME_OUT, TimeUnit.SECONDS)
                        .readTimeout(Constants.READ_TIME_OUT, TimeUnit.SECONDS)
                        .writeTimeout(Constants.WRITE_TIME_OUT, TimeUnit.SECONDS)
                        .build()
                )
                .build()
        }
        return retrofit!!.create(ApiCall::class.java)
    }
}