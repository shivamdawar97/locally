package com.example.locoly.customView

import android.animation.Animator
import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.ActionMode
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.example.locoly.R
import com.example.locoly.globalModels.ItemModel

class ItemView : LinearLayout {

    private lateinit var itemImage: ImageView
    private lateinit var itemName: TextView
    private lateinit var itemPrice: TextView
    private lateinit var itemOldPrice: TextView
    private lateinit var itemDiscount: TextView
    private lateinit var itemDiscription: TextView
    private lateinit var favView: AppCompatImageView
    private var isFav = false

    constructor(context: Context) : super(context) {inflateLayout(context)}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {inflateLayout(context)}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {inflateLayout(context)}

    private fun inflateLayout(context: Context) {
        inflate(context, R.layout.item_card,this)


        val metrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(metrics)
        val width = metrics.widthPixels
        layoutParams = LayoutParams(width/2,LayoutParams.WRAP_CONTENT)

        itemImage = findViewById(R.id.item_image)
        itemName = findViewById(R.id.item_name)
        itemPrice = findViewById(R.id.item_price)
        itemOldPrice = findViewById(R.id.item_price_cutThrough)
        itemDiscount = findViewById(R.id.item_disc)
        favView = findViewById(R.id.fav_view)

        itemDiscription = findViewById(R.id.item_desc)

        favView.setOnClickListener {
            isFav = if(isFav){
                favView.setImageResource(R.drawable.ic_favorite_empty)
                false
            } else {
                favView.setImageResource(R.drawable.ic_favorite_full)
                true
            }
        }

    }

    fun setItemDetails(itemModel: ItemModel)= with(itemModel){
        setItemName(name); setItemImage(image)
        setItemPrice(price.toString()); setItemOldPrice(oldPrice.toString())
        setItemDiscount(discount.toString()) ; setItemDiscription(desc)
    }

    private fun setItemName(name:String){
        itemName.text = name
    }

    private fun setItemImage(image: String){
        Glide.with(itemImage).load(image).into(itemImage)
    }

    private fun setItemPrice(price: String){
        itemPrice.text = "₹ $price"
    }

    private fun setItemDiscription(desc: String){
        itemDiscription.text = desc
    }

    private fun setItemOldPrice(oldPrice: String){
        itemOldPrice.visibility = View.VISIBLE
        itemOldPrice.text = "₹ $oldPrice"
    }

    private fun setItemDiscount(discount: String){
        itemDiscount.visibility = View.VISIBLE
        itemDiscount.text = "($discount%)"
    }


    private fun getAnimatorListener() = object : Animator.AnimatorListener{
        override fun onAnimationRepeat(animation: Animator?) {}
        override fun onAnimationEnd(animation: Animator?) {
            favView.setImageResource(R.drawable.ic_favorite_full)
            //favAnim.visibility = View.GONE
            favView.visibility = View.VISIBLE
        }
        override fun onAnimationCancel(animation: Animator?) {}
        override fun onAnimationStart(animation: Animator?){}

    }

}