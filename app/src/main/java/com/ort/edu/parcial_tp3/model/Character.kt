package com.ort.edu.parcial_tp3.model

import android.os.Parcel
import android.os.Parcelable

data class Character(val name: String?, val imageLink: String?, val status: String?, val origin: String?, val especie: String?) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()

    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(imageLink)
        parcel.writeString(status)
        parcel.writeString(origin)
        parcel.writeString(especie)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Character> {
        override fun createFromParcel(parcel: Parcel): Character {
            return Character(parcel)
        }

        override fun newArray(size: Int): Array<Character?> {
            return arrayOfNulls(size)
        }
    }

}