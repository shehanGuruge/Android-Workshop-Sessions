package com.example.myapplication

import com.example.myapplication.core.BaseViewModel
import com.example.myapplication.core.NavType
import com.example.myapplication.core.Navigation
import com.example.myapplication.home.SecondActivity

class MainViewModel: BaseViewModel() {


    fun onPress() {
        navigate(Fragment1Directions.actionFragment1ToFragment2("sample"))
    }

    fun onNavigate() {
        val data = Navigation(activity = SecondActivity::class.java, navType = NavType.PUSH)
        navigateToActivity(data)
    }

}