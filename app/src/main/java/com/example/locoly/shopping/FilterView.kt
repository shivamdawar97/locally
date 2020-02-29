package com.example.locoly.shopping

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.locoly.R

class FilterView : LinearLayout {

    private val filterRecycler by lazy { findViewById<RecyclerView>(R.id.filters_recycler) }
    private val genderBtn by lazy { findViewById<TextView>(R.id.gender_filter) }
    private val categoryBtn by lazy { findViewById<TextView>(R.id.category_filter) }
    private val colorBtn by lazy { findViewById<TextView>(R.id.color_filter) }
    private val sizeBtn by lazy { findViewById<TextView>(R.id.size_filter) }
    private val prizeBtn by lazy { findViewById<TextView>(R.id.prize_filter) }
    private val discountBtn by lazy { findViewById<TextView>(R.id.discount_filter) }
    private lateinit var generalAdapter:FilterRecylerAdapter
    private lateinit var categoryAdapter:FilterRecylerAdapter
    private lateinit var colorAdapter:FilterRecylerAdapter
    private lateinit var sizesAdapter:FilterRecylerAdapter
    private lateinit var discountAdapter:FilterRecylerAdapter
    private var currentSelected = -1

    constructor(context: Context) : super(context) {inflateLayout(context)}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {inflateLayout(context)}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {inflateLayout(context)}

    private fun inflateLayout(context: Context) {
        inflate(context, R.layout.filter_view,this)

        filterRecycler.layoutManager = LinearLayoutManager(context)

        genderBtn.visibility = GONE ; categoryBtn.visibility = GONE
        colorBtn.visibility = GONE ; sizeBtn.visibility = GONE
        prizeBtn.visibility = GONE ; discountBtn.visibility = GONE

        genderBtn.setOnClickListener { filterRecycler.adapter = generalAdapter ; setSelection(0)}
        categoryBtn.setOnClickListener { filterRecycler.adapter = categoryAdapter ; setSelection(1) }
        colorBtn.setOnClickListener { filterRecycler.adapter = colorAdapter ; setSelection(2) }
        sizeBtn.setOnClickListener { filterRecycler.adapter = sizesAdapter ; setSelection(3) }
        discountBtn.setOnClickListener { filterRecycler.adapter = discountAdapter ; setSelection(4) }

    }

    @SuppressLint("NewApi")
    private fun setSelection(position: Int){
        when(currentSelected){
            0-> {
                genderBtn.background = ColorDrawable(resources.getColor(android.R.color.white,resources.newTheme()))
                genderBtn.setTextColor(resources.getColor(R.color.textColor,resources.newTheme()))
            }
            1 -> {
                categoryBtn.background = ColorDrawable(resources.getColor(android.R.color.white,resources.newTheme()))
                categoryBtn.setTextColor(resources.getColor(R.color.textColor,resources.newTheme()))
            }
            2 -> {
                colorBtn.background = ColorDrawable(resources.getColor(android.R.color.white,resources.newTheme()))
                colorBtn.setTextColor(resources.getColor(R.color.textColor,resources.newTheme()))
            }
            3 -> {
                sizeBtn.background = ColorDrawable(resources.getColor(android.R.color.white,resources.newTheme()))
                sizeBtn.setTextColor(resources.getColor(R.color.textColor,resources.newTheme()))
            }
            4 -> {
                discountBtn.background = ColorDrawable(resources.getColor(android.R.color.white,resources.newTheme()))
                discountBtn.setTextColor(resources.getColor(R.color.textColor,resources.newTheme()))
            }
        }
        when(position){
            0-> {
                genderBtn.background = ColorDrawable(resources.getColor(R.color.colorPrimary,resources.newTheme()))
                genderBtn.setTextColor(resources.getColor(android.R.color.white,resources.newTheme()))
            }
            1 -> {
                categoryBtn.background = ColorDrawable(resources.getColor(R.color.colorPrimary,resources.newTheme()))
                categoryBtn.setTextColor(resources.getColor(android.R.color.white,resources.newTheme()))
            }
            2 -> {
                colorBtn.background = ColorDrawable(resources.getColor(R.color.colorPrimary,resources.newTheme()))
                colorBtn.setTextColor(resources.getColor(android.R.color.white,resources.newTheme()))
            }
            3 -> {
                sizeBtn.background = ColorDrawable(resources.getColor(R.color.colorPrimary,resources.newTheme()))
                sizeBtn.setTextColor(resources.getColor(android.R.color.white,resources.newTheme()))
            }
            4 -> {
                discountBtn.background = ColorDrawable(resources.getColor(R.color.colorPrimary,resources.newTheme()))
                discountBtn.setTextColor(resources.getColor(android.R.color.white,resources.newTheme()))
            }
        }
        currentSelected = position
    }

    fun setGeneralData(items:ArrayList<FilterItem>){
        genderBtn.visibility = VISIBLE
        generalAdapter = FilterRecylerAdapter(items)
        genderBtn.callOnClick()
    }

    fun setCategoryData(items:ArrayList<FilterItem>){
        categoryBtn.visibility = VISIBLE
        categoryAdapter = FilterRecylerAdapter(items)
        categoryBtn.callOnClick()
    }

    fun setColorData(items:ArrayList<FilterItem>){
        colorBtn.visibility = VISIBLE
        colorAdapter = FilterRecylerAdapter(items)
        colorBtn.callOnClick()
    }

    fun setSizeData(items:ArrayList<FilterItem>){
        sizeBtn.visibility = VISIBLE
        sizesAdapter = FilterRecylerAdapter(items)
        sizeBtn.callOnClick()
    }

    fun setDiscountData(items:ArrayList<FilterItem>){
        discountBtn.visibility = VISIBLE
        discountAdapter = FilterRecylerAdapter(items)
        discountBtn.callOnClick()
    }

    inner class FilterRecylerAdapter(private val items:ArrayList<FilterItem>):
        RecyclerView.Adapter<FilterRecylerAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup,viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.filter_recycler_card,parent,false))
        override fun getItemCount() = items.size
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.itemView.findViewById<TextView>(R.id.text).text = items[position].name
            with(holder.itemView.findViewById<CheckBox>(R.id.checkbox)) {
                isChecked = items[position].isChecked
                setOnCheckedChangeListener { _, isChecked ->
                    items[position].isChecked = isChecked
                }
            }
        }
        inner class ViewHolder(mView: View):RecyclerView.ViewHolder(mView)

    }

    data class FilterItem(val name:String, val type:FilterItemType,var isChecked :Boolean= false)

    enum class FilterItemType{
        GENDER,CATEGORY,COLOR,SIZES,DISCOUNT
    }

}