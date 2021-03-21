package com.example.electronics.frameworks.views.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.electronics.business.models.ApiResponse
import com.example.electronics.business.models.Products
import com.example.electronics.business.requests.ApiClient
import com.example.electronics.business.requests.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeRepository(val api: ApiService = ApiClient.apiService) {

    private val _products = MutableLiveData<ApiResponse>()
    val products : LiveData<ApiResponse> get() = _products

    fun getproduct(){
        api.doGetProducts().enqueue(object : Callback<ApiResponse>{
            override fun onResponse(
                call: Call<ApiResponse>,
                response: Response<ApiResponse>
            ) {
                _products.value = response.body()
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                val y = t
            }

        })
    }

}