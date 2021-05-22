package com.example.vegetable_only

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.vegetable_only.models.ProductDetailsModel

class ProductDetails : AppCompatActivity() {

    var productData : ProductDetailsModel?  = null;
    var detailHeaderTextView : TextView ? = null;
    var productImage: ImageView ?= null
    var productDescView : TextView  ?= null
    var productNameView: TextView  ?= null
    var productPriceView : TextView  ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);


        productData =
            intent.getSerializableExtra("productDetails") as ProductDetailsModel

        detailHeaderTextView = findViewById(R.id.productDetailHeader)
        productImage = findViewById(R.id.productDetailImage)
        productDescView = findViewById(R.id.prodDesc)
        productNameView = findViewById(R.id.productName)
        productPriceView = findViewById(R.id.prodPrice)


        setDataToView()
    }

    private fun setDataToView(){
        detailHeaderTextView?.setText(productData!!.name)
        productImage?.setImageResource(productData!!.imageUrl)
        productNameView?.setText(productData!!.name)
        productPriceView?.setText(productData!!.price.toString())
        productDescView?.setText(productData!!.desc)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}