package com.example.vegetable_only

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vegetable_only.adapters.AllCategoryAdapter
import com.example.vegetable_only.models.Category
import java.util.*


class AllCategory : AppCompatActivity() {

    var allCategoryRecyclerView : RecyclerView ? = null
    var categoryList : ArrayList<Category>?= null
    var linearLayoutManager: LinearLayoutManager?= null
    lateinit var viewAdapter : AllCategoryAdapter;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_category)

        allCategoryRecyclerView = findViewById(R.id.all_category)
        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        allCategoryRecyclerView!!.layoutManager = linearLayoutManager

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);

        setAllCatergoryRecycler()

    }

    fun setAllCatergoryRecycler(){
        categoryList = arrayListOf<Category>()
        categoryList!!.add(Category(1, R.drawable.organic))
        categoryList!!.add(Category(2, R.drawable.organic))
        categoryList!!.add(Category(3, R.drawable.organic))
        categoryList!!.add(Category(4, R.drawable.organic))
        categoryList!!.add(Category(5, R.drawable.organic))


        viewAdapter = AllCategoryAdapter(this,categoryList!!)

        allCategoryRecyclerView!!.adapter = viewAdapter



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