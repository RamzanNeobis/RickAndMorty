package ru.startandroid.develop.rickandmorty.api.models.locations

import com.google.gson.annotations.SerializedName

class InfoLocations(

    @SerializedName("count")
    val count: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("prev")
    val prev: Any,
    @SerializedName("results")
    val results: List<LocationModel>

)