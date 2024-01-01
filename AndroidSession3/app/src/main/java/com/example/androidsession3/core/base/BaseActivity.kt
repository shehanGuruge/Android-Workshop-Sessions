package com.example.androidsession3.core.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

abstract class BaseActivity: AppCompatActivity() {

    abstract val baseViewModel: BaseViewModel?

    fun initObservers() {
        lifecycleScope.launch {
            baseViewModel?.toastContent?.collectLatest {
                Toast.makeText(this@BaseActivity, it, Toast.LENGTH_LONG).show()
            }
        }
    }

}