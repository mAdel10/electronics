package com.example.electronics.business.requests

import com.example.electronics.business.models.ApiResponse
import com.example.electronics.business.models.Products
import com.example.electronics.business.utils.Constants
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.HOME)
    fun doGetProducts() : Call<ApiResponse>
}