package com.android.mydigi.utils

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

open class BaseViewModel : ViewModel() {
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