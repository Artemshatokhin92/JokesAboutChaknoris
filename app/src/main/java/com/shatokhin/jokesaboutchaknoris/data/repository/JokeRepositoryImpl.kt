package com.shatokhin.jokesaboutchaknoris.data.repository

import com.shatokhin.jokesaboutchaknoris.App
import com.shatokhin.jokesaboutchaknoris.domain.models.Joke
import com.shatokhin.jokesaboutchaknoris.domain.repository.JokeRepository

class JokeRepositoryImpl: JokeRepository {
    val icndbInteractor = App.instance.icndbInteractor

    override suspend fun getJokes(numberOfJokes: Int): List<Joke>{
        val listJokes: MutableList<Joke> = mutableListOf()

        val root = icndbInteractor.getJokes(numberOfJokes)
        root.listJokes.forEach {
            listJokes.add( Joke(it.id, it.text, it.category) )
        }

        return listJokes
    }

}