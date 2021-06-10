package ru.startandroid.develop.rickandmorty.api


import androidx.lifecycle.MutableLiveData


class Repository {


    private val showProgress = MutableLiveData<Boolean>()
    fun changeState() {
        showProgress.value = !(showProgress.value != null && showProgress.value!!)

    }
}







