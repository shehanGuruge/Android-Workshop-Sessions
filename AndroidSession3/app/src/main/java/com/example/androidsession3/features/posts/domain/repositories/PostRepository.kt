package com.example.androidsession3.features.posts.domain.repositories

import com.example.androidsession3.core.config.DataResponse
import com.example.androidsession3.core.config.Failure
import com.example.androidsession3.features.posts.domain.entities.PostEntity


interface PostRepository {
    suspend fun getPosts() : DataResponse<Failure, List<PostEntity>>
}