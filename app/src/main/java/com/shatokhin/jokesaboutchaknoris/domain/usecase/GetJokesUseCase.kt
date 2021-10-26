package com.shatokhin.jokesaboutchaknoris.domain.usecase

import com.shatokhin.jokesaboutchaknoris.domain.models.Joke
import com.shatokhin.jokesaboutchaknoris.domain.repository.JokeRepository

class GetJokesUseCase(private val jokeRepository: JokeRepository) {
    suspend fun execute(numberOfJokes: Int): List<Joke> = jokeRepository.getJokes(numberOfJokes)
}