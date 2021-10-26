package com.shatokhin.jokesaboutchaknoris.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shatokhin.jokesaboutchaknoris.data.repository.JokeRepositoryImpl
import com.shatokhin.jokesaboutchaknoris.domain.usecase.GetJokesUseCase

class MainViewModelFactory: ViewModelProvider.Factory {

    private val jokeRepository by lazy(LazyThreadSafetyMode.NONE) {
        JokeRepositoryImpl()
    }

    private val getJokesUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetJokesUseCase(jokeRepository = jokeRepository)
    }


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(
            getJokesUseCase = getJokesUseCase,
        ) as T
    }

}