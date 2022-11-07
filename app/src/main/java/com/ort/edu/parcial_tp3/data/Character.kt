package com.ort.edu.parcial_tp3.data

import com.google.gson.annotations.SerializedName

data class Character(
    @field:SerializedName("id") val id: Int,
    @field:SerializedName("name") val name: String,
    @field:SerializedName("status") val status: String,
    @field:SerializedName("species") val species: String,
    @field:SerializedName("species") val origin: OriginCharacter,
    @field:SerializedName("image") val image: String,
    @field:SerializedName("url") val url: String,
)
