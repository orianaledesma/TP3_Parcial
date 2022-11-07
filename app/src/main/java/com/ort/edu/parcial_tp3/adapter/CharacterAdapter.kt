package com.ort.edu.parcial_tp3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ort.edu.parcial_tp3.R
import com.ort.edu.parcial_tp3.data.Character
import com.ort.edu.parcial_tp3.listener.OnCharacterClickedListener

/**
 * Adapter para los characteros que se muestran en la Home.
 * @param charactersList La lista de characteros que vamos a mostrar
 * @param onCharacterClickedListener listener al cual se va a invocar cada vez que se seleccione un charactero de la lista
 */
class CharacterAdapter(
    private val charactersList: List<com.ort.edu.parcial_tp3.model.Character>,
    private val onCharacterClickedListener: OnCharacterClickedListener
) : RecyclerView.Adapter<CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        // De la lista, obtengo el charactero basandome en la posicion de la celda en el recyclerview
        val character = charactersList[position]

        // Se invoca al ViewHolder para que muestre los datos del charactero
        holder.bind(character)

        // Establezco un click listener en el itemview del holder. Esto seria, la vista entera del elemento {position}
        // de la lista
        holder.itemView.setOnClickListener {
            onCharacterClickedListener.onCharacterSelected(character)
        }
    }

    override fun getItemCount() = charactersList.size
}