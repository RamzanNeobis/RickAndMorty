package ru.startandroid.develop.rickandmorty.screens.locations

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.startandroid.develop.rickandmorty.api.ApiRequest
import ru.startandroid.develop.rickandmorty.api.RetrofitInstance
import ru.startandroid.develop.rickandmorty.api.models.locations.InfoLocations
import ru.startandroid.develop.rickandmorty.api.models.personage.InfoPersonage

class LocationFragmentViewModel(application: Application): AndroidViewModel(application){

    var locationListLiveData: MutableLiveData<InfoLocations> = MutableLiveData()

    fun getLocationListObserver(): MutableLiveData<InfoLocations>{
        return locationListLiveData
    }

    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.IO){
            val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(ApiRequest::class.java)
            val response = retrofitInstance.getAllLocation()
            locationListLiveData.postValue(response)

        }
    }
}