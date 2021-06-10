package ru.startandroid.develop.rickandmorty.api.models.episodes

import com.google.gson.annotations.SerializedName

data class InfoEpisodes(

    @SerializedName("results")
    val results: List<EpisodesModel>
)
