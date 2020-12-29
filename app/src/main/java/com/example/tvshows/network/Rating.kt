package com.example.tvshows.network


import com.google.gson.annotations.SerializedName



data class Rating(
    @SerializedName("average")
    val average: Double
)