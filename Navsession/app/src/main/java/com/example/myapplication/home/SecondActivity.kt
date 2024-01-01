package com.example.myapplication.home

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.MainViewModel
import com.example.myapplication.R
import com.example.myapplication.core.BaseActivity
import com.example.myapplication.core.BaseViewModel

class SecondActivity: BaseActivity() {

    private lateinit var btnPop: Button

    private val vm: SecondViewModel by viewModels()
    override val baseViewModel: BaseViewModel
        get() = vm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btnPop = findViewById(R.id.btn_pop)

        btnPop.setOnClickListener {
            vm.popScreen()
        }

        super.initObservers()
    }

}