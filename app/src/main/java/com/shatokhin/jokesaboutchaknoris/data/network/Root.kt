package com.shatokhin.jokesaboutchaknoris.data.network

import com.google.gson.annotations.SerializedName

data class Root(
    @SerializedName("type")
    val type: String,
    @SerializedName("value")
    val listJokes: List<JokeJson>,
)
