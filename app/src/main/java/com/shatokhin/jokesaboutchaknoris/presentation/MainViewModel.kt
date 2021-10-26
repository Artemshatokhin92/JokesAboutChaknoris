package com.shatokhin.jokesaboutchaknoris.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shatokhin.jokesaboutchaknoris.domain.models.Joke
import com.shatokhin.jokesaboutchaknoris.domain.usecase.GetJokesUseCase
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.Exception

class MainViewModel(
    private val getJokesUseCase: GetJokesUseCase,
): ViewModel() {

    private val mListJokes = MutableLiveData<List<Joke>>()
    val listJokes: LiveData<List<Joke>>
        get() = mListJokes

    private val mErrorLoading = MutableLiveData<String>()
    val errorLoading: LiveData<String>
        get() = mErrorLoading

    fun reload(numberOfJokes: Int){
        viewModelScope.launch {
            try {
                val listJokes = getJokesUseCase.execute(numberOfJokes)
                mListJokes.value = listJokes
            } catch (http: HttpException){
                mErrorLoading.value = "Error network: ${http.code()}"
            } catch (e: Exception){
                mErrorLoading.value = "Error network probably...."
            }
        }
    }

}