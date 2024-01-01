package com.example.androidsession3.services.api

import com.example.androidsession3.core.config.Constants
import com.example.androidsession3.features.posts.data.models.PostModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET(Constants.getPostsEndpoint)
    suspend fun getPosts(): Response<List<PostModel>>
}