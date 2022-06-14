package com.kuswand.pagingexample

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search/users?per_page=10")
    suspend fun searchUsers(
        @Query("q") query: String,
        @Query("page") page: Int
    ): SearchResult
}