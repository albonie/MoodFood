package com.example.moodfood.chrapka

import android.os.Parcel
import android.os.Parcelable

class SkladnikArray(private var nazwa: String?, var checked: Boolean) : Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    )

    @JvmName("getNazwa1")
    fun getNazwa(): String? {
        return nazwa
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nazwa)
        parcel.writeByte(if (checked) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SkladnikArray> {
        override fun createFromParcel(parcel: Parcel): SkladnikArray {
            return SkladnikArray(parcel)
        }

        override fun newArray(size: Int): Array<SkladnikArray?> {
            return arrayOfNulls(size)
        }
    }

}