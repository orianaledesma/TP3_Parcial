package com.ort.edu.parcial_tp3.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ort.edu.parcial_tp3.R
import com.ort.edu.parcial_tp3.adapter.FavoritesAdapter
import com.ort.edu.parcial_tp3.model.Character
import com.ort.edu.parcial_tp3.viewModel.ViewModelCharacter


    class FavoritesFragment : Fragment() {
        private lateinit var character: Character
        private lateinit var characterRecyclerView: RecyclerView
        private var characterList: MutableList<Character> = mutableListOf<Character>()
        private val viewModel: ViewModelCharacter by activityViewModels()


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            arguments?.let {
                character = CharacterDetailFragmentArgs.fromBundle(it).character
                characterList.add(character)

            }
        }

                override fun onCreateView(
                    inflater: LayoutInflater, container: ViewGroup?,
                    savedInstanceState: Bundle?
                ): View? {
                    // Inflate the layout for this fragment
                    return inflater.inflate(R.layout.fragment_favorites, container, false)
                }


                override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                    super.onViewCreated(view, savedInstanceState)
                    characterRecyclerView = view.findViewById(R.id.favorite_recyclerview)
                    fillCharacterList()
                }

                private fun fillCharacterList() {
                    val layoutManager = LinearLayoutManager(context)
                    characterRecyclerView.layoutManager = layoutManager
                    characterRecyclerView.adapter = FavoritesAdapter(viewModel.characterList)
                }

            }





