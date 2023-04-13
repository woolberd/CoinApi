package com.example.coinapi.data.remote

import com.example.coinapi.models.RatesItem
import com.example.coinapi.models.Response
import retrofit2.http.GET

interface CoinApiService {

    @GET("v1/exchangerate/BTC?apikey=FC369988-165B-4356-BEA9-E64946000AE3")
    suspend fun fetchCoin(): Response<RatesItem>
}