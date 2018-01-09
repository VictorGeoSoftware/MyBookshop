package com.victor.test.mybookshop.data

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import io.reactivex.annotations.Nullable
import kotlinx.android.parcel.Parcelize

/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */

@SuppressLint("ParcelCreator")
@Parcelize
class Offer (private val finskyOfferType:Int,
             private val listPrice:PriceInMicros,
             private val retailPrice:PriceInMicros,
             private val giftable:Boolean) : Parcelable