package ru.startandroid.develop.rickandmorty.screens.search

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.http.Query
import ru.startandroid.develop.rickandmorty.api.AdapterItem
import ru.startandroid.develop.rickandmorty.api.ApiRequest
import ru.startandroid.develop.rickandmorty.api.RetrofitInstance
import ru.startandroid.develop.rickandmorty.api.models.personage.InfoPersonage


class SearchFragmentViewModel(application: Application): AndroidViewModel(application){


    var searchLiveData: MutableLiveData<InfoPersonage> = MutableLiveData()

    fun getPersonageListObserver(): MutableLiveData<InfoPersonage>{
        return searchLiveData
    }

    fun makeApiCall(query: String){
        viewModelScope.launch(Dispatchers.IO){
            val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(ApiRequest::class.java)
            val response = retrofitInstance.getAllResult(query)
            val adapterItem: List<AdapterItem> = response.results.map { AdapterItem.PersonObject(it) }
            adapterItem.forEach {
                when(it) {
                    is AdapterItem.PersonObject -> {
                        it.item.name == query
                    }
                    is AdapterItem.LocationObject -> {
                        it.item.name
                    }
                }
            }
            searchLiveData.postValue(response)
        }
    }



}

































//
//
//var locationListLiveData: MutableLiveData<InfoPersonage> = MutableLiveData()
//
//fun getSearchListObserver(): MutableLiveData<InfoPersonage>{
//    return locationListLiveData
//}
//
//fun makeApiCall(query: String){
//    viewModelScope.launch(Dispatchers.IO){
//        val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(ApiRequest::class.java)
//        val response = retrofitInstance.getAllResult(query)
//        locationListLiveData.postValue(response)
//
//    }
//}





















//    fun getSearch(search: String){
//
//        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
//
//        val service = retrofit.create(ApiRequest::class.java)
//
//        service.getAllResult(search).enqueue(object : Callback<InfoPersonage>{
//            override fun onResponse(call: Call<InfoPersonage>, response: Response<InfoPersonage>) {
//                Log.d("Search", "Response :${Gson().toJson(response.body())}")
//            }
//
//            override fun onFailure(call: Call<InfoPersonage>, t: Throwable) {
//                showToast("error")
//            }
//
//        })
//    }