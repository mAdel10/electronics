package com.example.electronics.frameworks.views.home

import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.electronics.business.models.Products
import com.example.electronics.databinding.ItemProductListBinding

class HomeHolder(private val binding: ItemProductListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(product: Products) {
        binding.products = product
        binding.productCardView.setOnClickListener {
            Toast.makeText(itemView.context, "${product.name.toString()}", Toast.LENGTH_LONG).show()
        }

    }
}