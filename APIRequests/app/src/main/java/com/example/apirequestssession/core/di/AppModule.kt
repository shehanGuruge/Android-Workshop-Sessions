package com.example.apirequestssession.core.di

import com.example.apirequestssession.features.todo.data.datasources.PostsDataSource
import com.example.apirequestssession.features.todo.data.datasources.PostsDataSourceImpl
import com.example.apirequestssession.features.todo.data.repositories.PostRepositoryImpl
import com.example.apirequestssession.features.todo.domain.repositories.PostRepository
import com.example.apirequestssession.features.todo.domain.usecases.GetPostsUsecase
import com.example.apirequestssession.features.todo.presentation.MainViewModel
import com.example.apirequestssession.services.api.ApiClient
import com.example.apirequestssession.services.network.NetworkService
import com.example.apirequestssession.services.network.NetworkServiceImpl
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
        GetPostsUsecase(get())
    }

    viewModel {
        MainViewModel(get())
    }

    single<NetworkService> {
        NetworkServiceImpl(androidContext())
    }
}