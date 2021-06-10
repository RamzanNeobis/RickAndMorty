package ru.startandroid.develop.rickandmorty.api

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import ru.startandroid.develop.rickandmorty.api.models.episodes.InfoEpisodes
import ru.startandroid.develop.rickandmorty.api.models.locations.InfoLocations
import ru.startandroid.develop.rickandmorty.api.models.locations.LocationModel
import ru.startandroid.develop.rickandmorty.api.models.personage.InfoPersonage
import ru.startandroid.develop.rickandmorty.api.models.personage.PersonageModel

interface ApiRequest {


    @Headers("Content-Type:application/json")
    @GET("character")
    suspend fun getAllPersonage(): InfoPersonage


    @Headers("Content-Type:application/json")
    @GET("location")
    suspend fun getAllLocation(): InfoLocations


    @Headers("Content-Type:application/json")
    @GET("episode")
    suspend fun getAllEpisodes(): InfoEpisodes

    @GET("character")
    suspend fun getAllResult(@Query("query") query: String): InfoPersonage


}

sealed class AdapterItem {
    data class PersonObject(val item: PersonageModel) : AdapterItem()
    data class LocationObject(val item: LocationModel    ): AdapterItem()
}
