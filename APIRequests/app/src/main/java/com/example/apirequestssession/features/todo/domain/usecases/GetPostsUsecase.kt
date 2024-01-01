package com.example.apirequestssession.features.todo.domain.usecases

import com.example.apirequestssession.features.todo.domain.entities.PostEntity
import com.example.apirequestssession.features.todo.domain.repositories.PostRepository
import com.example.apirequestssession.core.config.DataResponse
import com.example.apirequestssession.core.config.Failure
import com.example.apirequestssession.core.config.Usecase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GetPostsUsecase(private val repository: PostRepository) : Usecase<List<PostEntity>, Nothing>() {

    override suspend fun invoke(params: Nothing?): DataResponse<Failure, List<PostEntity>?> =
        repository.getPosts()
}

