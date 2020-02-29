package com.example.locoly.customView

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager


class AutoScrollViewPager: ViewPager {

    private val DEFAULT_INTERVAL = 3000.toLong()
    private var totalPages = 0
    private val scrollHandler by lazy { Handler() }
    private val run = Runnable {
        val next = if(currentItem+1 == totalPages) 0 else currentItem+1
        setCurrentItem(next,true)
        scrollToNext()
    }

    constructor(context: Context): super(context)
    constructor(context: Context,attributes: AttributeSet):super(context,attributes)

    fun setPagerAdapter(adapter : PagerAdapter){
        setAdapter(adapter)
        totalPages = adapter.count
        scrollToNext()
        setChangeListener()
    }

    private fun scrollToNext() {
      scrollHandler.postDelayed(run,DEFAULT_INTERVAL)
    }

    private fun reInitiateTimer(){
       scrollHandler.removeCallbacks(run)
       scrollToNext()
    }

    private fun setChangeListener(){
        addOnPageChangeListener(object : OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int,positionOffset: Float,positionOffsetPixels: Int) {
                reInitiateTimer()
            }
            override fun onPageSelected(position: Int) {}
        })
    }

}