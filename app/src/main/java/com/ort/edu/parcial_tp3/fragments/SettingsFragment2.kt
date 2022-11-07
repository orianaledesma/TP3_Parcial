package com.ort.edu.parcial_tp3.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.ort.edu.parcial_tp3.R

class SettingsFragment2 : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)
    }
}