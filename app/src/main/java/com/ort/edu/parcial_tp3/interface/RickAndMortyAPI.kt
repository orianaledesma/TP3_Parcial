package com.ort.edu.parcial_tp3.`interface`

import com.ort.edu.parcial_tp3.data.Character
import com.ort.edu.parcial_tp3.data.CharactersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyAPI {
    @GET("api/character")
    fun getListCharacters(): Call<CharactersResponse?>?

    @GET("api/character/{characterId}")
    fun getCharacterById(@Path("characterId") characterId: Int ):Call<Character?>?

    @GET("api/character/{charactersIds}")
    fun getFavoriteCharacters(@Path("charactersIds") charactersIds:String):Call<List<Character?>?>?


}