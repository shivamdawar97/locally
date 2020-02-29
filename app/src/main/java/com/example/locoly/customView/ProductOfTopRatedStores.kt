package com.example.locoly.customView

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.core.view.marginBottom
import com.example.locoly.R
import com.example.locoly.globalModels.ItemModel

class ProductOfTopRatedStores : LinearLayout {

    private lateinit var gridLayout: GridLayout

    constructor(context: Context):super(context){inflateLayout(context)}
    constructor(context: Context,attributeSet: AttributeSet):super(context,attributeSet){inflateLayout(context)}

    private fun inflateLayout(context: Context) {

        inflate(context, R.layout.product_top_stores,this)
        gridLayout = findViewById(R.id.items_grid)

    }

    fun addItems(items: ArrayList<ItemModel>){
        items.forEach {
            val itemView = ItemView(context)
            itemView.setItemDetails(it)
            itemView.gravity = Gravity.CENTER
            gridLayout.addView(itemView)
        }

    }

}