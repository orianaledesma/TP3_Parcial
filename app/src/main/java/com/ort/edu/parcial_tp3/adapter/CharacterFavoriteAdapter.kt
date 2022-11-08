package com.ort.edu.parcial_tp3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ort.edu.parcial_tp3.R
import com.ort.edu.parcial_tp3.data.CharacterData
import com.ort.edu.parcial_tp3.data.OriginCharacter
import com.ort.edu.parcial_tp3.fragments.FavoritesFragment
import com.ort.edu.parcial_tp3.fragments.HomeFragment
import com.ort.edu.parcial_tp3.listener.OnCharacterClickedListener
import com.ort.edu.parcial_tp3.model.Character


class CharacterFavoriteAdapter(
    private val characterList: List<CharacterData>,
    private val onCharacterClickedListener: FavoritesFragment

    ) : RecyclerView.Adapter<CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {

        val name = characterList[position].name
        val imageLink = characterList[position].image
        val status = characterList[position].status
        val origin = characterList[position].origin.name
        val especie = characterList[position].species
        val character =Character(name,imageLink,status,origin, especie)

        holder.bind(character)

        holder.itemView.setOnClickListener {
            onCharacterClickedListener.onCharacterSelected(character)
        }
    }

    override fun getItemCount() = characterList.size
}