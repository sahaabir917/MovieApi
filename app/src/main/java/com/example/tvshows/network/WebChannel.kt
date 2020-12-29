package com.example.tvshows.network


import com.google.gson.annotations.SerializedName



data class WebChannel(
    @SerializedName("country")
    val country: CountryX,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)