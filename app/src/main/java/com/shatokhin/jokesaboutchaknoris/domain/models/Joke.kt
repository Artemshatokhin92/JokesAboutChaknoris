package com.shatokhin.jokesaboutchaknoris.domain.models

data class Joke(
    val id: Int,
    val text: String,
    val category: List<String>
)