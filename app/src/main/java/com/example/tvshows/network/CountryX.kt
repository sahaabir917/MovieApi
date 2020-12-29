package com.example.tvshows.network


import com.google.gson.annotations.SerializedName



data class CountryX(
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("timezone")
    val timezone: String
)