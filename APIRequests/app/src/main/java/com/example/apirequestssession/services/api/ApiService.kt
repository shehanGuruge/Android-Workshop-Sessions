package com.example.apirequestssession.services.api

import com.example.apirequestssession.core.config.Constants
import com.example.apirequestssession.features.todo.data.models.PostModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET(Constants.getPostsEndpoint)
    suspend fun getPosts(): Response<List<PostModel>>
}