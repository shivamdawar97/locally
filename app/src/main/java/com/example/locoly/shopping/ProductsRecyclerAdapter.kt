package com.example.locoly.shopping

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.locoly.customView.ItemView
import com.example.locoly.globalModels.ItemModel

class ProductsRecyclerAdapter(private val context: Context,private val products:ArrayList<ItemModel>)
    : RecyclerView.Adapter<ProductsRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ViewHolder {
            val view = ItemView(context)
            return ViewHolder(view)
    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(products[position])
    }

    inner class ViewHolder(private val mView: View): RecyclerView.ViewHolder(mView) {
        fun setData(model: ItemModel) = (mView as ItemView).setItemDetails(model)
    }

}