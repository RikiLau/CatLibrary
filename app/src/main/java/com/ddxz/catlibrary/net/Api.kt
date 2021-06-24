package com.ddxz.catlibrary.net

import com.ddxz.catlibrary.bean.Cat
import retrofit2.http.GET

interface Api {

    @GET("breeds")
    suspend fun fetchCatList(): List<Cat>
}