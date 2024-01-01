package com.example.androidsession3.features.posts.data.datasources

import com.example.androidsession3.features.posts.data.models.PostModel


interface PostsDataSource {
    suspend fun getPostsList(): List<PostModel>
}