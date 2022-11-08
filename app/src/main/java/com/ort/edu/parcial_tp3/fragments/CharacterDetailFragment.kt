package com.ort.edu.parcial_tp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.ort.edu.parcial_tp3.R



class CharacterDetailFragment : Fragment() {

    private lateinit var name: TextView
    private lateinit var status: TextView
    private lateinit var characterImage: ImageView
    private lateinit var origin: TextView
    private lateinit var especie: TextView
    private lateinit var add: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.character_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        name = view.findViewById(R.id.character_name)
        status = view.findViewById(R.id.character_status)
        origin = view.findViewById(R.id.character_origin)
        especie = view.findViewById(R.id.character_especie)
        characterImage = view.findViewById(R.id.character_image)
        add = view.findViewById(R.id.fab)

        arguments?.let {
            val character = CharacterDetailFragmentArgs.fromBundle(it).character

            name.text =character.name
            status.text = "status: ${character.status}"
            origin.text = "origen: ${character.origin}"
            especie.text = "Especie: ${character.especie}"

            Glide.with(this)
                .load(character.imageLink)
                .into(characterImage)
        }
        add.setOnClickListener { view ->
            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }

    }

}