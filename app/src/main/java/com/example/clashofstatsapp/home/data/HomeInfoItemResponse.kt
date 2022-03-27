package com.example.clashofstatsapp.home.data

import com.google.gson.annotations.SerializedName

data class HomeInfoItemResponse(
    @SerializedName("id") val id: Int?,
    @SerializedName("text") val text: String?,
)
