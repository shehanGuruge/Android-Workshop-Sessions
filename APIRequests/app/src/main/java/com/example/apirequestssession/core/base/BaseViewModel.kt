package com.example.apirequestssession.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

open class BaseViewModel: ViewModel() {

    private val _toastContent = MutableSharedFlow<String>()
    val toastContent = _toastContent.asSharedFlow()

    fun toast(content: String) {
        viewModelScope.launch {
            _toastContent.emit(content)
        }
    }
}
