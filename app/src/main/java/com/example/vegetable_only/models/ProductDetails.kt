package com.example.vegetable_only.models

import com.example.vegetable_only.R
import java.io.Serializable

class ProductDetailsModel(
    val id: Int,
    val name: String,
    val desc: String,
    val price: Int,
    val imageUrl: Int,
    var category: Category = Category(1 , R.drawable.organic)) : Serializable {

}