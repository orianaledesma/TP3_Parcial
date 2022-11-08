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
    private lateinit var switch: Switch
    private lateinit var sharedPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharedPref = requireContext().getSharedPreferences("ParcialTP3SharedPreferences", Context.MODE_PRIVATE)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        avatarImage = view.findViewById(R.id.avatar_image)
        switch = view.findViewById(R.id.switchTheme)
        Log.i("something",sharedPref.toString())

        if (sharedPref.getBoolean("nightMode", false)) {
            switch.isChecked = true
        }

        switch.setOnCheckedChangeListener {
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

        val nameText = view.findViewById<TextView>(R.id.nameText)
        val passwordText = view.findViewById<TextView>(R.id.password_text)

        // Lo que hace esto es mostrar un subrayado para los TextView
        nameText.paintFlags = nameText.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        passwordText.paintFlags = passwordText.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        nameText.text = UserSession.userName

        // Cargo la imagen hardcodeada del avatar para la imagen. Como uso .circleCrop() entonces va a aparecer de forma
        // redondeada en lugar de cuadrada como lo haria por default
        Glide.with(this)
            .load("https://www.w3schools.com/howto/img_avatar.png")
            .circleCrop()
            .into(avatarImage)
    }
}