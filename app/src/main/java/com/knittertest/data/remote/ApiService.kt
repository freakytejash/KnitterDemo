package com.knittertest.data.remote

import com.knittertest.model.UserListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    companion object {
        const val API_URL = "https://gorest.co.in/public-api/"
    }

    @GET("posts?_format=json&access-token=HnMGB4Wu3L5vG8gnpTUdnidG-xOODi8M-9c3")
    suspend fun fetchUsers(
        @Query("page") number: Int,
        @Query("per_page") per_page: Int
    ): Response<UserListResponse>

}