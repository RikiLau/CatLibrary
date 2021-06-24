package com.ddxz.catlibrary.net

import com.ddxz.catlibrary.constant.Domain
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiService {

    val api: Api by lazy {
        val retrofit = Retrofit.Builder()
                .baseUrl(Domain.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().build())
                .build()
        retrofit.create(Api::class.java)
    }


}