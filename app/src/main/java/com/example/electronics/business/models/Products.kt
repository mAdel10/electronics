package com.example.electronics.business.models

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.electronics.R
import com.google.gson.annotations.SerializedName
import com.squareup.picasso.Picasso
import java.io.Serializable

class Products(
    @SerializedName("_id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("price")
    val price: Double,

    @SerializedName("old_price")
    val old_price: Double,


    @SerializedName("discount")
    val discount: Int,

    @SerializedName("description")
    val description: String? = null
) : Serializable

@BindingAdapter("loadImage")
fun imageUrl(view: ImageView?, url: String?) {
    Picasso.get().load(url).placeholder(R.drawable.ic_launcher_foreground).into(view)

}