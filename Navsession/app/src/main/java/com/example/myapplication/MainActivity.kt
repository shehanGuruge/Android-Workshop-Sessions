package com.example.myapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myapplication.core.BaseActivity
import com.example.myapplication.core.BaseViewModel
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity: BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    private val vm: MainViewModel by viewModels()
    override val baseViewModel: BaseViewModel
        get() = vm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)

        initObservers()
        binding.btnActivityNav.setOnClickListener {
            vm.onNavigate()
        }
    }

    override fun initObservers() {
        super.initObservers()
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
                || super.onSupportNavigateUp()
    }
}