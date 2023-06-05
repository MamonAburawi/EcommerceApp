package com.mamon.ecommerceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.mamon.ecommerceapp.databinding.ActivityMainBinding
import com.mamon.ecommerceapp.utils.hide
import com.mamon.ecommerceapp.utils.setMargin
import com.mamon.ecommerceapp.utils.show

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navHost: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        navHost = supportFragmentManager.findFragmentById(R.id.home_nav_host_fragment) as NavHostFragment


        setUpNav()

        setButtons()


    }

    private fun setButtons() {
        /** button cart **/
        binding.btnCart.setOnClickListener {
            navHost.navController.navigate(R.id.cart)
        }
    }


    private fun setUpNav() {
        binding.apply {
            homeNavHostFragment.setMargin(0,0,0,0)
            NavigationUI.setupWithNavController(bottomNavigationBar, navHost.navController)
            navHost.navController.addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.splash ->{ hideElements() }
                    R.id.cart ->{ hideElements() }
                    R.id.details ->{ hideElements() }
                    R.id.photoViewer -> {hideElements()}
                    else -> { showElements() }
                }
            }
        }
    }



    // hide navigation bottom
    private fun hideElements(){
        binding.apply {
            homeNavHostFragment.setMargin(0,0,0,0)
            coordinator.hide()
        }
    }


    // show navigation bottom
    private fun showElements(){
        binding.apply {
            homeNavHostFragment.setMargin(0,0,0,70)
            coordinator.show()
        }
    }


}