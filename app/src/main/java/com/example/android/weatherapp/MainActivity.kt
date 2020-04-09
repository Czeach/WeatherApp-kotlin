package com.example.android.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.toolbar_layout.*
import kotlinx.android.synthetic.main.weather_fragment.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_layout)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
//        toolbar_layout?.setupWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }
}
