package com.example.electronics.frameworks.views.home

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val repository: HomeRepository = HomeRepository()

    init {
        getProducts()
    }

    private fun getProducts() {
        repository.getproduct()
    }

    fun getProductResponse() = repository.products

}