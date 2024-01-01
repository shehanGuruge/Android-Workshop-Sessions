package com.example.apirequestssession.features.todo.data.repositories

import com.example.apirequestssession.features.todo.data.datasources.PostsDataSource
import com.example.apirequestssession.features.todo.data.models.toEntity
import com.example.apirequestssession.features.todo.domain.entities.PostEntity
import com.example.apirequestssession.features.todo.domain.repositories.PostRepository
import com.example.apirequestssession.services.network.NetworkService
import com.example.apirequestssession.core.config.AppFailure
import com.example.apirequestssession.core.config.DataResponse
import com.example.apirequestssession.core.config.Failure
import com.example.apirequestssession.core.config.NetworkFailure

class PostRepositoryImpl(
    private val dataSource: PostsDataSource,
    private val networkService: NetworkService
    ): PostRepository {

    override suspend fun getPosts(): DataResponse<Failure, List<PostEntity>> {
        return if(networkService.isConnected()) {
            try {
                val response = dataSource.getPostsList()
                DataResponse.Success(response.map { it.toEntity() })
            } catch (e: java.lang.Exception) {
                DataResponse.Error(AppFailure("error", e.message))
            }
        } else {
            DataResponse.Error(NetworkFailure("net_issue", "Device is not connected"))
        }
    }
}