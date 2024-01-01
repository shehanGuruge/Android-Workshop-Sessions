package com.example.apirequestssession.services.api

import com.example.apirequestssession.core.config.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private var retrofit: Retrofit
    private var apiService: ApiService? = null

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(Constants.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiService = retrofit.create(ApiService::class.java)
    }

    fun getApiService(): ApiService {
        if(apiService == null) {
            apiService = retrofit.create(ApiService::class.java)
        }
        return apiService!!
    }
}