package com.ort.edu.parcial_tp3

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
import androidx.preference.SwitchPreference
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var userName: String? = null
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        setupDrawerLayout()
    }


    private fun setupDrawerLayout() {

        val navController = navHostFragment.navController
        navigationView.setupWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        navController.addOnDestinationChangedListener { _, destination, arguments ->
            // Aca le digo que quiero que mi icono izquierdo de la appbar sea el del drawer
            supportActionBar?.setHomeAsUpIndicator(R.drawable.hamburger)

            if (destination.id == R.id.loginFragment) {
                nav_view.visibility = View.GONE
            } else {
                nav_view.visibility = View.VISIBLE

                if (destination.id == R.id.homeFragment) {
                     arguments?.getString("username")?.let { UserSession.userName = it }
                    }
            }
        }
    }
            // Si mi destino es el login entonces oculto la barra inferior. Caso contrario la muestro
          //  if (destination.id == R.id.loginFragment) {
           //     nav_view.visibility = View.GONE
            //} else {
              //  nav_view.visibility = View.VISIBLE

                // Si mi destino es la Home, tomo el userName que recibio por parametro y lo almaceno en un Object
               //if (destination.id == R.id.homeFragment) {
                 //  arguments?.getString("username")?.let { UserSession.userName = it }
               //}
           //}
        //}

      override fun onSupportNavigateUp(): Boolean {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
           }

           return false
        }

}
