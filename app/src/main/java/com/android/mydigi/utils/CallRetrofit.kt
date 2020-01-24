package com.android.mydigi.utils

import com.android.mydigi.api.ApiCall
import kotlinx.coroutines.*
import javax.inject.Inject
import javax.inject.Named

open class CallRetrofit {
    @field:[Inject Named("non-cached")]
    lateinit var apiCall: ApiCall

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