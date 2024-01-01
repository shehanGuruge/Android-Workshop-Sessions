package com.example.apirequestssession.features.todo.data.datasources

import com.example.apirequestssession.features.todo.data.models.PostModel

interface PostsDataSource {
    suspend fun getPostsList(): List<PostModel>
}