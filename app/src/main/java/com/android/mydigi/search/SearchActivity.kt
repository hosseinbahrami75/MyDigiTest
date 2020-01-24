package com.android.mydigi.search

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.android.mydigi.R
import com.android.mydigi.databinding.ActivitySearchBinding
import com.android.mydigi.utils.BaseActivity

class SearchActivity : BaseActivity() {

    private lateinit var searchViewModel: SearchViewModel
    private lateinit var binding: ActivitySearchBinding
    private lateinit var artistsAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)

        getData()
    }

    private fun getData() {
        searchViewModel.search("test", apiCall).observe(this, Observer {
            if (it.getThrowable() == null) {
                showShortToast(it.getData()!!.artists.items.size.toString())
            } else {
                showShortToast(it.getThrowable().toString())
            }
        })
    }
}
