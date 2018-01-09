package com.victor.test.mybookshop.data

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */
data class IndustryIdentifier(val type:String, val identifier:String): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(identifier)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IndustryIdentifier> {
        override fun createFromParcel(parcel: Parcel): IndustryIdentifier {
            return IndustryIdentifier(parcel)
        }

        override fun newArray(size: Int): Array<IndustryIdentifier?> {
            return arrayOfNulls(size)
        }
    }
}