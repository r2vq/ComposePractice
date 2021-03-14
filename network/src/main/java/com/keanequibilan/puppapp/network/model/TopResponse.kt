package com.keanequibilan.puppapp.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopResponse(
    val top: List<AnimeResponse>
)
