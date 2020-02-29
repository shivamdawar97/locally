package com.example.locoly.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.locoly.R
import com.example.locoly.customView.AutoScrollViewPager
import com.example.locoly.customView.ProductOfTopRatedStores
import com.example.locoly.shopping.ShoppingActivity
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    private val shopsPager by lazy { findViewById<AutoScrollViewPager>(R.id.shops_pager) }
    private val productsTopStores by lazy { findViewById<ProductOfTopRatedStores>(R.id.products_top_stores) }
    private val categoryAdapter by lazy { CategoryRecyclerAdapter(this) }
    private val dashboardRepositiry = DashboardRepositiry()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        category_recycler.adapter = categoryAdapter
        category_recycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        val dotsIndicator = findViewById<WormDotsIndicator>(R.id.view_pager_dots)
        dotsIndicator.setViewPager(shopsPager)
        shopsPager.setPagerAdapter(ViewPagerAdapter(this, dashboardRepositiry.getViewPagerImages()))

        productsTopStores.addItems(dashboardRepositiry.getProductsTopRated())

        setCategorylistner()

    }

    private fun setCategorylistner() = with(CategoryRecyclerAdapter) {
        categoryAdapter.setOnCategorySelected { category ->
            val intent = Intent(this@DashboardActivity,ShoppingActivity::class.java)
            when(category){
                NEW_ARRIVALS -> intent.putExtra("header","New Arrivals")
                MEN -> intent.putExtra("header","Men")
                WOMEN -> intent.putExtra("header","Women")
                PURSES -> intent.putExtra("header","Purses")
                SHOES -> intent.putExtra("header","Shoes")
                ON_SALE -> intent.putExtra("header","onSale")
            }
            startActivity(intent)
        }
    }






}
