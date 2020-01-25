package com.android.mydigi.search

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.android.mydigi.R
import com.android.mydigi.adapters.ArtistsListAdapter
import com.android.mydigi.api.models.response.ArtistItemsBean
import com.android.mydigi.databinding.ActivitySearchBinding
import com.android.mydigi.utils.BaseActivity
import com.android.mydigi.utils.CheckRealTimeNetwork
import kotlinx.android.synthetic.main.activity_search.*


class SearchActivity : BaseActivity(), CheckRealTimeNetwork.ConnectivityReceiverListener {

    private lateinit var searchViewModel: SearchViewModel
    private lateinit var binding: ActivitySearchBinding
    private lateinit var artistsAdapter: RecyclerView.Adapter<*>
    private var artists = mutableListOf<ArtistItemsBean>()

    private var requestSearch = false
    private var waitSearch = false
    private var lastKeyWord = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)

        initArtistsAdapter()
        searchHandling()

        registerReceiver(
            CheckRealTimeNetwork(),
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )
    }

    private fun getData(keyWord: String) {
        searchViewModel.search(keyWord, apiCall).observe(this, Observer {
            loading.visibility = View.GONE
            requestSearch = false
            if (it.getThrowable() == null) {
                artists.addAll(it.getData()!!.artists.items)
                binding.artistsRecycler.adapter!!.notifyDataSetChanged()
            } else {
                showShortToast(it.getThrowable().toString())
            }
        })
    }

    private fun initArtistsAdapter() {
        artistsAdapter = ArtistsListAdapter(artists)
        binding.artistsRecycler.adapter = artistsAdapter
        binding.artistsRecycler.adapter!!.notifyDataSetChanged()
    }


    private fun searchHandling() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                requestSearch = true
                lastKeyWord = query.toString()
                loading.visibility = View.VISIBLE
                artists.clear()
                searchViewModel.clearData()
                artistsAdapter.notifyDataSetChanged()
                getData(query.toString())
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                return true
            }
        })
    }

    override fun onResume() {
        super.onResume()
        CheckRealTimeNetwork.connectivityReceiverListener = this
    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        if (isConnected) {
            if (requestSearch) {
                waitSearch = false
                getData(lastKeyWord)
            }
        } else {
            showShortToast("Check NetworkConnectivity")
            waitSearch = requestSearch
        }
    }

}
