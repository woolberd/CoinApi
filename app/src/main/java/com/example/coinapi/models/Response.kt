package com.example.coinapi.models

import com.google.gson.annotations.SerializedName

data class Response<T>(
    @SerializedName("asset_id_base")
    val assetIdBase: String = "",
    @SerializedName("rates")
    val rates: List<T>?
)