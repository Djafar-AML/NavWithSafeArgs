package com.example.navwithsafeargs

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.example.navwithsafeargs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        // update UI component with navigation UI
        val navController = findNavController(R.id.myNavHostFragment)


        appBarConfiguration = AppBarConfiguration(navGraph = navController.graph)
        NavigationUI.setupActionBarWithNavController(this, navController)

        // Bottom navigation
        binding.bottomNav.setupWithNavController(navController)


        // setup and display navigation drawer
        NavigationUI.setupWithNavController(binding.navView, navController)

        // show hamburger icon
        drawerLayout = binding.drawerLayout
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.myNavHostFragment)

        return NavigationUI.navigateUp(navController, drawerLayout) || super.onSupportNavigateUp()
    }


    // setup menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.myNavHostFragment)

        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }
}
