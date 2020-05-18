package com.interview.codetest.data.network

import com.interview.codetest.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkManager {

    fun request(): Retrofit {
        val client = OkHttpClient.Builder().apply {
            addInterceptor(requestInterceptor)
            setOkHttpClientTimeouts(this)
        }
        return getRetrofitInstance(client)
    }

    private val requestInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private fun setOkHttpClientTimeouts(client: OkHttpClient.Builder): OkHttpClient.Builder {
        client.connectTimeout(30, TimeUnit.SECONDS)
        client.readTimeout(30, TimeUnit.SECONDS)
        client.writeTimeout(30, TimeUnit.SECONDS)
        return client
    }

    private fun getRetrofitInstance(okHttpClient: OkHttpClient.Builder): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()

    }

}