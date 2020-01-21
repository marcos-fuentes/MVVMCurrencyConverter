package com.example.presentation.products.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.R
import com.example.presentation.model.ProductUIModel
import com.example.presentation.products.adapter.ProductsAdapter.ProductViewHolder
import kotlinx.android.synthetic.main.product_item.view.*
import java.util.*

class ProductsAdapter(
    var context: Context?,
    var products: ArrayList<ProductUIModel>,
    val clickListener: (ProductUIModel) -> Unit
) : RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position], clickListener)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner class ProductViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {


        fun bind(productUIModel: ProductUIModel, clickListener: (ProductUIModel) -> Unit) {
            itemView.productName.text = productUIModel.sku
            itemView.productAmount.text = productUIModel.amount.toString()
            itemView.setOnClickListener { clickListener(productUIModel) }
        }
    }

}