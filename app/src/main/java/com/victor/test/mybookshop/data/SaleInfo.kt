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
class SaleInfo(val country: String,
                    val saleability: String,
                    val isEbook: Boolean,
                    val listPrice: Price?,
                    val retailPrice: Price?,
                    val buyLink: String?,
                    val offers: ArrayList<Offer>?) : Parcelable