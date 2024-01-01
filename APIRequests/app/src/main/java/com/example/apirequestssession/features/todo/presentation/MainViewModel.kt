package com.example.apirequestssession.features.todo.presentation

import androidx.lifecycle.viewModelScope
import com.example.apirequestssession.core.base.BaseViewModel
import com.example.apirequestssession.features.todo.domain.entities.PostEntity
import com.example.apirequestssession.features.todo.domain.usecases.GetPostsUsecase
import com.example.apirequestssession.core.config.DataResponse
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(private val getPostsUseCase: GetPostsUsecase): BaseViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _postsList = MutableStateFlow<List<PostEntity>?>(listOf())
    val postsList: StateFlow<List<PostEntity>?> = _postsList

    fun getPostList() {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.value = true
            when (val response = getPostsUseCase(null)) {
                is DataResponse.Success -> {
                    _isLoading.value = false
                    _postsList.value = response.data
                }
                is DataResponse.Error -> {
                    _isLoading.value = false
                    response.error.message?.let { toast(it) }
                }
            }
        }
    }
}

