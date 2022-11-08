package com.ort.edu.parcial_tp3.fragments

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ort.edu.parcial_tp3.R
import com.ort.edu.parcial_tp3.UserSession
import com.ort.edu.parcial_tp3.adapter.CharacterAdapter
import com.ort.edu.parcial_tp3.api.RickAndMortyService
import com.ort.edu.parcial_tp3.data.CharacterData
import com.ort.edu.parcial_tp3.data.CharactersResponse
import com.ort.edu.parcial_tp3.listener.OnCharacterClickedListener
import com.ort.edu.parcial_tp3.model.Character
import retrofit2.Call
import retrofit2.Response
import java.util.*


class HomeFragment : Fragment(), OnCharacterClickedListener {
    private lateinit var characterRecyclerView: RecyclerView
    private lateinit var characterList: List<CharacterData>
    private lateinit var title: TextView
    private lateinit var sharedPref: SharedPreferences
    private lateinit var txtBuscar: SearchView
    private var listaTemporal: MutableList<CharacterData> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharedPref = requireContext().getSharedPreferences("ParcialTP3SharedPreferences", Context.MODE_PRIVATE)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtBuscar = view.findViewById(R.id.buscador)

        characterRecyclerView = view.findViewById(R.id.product_recyclerview)
        title = view.findViewById(R.id.home_title)

        if (sharedPref.getBoolean("nightMode", true)) {
            title.setTextColor(Color.WHITE)
        }

        title.text = "Hola, ${UserSession.userName}"
        getCharacters()
        buscador()
    }

    fun getCharacters() {
        val service = RickAndMortyService.create();

        // Lleno una lista con personajes
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
                        characterList = (response?.results as List<CharacterData>)
                        fillCharacterList()
                    }
                }
                override fun onFailure(call: Call<CharactersResponse?>, t: Throwable) {
                    Log.e("Example", t.stackTraceToString())
                }
            })
    }

    private fun buscador(){

        txtBuscar.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                listaTemporal.clear()
                val searchText = newText!!.lowercase(Locale.getDefault())
                if (searchText.isNotEmpty()) { characterList.forEach {
                    if (it.name!!.lowercase(Locale.getDefault()).contains(searchText)) {
                        listaTemporal.add(it)
                    }
                }


                } else {
                    listaTemporal.clear()
                    listaTemporal.addAll(characterList)

                }

                fillSearch(listaTemporal)
                return false
            }
        })
    }

    private fun fillSearch(listaTemporal: MutableList<CharacterData>) {

        val layoutManager = LinearLayoutManager(context)
        characterRecyclerView.layoutManager = layoutManager
        characterRecyclerView.adapter = CharacterAdapter(listaTemporal, this)
    }

    private fun fillCharacterList() {
        val layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
        characterRecyclerView.layoutManager = layoutManager
        characterRecyclerView.adapter = CharacterAdapter(characterList, this)
    }


    override fun onCharacterSelected(character: Character) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToCharacterDetailFragment(character))
    }
}