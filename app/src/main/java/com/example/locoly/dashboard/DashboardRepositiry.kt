package com.example.locoly.dashboard

import com.example.locoly.globalModels.ItemModel
import java.util.ArrayList

class DashboardRepositiry {


    fun getViewPagerImages(): Array<String> =
        arrayOf(
            "https://assets.ajio.com/medias/sys_master/images/images/h04/h24/13854424334366/Global-Nav-1.jpg",
            "https://assets.ajio.com/medias/sys_master/images/images/hbb/h97/15585389477918/20022020-D-MHP-AJIOOWN-tile-TshirtsAndShirts.jpg",
            "https://assets.ajio.com/medias/sys_master/images/images/h00/he4/15585389871134/20022020-D-MHP-AJIOOWN-tile-JeansAndTrousers.jpg",
            "https://cdn2.vectorstock.com/i/1000x1000/25/01/denim-clothing-sale-poster-vector-22642501.jpg",
            "https://sc01.alicdn.com/kf/HTB10phmcHSYBuNjSspiq6xNzpXa4/220725822/HTB10phmcHSYBuNjSspiq6xNzpXa4.jpg",
            "https://thumbs.dreamstime.com/z/women-clothing-store-fashion-clothes-shop-interior-modern-retail-mannequins-57579143.jpg"
        )

    fun getProductsTopRated(): ArrayList<ItemModel> {
        return arrayListOf(
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
        )
    }

}