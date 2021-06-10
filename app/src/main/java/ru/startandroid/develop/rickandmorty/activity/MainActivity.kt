package ru.startandroid.develop.rickandmorty.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.startandroid.develop.rickandmorty.R
import ru.startandroid.develop.rickandmorty.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val bottomNavigationView = mBinding.bottomNavigation
        val navController = findNavController(R.id.bottom_navigation_fragment)

        val appBarConfig = AppBarConfiguration(
            setOf(
                R.id.personageFragment,
                R.id.locationsFragment,
                R.id.episodesFragment,
                R.id.searchFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfig)
        bottomNavigationView.setupWithNavController(navController)


    }
}