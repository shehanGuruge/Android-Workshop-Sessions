package com.example.myapplication.core

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class BaseActivity: AppCompatActivity() {
    abstract val baseViewModel: BaseViewModel?

    protected inline fun <reified T : BaseViewModel> provideViewModel(): T =
        ViewModelProvider(this)[T::class.java]

    protected open fun initObservers() {
        lifecycleScope.launch {
            baseViewModel?.navigateToActivity?.collect {it ->
                when(it.navType){
                    NavType.PUSH -> {
                        val intent = Intent(this@BaseActivity, it.activity)
                        startActivity(intent, it.bundle)
                    }
                    NavType.POP -> {
                       finish()
                    }
                }
            }
        }

    }
}