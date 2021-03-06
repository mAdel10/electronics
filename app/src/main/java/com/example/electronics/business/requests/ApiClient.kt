package com.example.electronics.business.requests

import com.example.electronics.business.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    val retrofitBuilder : Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiService : ApiService by lazy {
        retrofitBuilder
            .build()
            .create(ApiService::class.java)
    }
}