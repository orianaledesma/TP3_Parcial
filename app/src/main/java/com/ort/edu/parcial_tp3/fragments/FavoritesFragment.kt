package com.ort.edu.parcial_tp3.fragments

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ort.edu.parcial_tp3.R
import com.ort.edu.parcial_tp3.UserSession
import com.ort.edu.parcial_tp3.adapter.CharacterAdapter
import com.ort.edu.parcial_tp3.adapter.CharacterFavoriteAdapter
import com.ort.edu.parcial_tp3.api.RickAndMortyService
import com.ort.edu.parcial_tp3.data.CharacterData
import com.ort.edu.parcial_tp3.listener.OnCharacterClickedListener
import com.ort.edu.parcial_tp3.model.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavoritesFragment : Fragment(), OnCharacterClickedListener {
    private lateinit var characterRecyclerView: RecyclerView
    private lateinit var characterList: List<CharacterData>
    private lateinit var title: TextView
    private lateinit var sharedPref: SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharedPref = requireContext().getSharedPreferences("ParcialTP3SharedPreferences", Context.MODE_PRIVATE)
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        characterRecyclerView = view.findViewById(R.id.favorite_recycler_view)
        title = view.findViewById(R.id.text_favorite)

        if (sharedPref.getBoolean("nightMode", true)) {
            title.setTextColor(Color.WHITE)
        }
        title.text = "Hola, ${UserSession.userName}, estos son tus personajes favoritos"
        getCharactersFavorite()
    }


    private fun getCharactersFavorite() {
        val service = RickAndMortyService.create();
        val listFavorite= "1,5,7"
        // Lleno una lista con characteros que cree a mano
        service.getFavoriteCharacters(listFavorite)?.enqueue(
            object : Callback<List<CharacterData?>?> {
                override fun onResponse(
                    call: Call<List<CharacterData?>?>,
                    response: Response<List<CharacterData?>?>
                ) {
                    if (response.isSuccessful) {
                        val info = response.body()
                        Log.e("Example", response.body().toString())
                        val response: List<CharacterData> = (info as List<CharacterData>)!!
                        Snackbar.make(characterRecyclerView, "Metodo ondCreate", Snackbar.LENGTH_LONG).show()
                        characterList = response
                        fillCharacterList()
                    }
                }

                override fun onFailure(call: Call<List<CharacterData?>?>, t: Throwable) {
                    Log.e("Example", t.stackTraceToString())
                }
            })
    }


    private fun fillCharacterList() {
        val layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
        characterRecyclerView.layoutManager = layoutManager
        characterRecyclerView.adapter = CharacterFavoriteAdapter(characterList, this)
    }


    override fun onCharacterSelected(character: Character) {
        findNavController().navigate(FavoritesFragmentDirections.actionFavoritesFragmentToCharacterDetailFragment(character))
    }
}




