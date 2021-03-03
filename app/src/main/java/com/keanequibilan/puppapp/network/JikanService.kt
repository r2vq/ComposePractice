package com.keanequibilan.puppapp.network

import com.keanequibilan.puppapp.network.model.TopResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface JikanService {
    @GET("v3/top/anime/{page}/upcoming")
    suspend fun getTopUpcoming(@Path("page") page: Int): TopResponse

}
