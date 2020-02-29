package com.example.locoly.shopping

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.locoly.R
import com.example.locoly.globalModels.ItemModel
import com.example.locoly.shopping.FilterView.FilterItem
import com.example.locoly.shopping.FilterView.FilterItemType
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {

    private val filterView by lazy { filter_view }
    private lateinit var productsRecyclerAdapter: ProductsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        header_text.text = intent.getStringExtra("header")

        filter_btn.setOnClickListener { showFilter() }
        filterView.findViewById<TextView>(R.id.close_btn).setOnClickListener { hideFilter() }
        filterView.findViewById<TextView>(R.id.apply_btn).setOnClickListener { hideFilter() }
        setFilterData()

        products_recycler.layoutManager = GridLayoutManager(this,2)
        setProductsRecyclerAdapterData()
    }

    private fun setProductsRecyclerAdapterData() {
        productsRecyclerAdapter = ProductsRecyclerAdapter(this, arrayListOf(
            ItemModel(0,0,"Louis Philippe",
                "Men Slim Fit Suit ",
                "https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/10857546/2019/11/13/de9b442f-e9c3-41c0-9adf-b025637980841573634518292-Louis-Philippe-Men-Suits-5501573634515561-1.jpg",769,1099,30),
            ItemModel(1,2,"Louis Philippe",
                "Men Slim Single-Breasted Suit ",
                "https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/9642981/2019/6/7/7366f428-cfb6-4271-b006-fa4fcb833b911559892294930-Louis-Philippe-Men-Maroon--Navy-Self-Design-Slim-Fit-Single--1.jpg",659,1099,40),
            ItemModel(1,2,"Louis Philippe",
                "Men Leather Formal Slip-Ons ",
                "https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/11388674/2020/2/14/2738fd23-9789-451f-8de6-1aa2235d5f061581668711776-Louis-Philippe-Men-Coffee-Brown-Solid-Leather-Formal-Slip-On-1.jpg",449,509,10),
            ItemModel(1,2,"Louis Philippe",
                "Men Compfy Tapared Jeans ",
                "https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/11027832/2019/12/24/7cf2c188-6e14-419a-9227-96a3a273c1f31577169665238-Louis-Philippe-Jeans-Men-Charcoal-Grey-Comfy-Tapered-Fit-Low-1.jpg",769,1099,30),
            ItemModel(0,0,"Louis Philippe",
                "Men Slim Fit Suit ",
                "https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/10857546/2019/11/13/de9b442f-e9c3-41c0-9adf-b025637980841573634518292-Louis-Philippe-Men-Suits-5501573634515561-1.jpg",769,1099,30),
            ItemModel(1,2,"Louis Philippe",
                "Men Slim Single-Breasted Suit ",
                "https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/9642981/2019/6/7/7366f428-cfb6-4271-b006-fa4fcb833b911559892294930-Louis-Philippe-Men-Maroon--Navy-Self-Design-Slim-Fit-Single--1.jpg",659,1099,40),
            ItemModel(1,2,"Louis Philippe",
                "Men Leather Formal Slip-Ons ",
                "https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/11388674/2020/2/14/2738fd23-9789-451f-8de6-1aa2235d5f061581668711776-Louis-Philippe-Men-Coffee-Brown-Solid-Leather-Formal-Slip-On-1.jpg",449,509,10),
            ItemModel(1,2,"Louis Philippe",
                "Men Compfy Tapared Jeans ",
                "https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/11027832/2019/12/24/7cf2c188-6e14-419a-9227-96a3a273c1f31577169665238-Louis-Philippe-Jeans-Men-Charcoal-Grey-Comfy-Tapered-Fit-Low-1.jpg",769,1099,30),
            ItemModel(0,0,"Louis Philippe",
                "Men Slim Fit Suit ",
                "https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/10857546/2019/11/13/de9b442f-e9c3-41c0-9adf-b025637980841573634518292-Louis-Philippe-Men-Suits-5501573634515561-1.jpg",769,1099,30),
            ItemModel(1,2,"Louis Philippe",
                "Men Slim Single-Breasted Suit ",
                "https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/9642981/2019/6/7/7366f428-cfb6-4271-b006-fa4fcb833b911559892294930-Louis-Philippe-Men-Maroon--Navy-Self-Design-Slim-Fit-Single--1.jpg",659,1099,40),
            ItemModel(1,2,"Louis Philippe",
                "Men Leather Formal Slip-Ons ",
                "https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/11388674/2020/2/14/2738fd23-9789-451f-8de6-1aa2235d5f061581668711776-Louis-Philippe-Men-Coffee-Brown-Solid-Leather-Formal-Slip-On-1.jpg",449,509,10),
            ItemModel(1,2,"Louis Philippe",
                "Men Compfy Tapared Jeans ",
                "https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/11027832/2019/12/24/7cf2c188-6e14-419a-9227-96a3a273c1f31577169665238-Louis-Philippe-Jeans-Men-Charcoal-Grey-Comfy-Tapered-Fit-Low-1.jpg",769,1099,30),
            ItemModel(0,0,"Louis Philippe",
                "Men Slim Fit Suit ",
                "https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/10857546/2019/11/13/de9b442f-e9c3-41c0-9adf-b025637980841573634518292-Louis-Philippe-Men-Suits-5501573634515561-1.jpg",769,1099,30),
            ItemModel(1,2,"Louis Philippe",
                "Men Slim Single-Breasted Suit ",
                "https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/9642981/2019/6/7/7366f428-cfb6-4271-b006-fa4fcb833b911559892294930-Louis-Philippe-Men-Maroon--Navy-Self-Design-Slim-Fit-Single--1.jpg",659,1099,40),
            ItemModel(1,2,"Louis Philippe",
                "Men Leather Formal Slip-Ons ",
                "https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/11388674/2020/2/14/2738fd23-9789-451f-8de6-1aa2235d5f061581668711776-Louis-Philippe-Men-Coffee-Brown-Solid-Leather-Formal-Slip-On-1.jpg",449,509,10),
            ItemModel(1,2,"Louis Philippe",
                "Men Compfy Tapared Jeans ",
                "https://assets.myntassets.com/f_webp,dpr_1.0,q_60,w_210,c_limit,fl_progressive/assets/images/11027832/2019/12/24/7cf2c188-6e14-419a-9227-96a3a273c1f31577169665238-Louis-Philippe-Jeans-Men-Charcoal-Grey-Comfy-Tapered-Fit-Low-1.jpg",769,1099,30)
        ))
        products_recycler.adapter = productsRecyclerAdapter
    }

    private fun hideFilter() {
        filter_frame.visibility = INVISIBLE
    }

    private fun showFilter() {
        filter_frame.visibility = VISIBLE
    }

    private fun setFilterData() {

        filterView.setCategoryData(arrayListOf(
            FilterItem("T-Shirt",FilterItemType.CATEGORY),
            FilterItem("Shirts",FilterItemType.CATEGORY),
            FilterItem("Waistcoats",FilterItemType.CATEGORY),
            FilterItem("Sweatshirts",FilterItemType.CATEGORY),
            FilterItem("Jeans",FilterItemType.CATEGORY),
            FilterItem("Pants an Trousers",FilterItemType.CATEGORY),
            FilterItem("Formal",FilterItemType.CATEGORY),
            FilterItem("Everyday",FilterItemType.CATEGORY),
            FilterItem("Festive",FilterItemType.CATEGORY),
            FilterItem("Ethenic",FilterItemType.CATEGORY)
        ))

        filterView.setColorData(arrayListOf(
            FilterItem("Red",FilterItemType.COLOR),
            FilterItem("Black",FilterItemType.COLOR),
            FilterItem("Blue",FilterItemType.COLOR),
            FilterItem("Green",FilterItemType.COLOR),
            FilterItem("White",FilterItemType.COLOR)
        ))

        filterView.setSizeData(arrayListOf(
            FilterItem("M",FilterItemType.SIZES),
            FilterItem("L",FilterItemType.SIZES),
            FilterItem("Xl",FilterItemType.SIZES),
            FilterItem("XXl",FilterItemType.SIZES),
            FilterItem("XXXL",FilterItemType.SIZES)
        ))

        filterView.setDiscountData(arrayListOf(
            FilterItem("Min 20%",FilterItemType.DISCOUNT),
            FilterItem("Min 30%",FilterItemType.DISCOUNT),
            FilterItem("Min 50%",FilterItemType.DISCOUNT),
            FilterItem("Min 60%",FilterItemType.DISCOUNT)
        ))
        filterView.setGeneralData(arrayListOf(
            FilterItem("Male",FilterItemType.GENDER),
            FilterItem("Female",FilterItemType.GENDER),
            FilterItem("Kids",FilterItemType.GENDER)
        ))
    }
}
