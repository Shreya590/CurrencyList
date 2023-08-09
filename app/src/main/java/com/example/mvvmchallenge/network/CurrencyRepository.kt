package com.example.mvvmchallenge.network

import retrofit2.Response
import com.example.mvvmchallenge.model.RandomCurrencyResponse

interface CurrencyRepository {
    suspend fun getRandomCurrency(q: String): Response<RandomCurrencyResponse>
}
class CurrencyRepositoryImpl(private val service: ApiService):CurrencyRepository {
    override suspend fun getRandomCurrency(q: String): Response<RandomCurrencyResponse> = service.getRandomCurrency(q)
}