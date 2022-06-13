package com.kuswand.pagingexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow

class MainViewModel : ViewModel() {

    val result: Flow<PagingData<User>> = Pager(
        config = PagingConfig(pageSize = 20),
        pagingSourceFactory = { SearchPagingSource() }
    ).flow.cachedIn(viewModelScope)
}