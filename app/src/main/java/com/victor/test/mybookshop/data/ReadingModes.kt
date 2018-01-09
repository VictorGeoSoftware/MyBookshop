package com.victor.test.mybookshop.data

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */
data class ReadingModes(val text:Boolean, val image:Boolean): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readByte() != 0.toByte(),
            parcel.readByte() != 0.toByte()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (text) 1 else 0)
        parcel.writeByte(if (image) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ReadingModes> {
        override fun createFromParcel(parcel: Parcel): ReadingModes {
            return ReadingModes(parcel)
        }

        override fun newArray(size: Int): Array<ReadingModes?> {
            return arrayOfNulls(size)
        }
    }
}