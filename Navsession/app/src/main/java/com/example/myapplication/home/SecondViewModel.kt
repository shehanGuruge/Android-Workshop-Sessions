package com.example.myapplication.home

import com.example.myapplication.core.BaseViewModel
import com.example.myapplication.core.NavType
import com.example.myapplication.core.Navigation

class SecondViewModel: BaseViewModel() {
    fun popScreen() {
       goBack()
    }
}