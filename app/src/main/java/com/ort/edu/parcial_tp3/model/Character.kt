package com.ort.edu.parcial_tp3.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character(val name: String?, val imageLink: String?, val status: String?, val origin: String?, val especie: String?) : Parcelable {

}