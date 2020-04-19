package com.example.android.weatherapp

import android.content.Context
import android.net.ConnectivityManager
import com.example.android.weatherapp.internal.NoConnectionException
import okhttp3.Interceptor
import okhttp3.Response

class ConnectionInterceptorImpl(context: Context) :
    ConnectionInterceptor {

    private val appContext = context.applicationContext

    // throw an exception if user is not connected to the internet
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!ifUserIsOnline())
            throw NoConnectionException()

        return chain.proceed(chain.request())
    }

    // handles call if the app is connected to the internet
    private fun ifUserIsOnline() : Boolean {
        // get connectivity manager
        val connectivityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        // get network info from the connectivity manager
        val networkInfo = connectivityManager.activeNetworkInfo

        return networkInfo != null && networkInfo.isConnected
    }
}