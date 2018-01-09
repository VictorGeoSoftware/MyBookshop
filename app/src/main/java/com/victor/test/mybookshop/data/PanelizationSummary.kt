package com.victor.test.mybookshop.data

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by victorpalmacarrasco on 7/1/18.
 * ${APP_NAME}
 */
data class PanelizationSummary(val containsEpubBubbles:Boolean, val containsImageBubbles:Boolean): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readByte() != 0.toByte(),
            parcel.readByte() != 0.toByte()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (containsEpubBubbles) 1 else 0)
        parcel.writeByte(if (containsImageBubbles) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PanelizationSummary> {
        override fun createFromParcel(parcel: Parcel): PanelizationSummary {
            return PanelizationSummary(parcel)
        }

        override fun newArray(size: Int): Array<PanelizationSummary?> {
            return arrayOfNulls(size)
        }
    }
}