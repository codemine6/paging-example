package com.kuswand.pagingexample

import retrofit2.http.GET

interface ApiService {
    @GET("search/users?q=code")
    suspend fun searchUsers(): SearchResult
}