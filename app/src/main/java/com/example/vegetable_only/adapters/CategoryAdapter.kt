package com.example.vegetable_only.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.vegetable_only.MainActivity
import com.example.vegetable_only.ProductList
import com.example.vegetable_only.R
import com.example.vegetable_only.constants.PRODUCT_LIST
import com.example.vegetable_only.models.Category
import com.example.vegetable_only.models.ProductDetailsModel

class CategoryAdapter(private val context : Context, private val dataSet: ArrayList<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView


        init {
            // Define click listener for the ViewHolder's View.
            imageView = view.findViewById(R.id.categoryImage)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.category_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.imageView.setImageResource(dataSet[position].imageUrl);
        viewHolder.imageView.setOnClickListener {
            var productList = arrayListOf<ProductDetailsModel>();
            productList.addAll(PRODUCT_LIST)
            for(item in productList){
                item.category = dataSet[position]
            }
            val intent = Intent(context, ProductList::class.java)
                .apply {
                    putExtra("productList", productList)
                }
            context.startActivity(intent)

        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}