package com.example.vegetable_only.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.vegetable_only.ProductDetails
import com.example.vegetable_only.ProductList
import com.example.vegetable_only.R
import com.example.vegetable_only.constants.PRODUCT_LIST
import com.example.vegetable_only.models.ProductDetailsModel


class ProductListAdapter(private val context: Context, private val dataSet: ArrayList<ProductDetailsModel>) :
    RecyclerView.Adapter<ProductListAdapter .ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productImage: ImageView


        init {
            // Define click listener for the ViewHolder's View.
            productImage = view.findViewById(R.id.productImage)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.product_list_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.productImage.setImageResource(dataSet[position].imageUrl);

        viewHolder.productImage.setOnClickListener {
            val intent = Intent(context, ProductDetails::class.java)
                .apply {
                    putExtra("productDetails", dataSet[position])
                }
            context.startActivity(intent)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}