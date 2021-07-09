package com.ddxz.catlibrary.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ddxz.catlibrary.bean.Cat
import com.ddxz.catlibrary.net.ApiService
import com.ddxz.catlibrary.util.logD
import com.ddxz.catlibrary.util.printExceptionInfo

class CatPagingSource(): PagingSource<Int, Cat>() {

    companion object {
        const val TAG = "CatPagingSource"
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Cat> {
        return try {
            // Start refresh at page 1 if undefined.
            val nextPageNumber = params.key ?: 0
            val response = ApiService.api.fetchCatList(nextPageNumber)
            val nextKey = if (response.isNullOrEmpty()) null else nextPageNumber + 1
            logD(TAG, "load success: $response")
            LoadResult.Page(
                data = response,
                prevKey = null, // Only paging forward.
                nextKey = nextKey)
        } catch (e: Exception) {
            printExceptionInfo(e)
            // Handle errors in this block and return LoadResult.Error if it is an
            // expected error (such as a network failure).
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Cat>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}