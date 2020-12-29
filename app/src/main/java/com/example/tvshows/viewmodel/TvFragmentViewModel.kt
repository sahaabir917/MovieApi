package com.example.tvshows.viewmodel

import android.app.Application
import android.util.Log
import android.util.Log.d
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tvshows.network.Api
import com.example.tvshows.network.TvShowsData
import com.example.tvshows.network.TvShowsDataItem
import com.example.tvshows.repositories.LiveDataRepository
import retrofit2.Call
import retrofit2.Response

class TvFragmentViewModel() : ViewModel() {

//    var repository = LiveDataRepository()
//
//    fun requestNetwork() {
//        repository.getNetworkService()
//    }

    private val _properties = MutableLiveData<TvShowsData>()
    val properties: LiveData<TvShowsData>
        get() = _properties

    init {
        getTvShowsList()
    }

    private fun getTvShowsList() {

        Api.retrofitService.getLiveData().enqueue(object : retrofit2.Callback<TvShowsData> {
            override fun onFailure(call: Call<TvShowsData>, t: Throwable) {
                d("failed",t.toString())
                getTvShowsList()
            }

            override fun onResponse(call: Call<TvShowsData>, response: Response<TvShowsData>) {
                _properties.value = response.body()
            }
        }
        )
    }


}