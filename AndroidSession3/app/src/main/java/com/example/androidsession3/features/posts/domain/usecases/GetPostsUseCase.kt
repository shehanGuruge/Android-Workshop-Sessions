package com.example.androidsession3.features.posts.domain.usecases

import com.example.androidsession3.core.config.DataResponse
import com.example.androidsession3.core.config.Failure
import com.example.androidsession3.core.config.UseCase
import com.example.androidsession3.features.posts.domain.entities.PostEntity
import com.example.androidsession3.features.posts.domain.repositories.PostRepository

class GetPostsUseCase(private val repository: PostRepository) : UseCase<List<PostEntity>, Nothing>() {

    override suspend fun invoke(params: Nothing?): DataResponse<Failure, List<PostEntity>?> =
        repository.getPosts()
}

