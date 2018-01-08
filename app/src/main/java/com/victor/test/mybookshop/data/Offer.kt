package com.victor.test.mybookshop.data

/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */
data class Offer (val finskyOfferType:Int,
                  val listPrice:PriceInMicros,
                  val retailPrice:PriceInMicros,
                  val giftable:Boolean)