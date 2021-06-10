package ru.startandroid.develop.rickandmorty.screens.episodes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.startandroid.develop.rickandmorty.api.ApiRequest
import ru.startandroid.develop.rickandmorty.api.RetrofitInstance
import ru.startandroid.develop.rickandmorty.api.models.episodes.InfoEpisodes

class EpisodeFragmentViewModel (application: Application): AndroidViewModel(application){

    var locationListLiveData: MutableLiveData<InfoEpisodes> = MutableLiveData()

    fun getLocationListObserver(): MutableLiveData<InfoEpisodes>{
        return locationListLiveData
    }

    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.IO){
            val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(ApiRequest::class.java)
            val response = retrofitInstance.getAllEpisodes()
            locationListLiveData.postValue(response)

        }
    }
}