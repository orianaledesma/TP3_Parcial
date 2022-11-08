package com.ort.edu.parcial_tp3.data

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @field:SerializedName("results") val results: ArrayList<CharacterData>,
)