package com.example.apirequestssession.features.todo.data.datasources

import com.example.apirequestssession.features.todo.data.models.PostModel
import com.example.apirequestssession.services.api.ApiClient
import kotlinx.coroutines.delay

class PostsDataSourceImpl(private val apiClient: ApiClient) : PostsDataSource {
    override suspend fun getPostsList(): List<PostModel> {
        try {
            val response = apiClient.getApiService().getPosts()
            return response.body() ?: arrayListOf()
        } catch (e: java.lang.Exception) {
            throw e
        }
    }
}