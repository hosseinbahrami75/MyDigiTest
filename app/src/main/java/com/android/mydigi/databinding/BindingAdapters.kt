package com.android.mydigi.databinding

import android.widget.ImageView
import android.widget.MediaController
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

/**
 * Created by HosseinBahrami at 1/23/2020
 */
object BindingAdapters {
    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(v: ImageView?, url: String?) {
        Picasso.get().load(url).into(v)
    }
}