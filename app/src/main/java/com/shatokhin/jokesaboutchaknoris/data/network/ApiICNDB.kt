package com.shatokhin.jokesaboutchaknoris.data.network

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiICNDB {
    @GET("/jokes/random/{numberOfJokes}")
    suspend fun getJokesAsync(@Path("numberOfJokes") numberOfJokes: Int): Root
}