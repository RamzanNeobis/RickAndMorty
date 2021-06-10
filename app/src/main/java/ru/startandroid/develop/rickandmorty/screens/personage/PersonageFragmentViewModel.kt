package ru.startandroid.develop.rickandmorty.screens.personage

import android.app.Application
import android.widget.Adapter
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.startandroid.develop.rickandmorty.api.AdapterItem
import ru.startandroid.develop.rickandmorty.api.ApiRequest

import ru.startandroid.develop.rickandmorty.api.RetrofitInstance
import ru.startandroid.develop.rickandmorty.api.models.personage.InfoPersonage

class PersonageFragmentViewModel(application: Application): AndroidViewModel(application) {

    var personageListLiveData: MutableLiveData<InfoPersonage> = MutableLiveData()

    fun getPersonageListObserver(): MutableLiveData<InfoPersonage>{
        return personageListLiveData
    }

    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.IO){
            val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(ApiRequest::class.java)
            val response = retrofitInstance.getAllPersonage()
            personageListLiveData.postValue(response)
        }
    }

}











































//    private val repository = Repository(application)
//    var showProgress : LiveData<Boolean>
//
//    init {
//        this.showProgress = repository.showProgress
//    }
//
//    fun changeState(){
//        repository.changeState()
//    }

