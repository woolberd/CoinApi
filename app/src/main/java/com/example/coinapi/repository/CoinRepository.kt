package com.example.coinapi.repository

import com.example.coinapi.data.remote.CoinApiService
import com.example.coinapi.models.RatesItem
import com.example.coinapi.models.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoinRepository @Inject constructor(
    private val coinApiService: CoinApiService) {

     fun fetchCoin(): Flow<Response<RatesItem>> = flow {
         val coinFetch = coinApiService.fetchCoin()
         emit(coinFetch)
     }
}


