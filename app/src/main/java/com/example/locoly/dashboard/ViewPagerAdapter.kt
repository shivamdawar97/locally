package com.example.locoly.dashboard

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide

class ViewPagerAdapter(private val context: Context, private val images: Array<String>) : PagerAdapter() {


    override fun isViewFromObject(view: View, obj : Any): Boolean {
        return view == obj as ImageView
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val image = ImageView(context)
        image.scaleType = ImageView.ScaleType.FIT_XY
        Glide.with(context).load(images[position]).into(image)
        container.addView(image)
        return image
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ImageView)
    }



}