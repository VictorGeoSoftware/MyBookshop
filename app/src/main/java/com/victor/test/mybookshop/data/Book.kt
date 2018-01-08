package com.victor.test.mybookshop.data

/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */
data class Book(val kind:String,
                val id:String,
                val etag:String,
                val selfLink:String,
                val volumeInfo: VolumeInfo,
                val saleInfo: SaleInfo,
                val accessInfo: AccessInfo,
                val searchInfo: SearchInfo)