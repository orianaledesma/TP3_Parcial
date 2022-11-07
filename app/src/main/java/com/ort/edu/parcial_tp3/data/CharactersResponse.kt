package com.ort.edu.parcial_tp3.data

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @field:SerializedName("result") val result: List<Character?>?,
)
