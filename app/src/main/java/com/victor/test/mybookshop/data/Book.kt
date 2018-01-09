package com.victor.test.mybookshop.data

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */

@SuppressLint("ParcelCreator")
@Parcelize
class Book(val kind:String,
                val id:String,
                val etag:String,
                val selfLink:String,
                val volumeInfo: VolumeInfo,
                val saleInfo: SaleInfo,
                val accessInfo: AccessInfo,
                val searchInfo: SearchInfo) : Parcelable