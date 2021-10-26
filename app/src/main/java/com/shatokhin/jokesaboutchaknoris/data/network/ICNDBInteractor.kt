package com.shatokhin.jokesaboutchaknoris.data.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

data class ICNDBInteractor(val apiICNDB: ApiICNDB){

    suspend fun getJokes(numberOfJokes: Int): Root {
        return apiICNDB.getJokesAsync(numberOfJokes)
    }
}
