package com.ort.edu.parcial_tp3.fragments

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.ort.edu.parcial_tp3.R
import com.ort.edu.parcial_tp3.UserSession


class SettingsFragment : Fragment() {

    private lateinit var avatarImage: ImageView
    private lateinit var switchTheme: Switch
    private lateinit var switchFav: Switch
    private lateinit var switchSearch: Switch
    private lateinit var sharedPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharedPref = requireContext().getSharedPreferences("ParcialTP3SharedPreferences", Context.MODE_PRIVATE)
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        switchTheme = view.findViewById(R.id.switch_theme)
        switchFav = view.findViewById(R.id.switch_fav)
        switchSearch = view.findViewById(R.id.switch_search)
        Log.i("something",sharedPref.toString())

        if (sharedPref.getBoolean("nightMode", false)) {
            switchTheme.isChecked = true
        }

        switchTheme.setOnCheckedChangeListener {
                buttonView, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPref.edit().putBoolean("nightMode", true).apply()
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPref.edit().putBoolean("nightMode", false).apply()
            }
        }
    }
}