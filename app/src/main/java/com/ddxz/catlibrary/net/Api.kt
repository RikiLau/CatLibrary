package com.ddxz.catlibrary.net

import com.ddxz.catlibrary.bean.Cat
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("breeds?limit=10")
    suspend fun fetchCatList(@Query("page") page: Int = 0): List<Cat>
}