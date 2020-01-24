package com.android.mydigi.search

import androidx.lifecycle.MutableLiveData
import com.android.mydigi.api.ApiCall
import com.android.mydigi.api.SearchResources
import com.android.mydigi.utils.BaseViewModel

class SearchViewModel: BaseViewModel() {
    private var searchLiveDat: MutableLiveData<SearchResources> = MutableLiveData()

    fun search(keyWord: String, apiCall: ApiCall): MutableLiveData<SearchResources> {
        callApi(apiCall.searchAsync(keyWord), {
            searchLiveDat.value = SearchResources(it)
        }, {
            searchLiveDat.value = SearchResources(it)
        })
        return searchLiveDat
    }

}