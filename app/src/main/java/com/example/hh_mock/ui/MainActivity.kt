package com.example.hh_mock.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.data.local.AppPreferences
import com.example.data.model.home.AllVacancyModel
import com.example.hh_mock.R
import com.example.hh_mock.databinding.ActivityMainBinding
import com.example.hh_mock.ui.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var favoriteVacancyStorage: FavoriteVacancyStorage

    @Inject
    lateinit var appPreferences: AppPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        favoriteVacancyStorage = FavoriteVacancyStorage(this)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        binding.bnvMain.setupWithNavController(navHostFragment.navController)
        navController = navHostFragment.navController

        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment,
                R.id.favoriteFragment,
                R.id.repliesFragment,
                R.id.messageFragment,
                R.id.profileFragment -> {
                }
            }
        }

        if (appPreferences.isUserRegister) {
            setStartDestination(R.id.homeFragment)
        } else {
            setStartDestination(R.id.loginFragment)
        }

        viewModel.getAllData()
        viewModel.favorites.observe(this){
            updateCartCounter(it.size)
        }
    }

    private fun setStartDestination(destinationId: Int) {
        val navGraph = navController.navInflater.inflate(R.navigation.main_navigation)
        navGraph.setStartDestination(destinationId)
        navController.graph = navGraph
    }

    private fun updateCartCounter(count: Int) {

        val badge = binding.bnvMain.getOrCreateBadge(R.id.favoriteFragment)
        badge.isVisible = true
        badge.number = count

        if (count == 0) {
            val badgeDrawable = binding.bnvMain.getBadge(R.id.favoriteFragment)
            if (badgeDrawable != null) {
                badgeDrawable.isVisible = false
                badgeDrawable.clearNumber()
            }
        }
    }
}