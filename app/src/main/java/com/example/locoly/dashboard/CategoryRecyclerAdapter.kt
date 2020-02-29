package com.example.locoly.dashboard

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.locoly.R

class CategoryRecyclerAdapter(val context: Context) : RecyclerView.Adapter<CategoryRecyclerAdapter.ViewHolder>() {

    private val colors = arrayOf("#3498db","#9b59b6","#2c3e50","#e67e22","#f1c40f","#16a085")
    private val categories = arrayOf("New Arrivals","Men","Women","Purses","Shoes","On Sale")
    private lateinit var onCategorySelected : (Int)->Unit
    companion object {
        val NEW_ARRIVALS=0
        val MEN=1
        val WOMEN=2
        val PURSES=3
        val SHOES=4
        val ON_SALE=5
    }

    fun setOnCategorySelected(listener:(Int)->Unit){
        onCategorySelected = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.category_card,parent,false))

    override fun getItemCount() = 6

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setCategory(position)
    }

    inner class ViewHolder(mview: View) : RecyclerView.ViewHolder(mview) {
        val categoryName = mview.findViewById<TextView>(R.id.category_name)
        fun setCategory(pos:Int){
            categoryName.text = categories[pos]
            categoryName.background = ColorDrawable(Color.parseColor(colors[pos]))
            categoryName.setOnClickListener {
                onCategorySelected.invoke(pos)
            }
        }
    }

}