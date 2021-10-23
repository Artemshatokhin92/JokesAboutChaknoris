package com.shatokhin.jokesaboutchaknoris.data.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

data class ICNDBInteractor(val apiICNDB: ApiICNDB){

    fun getJokes(numberPage: Int, callback: GetMoviesCallback) {

        apiICNDB.getJokes(numberPage).enqueue(object : Callback<Root> {

            override fun onResponse(call: Call<Root>, response: Response<Root>) {
                // если запрос прошел удачно
                if (response.isSuccessful) {
                    callback.onSuccess(response.body()!!) // получение Movie из кэша (либо только загруженные фильмы , либо с БД)
                // если запрос прошел НЕУДАЧНО (переписать код)
                } else {
                    callback.onError("Error: ${response.code()}")
                }
            }

            // если интернет не доступен (переписать код)
            override fun onFailure(call: Call<Root>, t: Throwable) {
                callback.onError("Network error probably...")
            }
        })
    }

    interface GetMoviesCallback {
        fun onSuccess(listJokes: Root)
        fun onError(error: String)
    }
}
