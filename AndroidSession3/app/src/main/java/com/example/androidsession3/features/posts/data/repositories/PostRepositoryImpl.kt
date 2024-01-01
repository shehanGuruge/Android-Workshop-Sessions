package com.example.androidsession3.features.posts.data.repositories

import com.example.androidsession3.core.config.AppFailure
import com.example.androidsession3.core.config.DataResponse
import com.example.androidsession3.core.config.Failure
import com.example.androidsession3.core.config.NetworkFailure
import com.example.androidsession3.features.posts.data.datasources.PostsDataSource
import com.example.androidsession3.features.posts.data.models.toEntity
import com.example.androidsession3.features.posts.domain.entities.PostEntity
import com.example.androidsession3.features.posts.domain.repositories.PostRepository
import com.example.androidsession3.services.network.NetworkService

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