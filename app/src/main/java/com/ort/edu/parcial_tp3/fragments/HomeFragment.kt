package com.ort.edu.parcial_tp3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ort.edu.parcial_tp3.R
import com.ort.edu.parcial_tp3.UserSession
import com.ort.edu.parcial_tp3.adapter.CharacterAdapter
import com.ort.edu.parcial_tp3.listener.OnCharacterClickedListener
import com.ort.edu.parcial_tp3.model.Character
import com.ort.edu.parcial_tp3.utils.Images


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
        fillCharacterList()
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