package ru.startandroid.develop.rickandmorty.api.models.personage

import com.google.gson.annotations.SerializedName

data class InfoPersonage(
    @SerializedName("pageNumber")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("prev")
    val prev: Any,
    @SerializedName("results")
    val results: List<PersonageModel>


)