package com.keanequibilan.puppapp.network

import com.squareup.moshi.JsonClass
import retrofit2.http.GET
import retrofit2.http.Path

interface DogService {
    @GET("api/breeds/image/random/{count}")
    suspend fun randomDogs(@Path("count") count: Int): Response

    @JsonClass(generateAdapter = true)
    data class Response(
        val message: List<String>,
        val status: String
    )
}
