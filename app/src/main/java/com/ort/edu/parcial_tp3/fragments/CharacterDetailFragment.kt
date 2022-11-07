package com.ort.edu.parcial_tp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.ort.edu.parcial_tp3.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CharacterDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CharacterDetailFragment : Fragment() {

    private lateinit var description: TextView
    private lateinit var status: TextView
    private lateinit var characterImage: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        description = view.findViewById(R.id.character_description)
        status = view.findViewById(R.id.character_status)
        characterImage = view.findViewById(R.id.character_image)

        arguments?.let {
            val character = CharacterDetailFragmentArgs.fromBundle(it).character

            description.text = character.name
            status.text = "$${character.status}"
            Glide.with(this)
                .load(character.image)
                .into(characterImage)
        }

    }

}