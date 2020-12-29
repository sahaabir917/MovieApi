package com.example.tvshows.repositories

import com.example.tvshows.network.Api
import com.example.tvshows.network.TvShowsDataItem



import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tvshows.network.TvShowsData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class LiveDataRepository() {

//    private val response = MutableLiveData<List<TvShowsData>>()
//    private val liveDataResponse = MutableLiveData<List<TvShowsData>>()
//    private var coroutineJob = Job()
//    private val coroutineScope = CoroutineScope(coroutineJob + Dispatchers.Main)
//
//
//
//
//    fun getNetworkService() {
//
//        coroutineScope.launch {
//
//            val getPropertyDeffered = Api.retrofitService.getLiveData()
//
//            try {
//                val property = getPropertyDeffered.await()
//                liveDataResponse.value = property.data
//            } catch (t: Throwable) {
//                Log.d("response", "Failed.............. :" + t.message)
//            }
//        }
//    }
//
//
//
//    val getResponseLiveData: MutableLiveData<List<TvShowsData>>
//        get() = liveDataResponse
//
//    val getResponseForSettingCheck : MutableLiveData<List<TvShowsData>>
//        get() =liveDataResponse

}
