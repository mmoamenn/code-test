package com.interview.codetest.data.api

import com.interview.codetest.data.network.NetworkManager
import com.interview.codetest.data.response.PageResponse
import retrofit2.http.GET
import retrofit2.http.Url

class NetworkAPI {

    interface Services {
        @GET("androiddash-se")
        suspend fun getAllSections(): PageResponse

        @GET
        suspend fun getSection(@Url sectionURL: String): PageResponse
    }

    val call: Services = NetworkManager().request().create(Services::class.java)

}