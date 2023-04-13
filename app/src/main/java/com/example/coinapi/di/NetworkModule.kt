package com.example.coinapi.di

import com.example.coinapi.data.RetrofitClient
import com.example.coinapi.data.remote.CoinApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideCoinApiService(): CoinApiService {
        return retrofitClient.provideCoinApiService()
    }
}