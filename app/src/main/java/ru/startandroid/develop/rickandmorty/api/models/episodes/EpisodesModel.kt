package ru.startandroid.develop.rickandmorty.api.models.episodes

import com.google.gson.annotations.SerializedName

data class EpisodesModel(

    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("air_date")
    val date: String,
    @SerializedName("episode")
    val episode: String

)
