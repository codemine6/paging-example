package com.kuswand.pagingexample

import com.google.gson.annotations.SerializedName

data class SearchResult(
    val items: List<User>
)

data class User(
    @SerializedName("avatar_url")
    val avatarUrl: String,
    val login: String
)