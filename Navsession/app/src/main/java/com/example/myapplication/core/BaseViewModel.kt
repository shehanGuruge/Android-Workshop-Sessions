package com.example.myapplication.core

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import androidx.navigation.NavDirections
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlin.jvm.internal.Reflection

abstract class BaseViewModel : ViewModel() {

//    private val _navigation = MutableLiveData<Event<NavigationCommand>>()
//    val navigation: LiveData<Event<NavigationCommand>> get() = _navigation

    private val _navigation = MutableSharedFlow<NavigationCommand>()
    val navigation = _navigation.asSharedFlow()

    private val _navigateToActivity = MutableSharedFlow<Navigation>()
    val navigateToActivity = _navigateToActivity.asSharedFlow()

    fun navigate(navDirections: NavDirections) {
        viewModelScope.launch {
            _navigation.emit(NavigationCommand.ToDirection(navDirections))
        }
//        _navigation.value = Event(NavigationCommand.ToDirection(navDirections))
    }

    fun navigateBack() {
        viewModelScope.launch {
            _navigation.emit(NavigationCommand.Back)
        }
//        _navigation.value = Event(NavigationCommand.Back)
    }


    fun navigateToActivity(data: Navigation) {
        viewModelScope.launch {
            _navigateToActivity.emit(data)
        }
    }


    fun goBack() {
        viewModelScope.launch {
            _navigateToActivity.emit(Navigation(navType = NavType.POP))
        }
    }
}


fun <T> LiveData<T>.observeNonNull(owner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(
        owner
    ) {
        it?.let(observer)
    }
}

enum class NavType{
    PUSH,
    POP
}

data class Navigation(var activity: Class<out AppCompatActivity>? = null, var bundle: Bundle? = null,
                      val navType: NavType)