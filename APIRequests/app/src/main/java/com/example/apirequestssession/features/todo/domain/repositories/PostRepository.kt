package com.example.apirequestssession.features.todo.domain.repositories

import com.example.apirequestssession.features.todo.domain.entities.PostEntity
import com.example.apirequestssession.core.config.DataResponse
import com.example.apirequestssession.core.config.Failure

interface PostRepository {
    suspend fun getPosts() : DataResponse<Failure, List<PostEntity>>
}