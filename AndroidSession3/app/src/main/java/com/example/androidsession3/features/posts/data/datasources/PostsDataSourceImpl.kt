package com.example.androidsession3.features.posts.data.datasources

import com.example.androidsession3.features.posts.data.models.PostModel
import com.example.androidsession3.services.api.ApiClient

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