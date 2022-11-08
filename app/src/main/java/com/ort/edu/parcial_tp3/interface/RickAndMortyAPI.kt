package com.ort.edu.parcial_tp3.`interface`

import com.ort.edu.parcial_tp3.data.CharacterData
import com.ort.edu.parcial_tp3.data.CharactersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyAPI {
    @GET(".")
    fun getListCharacters(): Call<CharactersResponse?>?

    @GET("{characterId}")
    fun getCharacterById(@Path("characterId") characterId: Int ):Call<CharacterData?>?

    @GET("{charactersIds}")
    fun getFavoriteCharacters(@Path("charactersIds") charactersIds:String):Call<List<CharacterData?>?>?


}