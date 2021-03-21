package com.example.electronics.frameworks.views.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.electronics.R
import com.example.electronics.business.models.Products
import com.example.electronics.databinding.ItemProductListBinding

class HomeAdapter(private var products: List<Products>) : RecyclerView.Adapter<HomeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        val itemProductListBinding: ItemProductListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_product_list, parent, false
        )

        return HomeHolder(itemProductListBinding)
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        holder.bind(products[position])

    }

    override fun getItemCount(): Int {
        return products.size
    }


    fun setProducts(product: List<Products>) {
        products = product
        notifyDataSetChanged()
    }
}