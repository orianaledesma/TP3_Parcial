package com.ort.edu.parcial_tp3.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ort.edu.parcial_tp3.R
import com.ort.edu.parcial_tp3.UserSession
import com.ort.edu.parcial_tp3.adapter.CharacterAdapter
import com.ort.edu.parcial_tp3.api.RickAndMortyService
import com.ort.edu.parcial_tp3.data.CharactersResponse
import com.ort.edu.parcial_tp3.listener.OnCharacterClickedListener
import com.ort.edu.parcial_tp3.model.Character
import com.ort.edu.parcial_tp3.utils.Images
import retrofit2.Call
import retrofit2.Response


class HomeFragment : Fragment(), OnCharacterClickedListener {
    private lateinit var characterRecyclerView: RecyclerView
    private lateinit var characterList: List<Character>
    private lateinit var title: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        characterRecyclerView = view.findViewById(R.id.product_recyclerview)
        title = view.findViewById(R.id.home_title)


        title.text = "Hola, ${UserSession.userName}, estos son tus personajes favoritos"
        getCharacters()
    }

    fun getCharacters() {
        val baseURL = getString(R.string.url_api)

        val service = RickAndMortyService.create(baseURL);

        // Lleno una lista con characteros que cree a mano

        service.getListCharacters()?.enqueue(
            object : retrofit2.Callback<CharactersResponse?> {
                override fun onResponse(
                    call: Call<CharactersResponse?>,
                    response: Response<CharactersResponse?>
                ) {
                    if (response.isSuccessful) {
                        val info = response.body()
                        Log.e("Example", response.body().toString())
                        val response: CharactersResponse? = (info as CharactersResponse)!!
                        Snackbar.make(characterRecyclerView, "Metodo ondCreate", Snackbar.LENGTH_LONG).show()
                        characterList = (response?.result as List<Character>)
                        fillCharacterList()
                    }
                }
                override fun onFailure(call: Call<CharactersResponse?>, t: Throwable) {
                    Log.e("Example", t.stackTraceToString())
                }
            })
    }


    private fun fillCharacterList() {
        val character1 = Character("Rick blabla", Images.pixel, "Alive", "earth", "Human")
        val character2 = Character("Morty blabla", Images.remera, "Death", "earth", "extraterrestre")
        val character3 = Character("Rick blabla", Images.zapatillas, "Alive", "earth", "Human")
        val character4 = Character("Morty blabla", Images.heladera, "Death", "earth", "extraterrestre")


        characterList = listOf(character1, character2, character3, character4)
        val layoutManager = LinearLayoutManager(context)
        characterRecyclerView.layoutManager = layoutManager
        characterRecyclerView.adapter = CharacterAdapter(characterList, this)
    }


    override fun onCharacterSelected(character: Character) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToCharacterDetailFragment(character))
    }
}