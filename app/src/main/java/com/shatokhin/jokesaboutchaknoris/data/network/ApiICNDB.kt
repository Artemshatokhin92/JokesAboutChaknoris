package com.shatokhin.jokesaboutchaknoris.data.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiICNDB {
    // добавить все возможные варианты api из http://www.icndb.com/api/
    @GET("/jokes/random/{numberOfJokes}")
    fun getJokes(@Path("numberOfJokes") numberOfJokes: Int): Call<Root> // исправить на Root
}