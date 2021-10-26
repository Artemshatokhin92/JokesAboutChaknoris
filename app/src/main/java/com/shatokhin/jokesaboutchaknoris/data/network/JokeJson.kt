package com.shatokhin.jokesaboutchaknoris.data.network

import com.google.gson.annotations.SerializedName

data class JokeJson(
    @SerializedName("id")
    val id: Int,
    @SerializedName("joke")
    val text: String,
    @SerializedName("categories")
    val category: List<String>
    )
