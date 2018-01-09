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
data class VolumeInfo(val title:String,
                      val authors:ArrayList<String>?,
                      val publisher:String,
                      val publishedDate:String?,
                      val description:String?,
                      val industryIdentifiers:ArrayList<IndustryIdentifier>?,
                      val readingModes:ReadingModes?,
                      val pageCount:Int,
                      val printType:String,
                      val categories:ArrayList<String>?,
                      val maturityRating:String,
                      val allowAnonLogging:Boolean,
                      val contentVersion:String,
                      val panelizationSummary:PanelizationSummary?,
                      val imageLinks:ImageLinks,
                      val language:String,
                      val previewLink:String,
                      val infoLink:String,
                      val canonicalVolumeLink:String) : Parcelable