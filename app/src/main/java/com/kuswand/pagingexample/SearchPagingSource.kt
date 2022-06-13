package com.kuswand.pagingexample

import androidx.paging.PagingSource
import androidx.paging.PagingState

class SearchPagingSource : PagingSource<Int, User>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        val page = params.key ?: 1
        val api = RetrofitInstance.api

        return try {
            val response = api.searchUsers()
            LoadResult.Page(
                data = response.items,
                prevKey = if (page == 0) null else page - 1,
                nextKey = if (response.items.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition
    }
}