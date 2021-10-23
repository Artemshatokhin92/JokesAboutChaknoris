package com.shatokhin.jokesaboutchaknoris.data.network

data class Root(
    val type: String,
    val listJokes: List<JokeJson>
)
