package com.ddxz.catlibrary

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.ddxz.catlibrary.bean.Cat
import com.ddxz.catlibrary.net.ApiService
import com.ddxz.catlibrary.paging.CatPagingSource
import com.ddxz.catlibrary.util.printExceptionInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    val cats: MutableLiveData<List<Cat>> = MutableLiveData<List<Cat>>()

    val flow = Pager(
        // Configure how data is loaded by passing additional properties to
        // PagingConfig, such as prefetchDistance.
        PagingConfig(pageSize = 10)
                    ) {
        CatPagingSource()
    }.flow
            .cachedIn(viewModelScope)

    fun fetchCatsList () {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    cats.postValue(ApiService.api.fetchCatList())
                }
            }
            catch (e: Exception) {
                printExceptionInfo(e)
            }
        }
    }
}