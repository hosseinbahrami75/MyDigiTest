package com.android.mydigi.api

import com.android.mydigi.api.models.response.SearchResultBean

class SearchResources {

    private var data: SearchResultBean? = null
    private var mThrowable: Throwable? = null

    constructor(mList: SearchResultBean?) {
        data = mList
    }

    constructor(throwable: Throwable?) {
        mThrowable = throwable
    }

    fun getData(): SearchResultBean? {
        return data
    }

    fun getThrowable(): Throwable? {
        return mThrowable
    }

}