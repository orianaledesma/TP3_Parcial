package com.ort.edu.parcial_tp3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ort.edu.parcial_tp3.R
import com.ort.edu.parcial_tp3.listener.OnCharacterClickedListener
import com.ort.edu.parcial_tp3.model.Character


class CharacterAdapter(
    private val characterList: List<Character>,
    private val onCharacterClickedListener: OnCharacterClickedListener
) : RecyclerView.Adapter<CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {

        val character = characterList[position]

        holder.bind(character)

        holder.itemView.setOnClickListener {
            onCharacterClickedListener.onCharacterSelected(character)
        }
    }

    override fun getItemCount() = characterList.size
}