package com.example.locoly.globalModels

data class ItemModel(
    val id: Int,
    val shopId: Int,
    val name: String,
    val desc: String,
    val image: String,
    val price: Int,
    var oldPrice: Int = 0,
    var discount: Int = 0
)