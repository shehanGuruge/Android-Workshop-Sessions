package com.example.androidsession3.features.posts.presentation.views.main

import androidx.lifecycle.viewModelScope
import com.example.androidsession3.core.base.BaseViewModel
import com.example.androidsession3.core.config.DataResponse
import com.example.androidsession3.features.posts.domain.entities.PostEntity
import com.example.androidsession3.features.posts.domain.usecases.GetPostsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainViewModel(private val getPostsUseCase: GetPostsUseCase): BaseViewModel() {
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

