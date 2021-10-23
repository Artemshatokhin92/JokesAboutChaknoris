package com.shatokhin.jokesaboutchaknoris.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.shatokhin.jokesaboutchaknoris.App
import com.shatokhin.jokesaboutchaknoris.R
import com.shatokhin.jokesaboutchaknoris.data.network.ICNDBInteractor
import com.shatokhin.jokesaboutchaknoris.data.network.Root

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val icndbInteractor = App.instance.icndbInteractor

        fun onGetPageMovies(numberPage: Int){
            // getPageMovies передаем номер страницы и колбак (что делать если удачно и не удачно)
            icndbInteractor.getJokes(numberPage, object : ICNDBInteractor.GetMoviesCallback {
                // если удачно загруженны фильмы
                override fun onSuccess(listJokes: Root) {
                    val text = listJokes.listJokes[0].text
                    Log.d("myTest", text)
                }

                // если ошибка в загрузки
                override fun onError(error: String) {
                    Log.d("myTest", "сработал метод onError $error")
                }
            })

        }

//        onGetPageMovies(3)
    }
}