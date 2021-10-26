package com.shatokhin.jokesaboutchaknoris

import android.app.Application
import com.google.gson.Gson
import com.shatokhin.jokesaboutchaknoris.data.network.ApiICNDB
import com.shatokhin.jokesaboutchaknoris.data.network.ICNDBInteractor
import dagger.hilt.android.HiltAndroidApp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {
    companion object {
        const val BASE_URL = "http://api.icndb.com"

        lateinit var instance: App
            private set
    }

    lateinit var apiICNDB: ApiICNDB
    lateinit var icndbInteractor: ICNDBInteractor

    override fun onCreate() {
        super.onCreate()

        instance = this

        initRetrofit()
        initInteractor()
    }

    private fun initRetrofit() {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        apiICNDB = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(ApiICNDB::class.java)
    }

    private fun initInteractor() {
        icndbInteractor = ICNDBInteractor(apiICNDB)
    }

}