package com.keanequibilan.puppapp.network

import retrofit2.http.GET
import retrofit2.http.Path

interface DogService {
    @GET("api/breeds/image/random/{count}")
    suspend fun randomDogs(@Path("count") count: Int): Response

    data class Response(
        val message: List<String>,
        val status: String
    )
}
