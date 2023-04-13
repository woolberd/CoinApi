package com.example.coinapi.models

import com.google.gson.annotations.SerializedName

data class RatesItem(
    @SerializedName("rate")
    val rate: Double,
    @SerializedName("asset_id_quote")
    val assetIdQuote: String,
    @SerializedName("time")
    val time: String
)