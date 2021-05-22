package com.example.vegetable_only

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vegetable_only.adapters.CategoryAdapter
import com.example.vegetable_only.models.Category
import java.util.ArrayList

class mainDashboard : AppCompatActivity() {

    var cartImageView : ImageView? = null
    var settingsImageView: ImageView? = null
    var searchEditText: EditText? = null
    var linearLayoutManager: LinearLayoutManager?= null
    var categoryRecyclerView : RecyclerView?= null
    var categoryList : ArrayList<Category>?= null
    var seeMoreCategoryTextView : TextView? = null
    lateinit var categoryViewAdaper : CategoryAdapter;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_dashboard)
        cartImageView = findViewById(R.id.cartImageView)
        settingsImageView = findViewById(R.id.settingsImageView)
        searchEditText = findViewById(R.id.searchEditText)
        seeMoreCategoryTextView = findViewById(R.id.seeMoreCategoryTextView)
        categoryRecyclerView = findViewById(R.id.categoryRecycler)
        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        categoryRecyclerView!!.layoutManager = linearLayoutManager

//        imageView.setOnClickListener()
        setUpCategoryRecycler()

        seeMoreCategoryTextView!!.setOnClickListener  {
            val intent = Intent(this, AllCategory::class.java)
//                    .apply {
////                    putExtra(EXTRA_MESSAGE, message)
//                }
            startActivity(intent)
        }

        settingsImageView!!.setOnClickListener  {
            val intent = Intent(this, Settings::class.java)
//                    .apply {
////                    putExtra(EXTRA_MESSAGE, message)
//                }
            startActivity(intent)
        }

        cartImageView!!.setOnClickListener  {
            val intent = Intent(this, Cart::class.java)
//                    .apply {
////                    putExtra(EXTRA_MESSAGE, message)
//                }
            startActivity(intent)
        }

    }

    fun setUpCategoryRecycler(){
        categoryList = arrayListOf<Category>()
        categoryList!!.add(Category(1, R.drawable.organic))
        categoryList!!.add(Category(2, R.drawable.organic))
        categoryList!!.add(Category(3, R.drawable.organic))
        categoryList!!.add(Category(4, R.drawable.organic))
        categoryList!!.add(Category(5, R.drawable.organic))


        categoryViewAdaper = CategoryAdapter(this,categoryList!!)

        categoryRecyclerView!!.adapter = categoryViewAdaper



    }



}