package com.example.androidsession3.core.di

import com.example.androidsession3.features.posts.data.datasources.PostsDataSource
import com.example.androidsession3.features.posts.data.datasources.PostsDataSourceImpl
import com.example.androidsession3.features.posts.data.repositories.PostRepositoryImpl
import com.example.androidsession3.features.posts.domain.repositories.PostRepository
import com.example.androidsession3.features.posts.domain.usecases.GetPostsUseCase
import com.example.androidsession3.features.posts.presentation.views.main.MainViewModel
import com.example.androidsession3.services.api.ApiClient
import com.example.androidsession3.services.network.NetworkService
import com.example.androidsession3.services.network.NetworkServiceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        ApiClient()
    }

    single<PostsDataSource> {
        PostsDataSourceImpl(get())
    }

    single<PostRepository> {
        PostRepositoryImpl(get(), get())
    }

    single {
        GetPostsUseCase(get())
    }

    viewModel {
        MainViewModel(get())
    }

    single<NetworkService> {
        NetworkServiceImpl(androidContext())
    }
}