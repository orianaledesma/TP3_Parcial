package com.ort.edu.parcial_tp3.viewModel

import androidx.lifecycle.ViewModel
import com.ort.edu.parcial_tp3.model.Character

class ViewModelCharacter: ViewModel() {
    var characterList: MutableList<Character> = mutableListOf<Character>()
}