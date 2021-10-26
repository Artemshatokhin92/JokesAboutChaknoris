package com.shatokhin.jokesaboutchaknoris.domain.repository

import com.shatokhin.jokesaboutchaknoris.domain.models.Joke

interface JokeRepository {
    suspend fun getJokes(numberOfJokes: Int): List<Joke>
}