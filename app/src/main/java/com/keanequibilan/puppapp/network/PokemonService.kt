package com.keanequibilan.puppapp.network

import com.keanequibilan.puppapp.network.model.PokedexResponse
import com.keanequibilan.puppapp.network.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {
    @GET("api/v2/pokemon/")
    suspend fun getPokedex(@Query("offset") offset: Int): PokedexResponse

    @GET("api/v2/pokemon/{id}/")
    suspend fun getPokemon(@Path("id") id: Int): PokemonResponse
}
