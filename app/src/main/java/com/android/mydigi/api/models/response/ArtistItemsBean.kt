package com.android.mydigi.api.models.response

data class ArtistItemsBean(
    val id: String,
    val images: List<ImageBean>,
    val name: String,
    val type: String,
    val popularity: Int
) {
    val image = images[0]
}