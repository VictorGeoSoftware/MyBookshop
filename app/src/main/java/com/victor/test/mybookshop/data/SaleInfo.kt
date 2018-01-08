package com.victor.test.mybookshop.data

/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */
data class SaleInfo(val country: String,
                    val saleability: String,
                    val isEbook: Boolean,
                    val listPrice: Price,
                    val retailPrice: Price,
                    val buyLink: String,
                    val offers: ArrayList<Offer>)