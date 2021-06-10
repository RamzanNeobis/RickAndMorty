package ru.startandroid.develop.rickandmorty.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.startandroid.develop.rickandmorty.utils.BASE_URL

class RetrofitInstance {

    companion object{
        private const val baseUrl = BASE_URL

        fun getRetrofitInstance(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }



}