package com.example.mvvmchallenge.network

import com.example.mvvmchallenge.model.RandomCurrencyResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
//https://www.googleapis.com/books/v1/volumes?q=Robert%20C.%20Martin
    //https://api.coincap.io/v2/rates

    @GET("v2/rates")
    suspend fun getRandomCurrency(
        @Query("q") q : String
    ): Response<RandomCurrencyResponse>

    companion object{
        var retrofit : Retrofit? = null
        fun getRetrofit() : ApiService{
            if(retrofit == null)
            {
                retrofit = Retrofit.Builder()
                    .baseUrl("https://api.coincap.io/v2/rates")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create(ApiService::class.java)
        }
    }
}