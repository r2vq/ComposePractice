package com.keanequibilan.puppapp.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AnimeResponse(
    val image_url: String,
    val mal_id: String,
    val title: String,
    val type: String
)
