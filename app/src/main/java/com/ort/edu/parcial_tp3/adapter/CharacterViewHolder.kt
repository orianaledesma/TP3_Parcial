package com.ort.edu.parcial_tp3.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ort.edu.parcial_tp3.R
import com.ort.edu.parcial_tp3.model.Character

class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val name: TextView
    private val status: TextView
    private val image: ImageView

    init {
        name = itemView.findViewById(R.id.character_name_text)
        status = itemView.findViewById(R.id.character_status_text)
        image = itemView.findViewById(R.id.character_image)
    }

    fun bind(character: Character) {
        name.text = character.name
        status.text = "Status: ${character.status}"

        Glide.with(itemView)
            .load(character.imageLink)
            .into(image)
    }
}