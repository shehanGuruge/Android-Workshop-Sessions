package com.example.androidsession3.services.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

class NetworkServiceImpl(context: Context): NetworkService {
    private val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    override fun isConnected(): Boolean {
        val network = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ->  true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ->  true
            else -> false
        }
    }
}