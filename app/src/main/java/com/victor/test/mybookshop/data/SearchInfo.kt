package com.victor.test.mybookshop.data

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlin.String

/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class SearchInfo(val textSnippet: String) : Parcelable