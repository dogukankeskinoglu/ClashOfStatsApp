package com.example.clashofstatsapp.home.data

import com.google.gson.annotations.SerializedName

data class HomeInfoResponse(
    @SerializedName("items") val levels: List<HomeInfoItemResponse?>?,
)
