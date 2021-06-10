package ru.startandroid.develop.rickandmorty.api.models.locations

import com.google.gson.annotations.SerializedName

data class LocationModel(

    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("dimensions")
    val dimensions: String
)
