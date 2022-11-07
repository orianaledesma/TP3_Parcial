package com.ort.edu.parcial_tp3.listener

import com.ort.edu.parcial_tp3.model.Character

/**
 * Esta interfaz sera utilizada para ser implementada cuando se quiera manejar la seleccion de un charactero en una clase
 */
interface OnCharacterClickedListener {

    /**
     * Se invoca cuando se selecciona un charactero de la lista
     */
    fun onCharacterSelected(character: Character)
}