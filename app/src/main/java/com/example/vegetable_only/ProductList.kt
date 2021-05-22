package com.example.vegetable_only

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vegetable_only.adapters.ProductListAdapter
import com.example.vegetable_only.models.ProductDetailsModel

class ProductList : AppCompatActivity() {

    var productListRecyclerView : RecyclerView? = null
    var productList : ArrayList<ProductDetailsModel>?= null
    var linearLayoutManager: LinearLayoutManager?= null
    lateinit var viewAdapter : ProductListAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);


        productList =
            intent.getSerializableExtra("productList") as ArrayList<ProductDetailsModel>
        productListRecyclerView = findViewById(R.id.product_list)
        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        productListRecyclerView!!.layoutManager = linearLayoutManager


        setProductListRecycler()
    }

    fun setProductListRecycler(){

        viewAdapter = ProductListAdapter(this,productList!!)
        productListRecyclerView!!.adapter = viewAdapter

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