package com.example.advice.model

import android.os.Parcel
import android.os.Parcelable

data class Advice(
    val day: Int,
    val title: String,
    val shortDescription: String,
    val fullDescription: String,
    val imageResId: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(day)
        parcel.writeString(title)
        parcel.writeString(shortDescription)
        parcel.writeString(fullDescription)
        parcel.writeInt(imageResId)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Advice> {
        override fun createFromParcel(parcel: Parcel) = Advice(parcel)
        override fun newArray(size: Int) = arrayOfNulls<Advice?>(size)
    }
}