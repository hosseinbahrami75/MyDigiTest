package com.android.mydigi.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.mydigi.api.models.response.ArtistItemsBean
import com.android.mydigi.databinding.ArtistsItemBinding
import com.squareup.picasso.Picasso

/**
 *  Created by HosseinBahrami at 1/24/2020
 */

class ArtistsListAdapter(private var artists: List<ArtistItemsBean>) :
    RecyclerView.Adapter<ArtistsListAdapter.ArtistsViewHolder>() {
    init {
        setHasStableIds(true)
    }

    inner class ArtistsViewHolder(
        private val binding: ArtistsItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ArtistItemsBean) {
            binding.data = item
            binding.totalTracks.text = item.popularity.toString()
            if (!item.images.isNullOrEmpty()) {
                Picasso.get().load(item.images[0].url).into(binding.imgArtist)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ArtistsItemBinding.inflate(inflater)
        return ArtistsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistsViewHolder, position: Int) {
        holder.bind(artists[position])
    }

    override fun getItemCount(): Int = artists.size
    override fun getItemViewType(position: Int): Int = position
//    override fun getItemId(position: Int): Long = artists[position].id.toLong()

}