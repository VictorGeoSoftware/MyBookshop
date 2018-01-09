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
data class AccessInfo (
        val country:String,
        val viewability:String,
        val embeddable:Boolean,
        val publicDomain:Boolean,
        val textToSpeechPermission:String,
        val epub:FormatPubAccess?,
        val pdf:FormatPubAccess?,
        val webReaderLink:String,
        val accessViewStatus:String,
        val quoteSharingAllowed:Boolean) : Parcelable