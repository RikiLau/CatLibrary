package com.ddxz.catlibrary.net

import com.ddxz.catlibrary.constant.Domain
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiService {

    val api: Api by lazy {

        Retrofit.Builder()
                .baseUrl(Domain.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor(
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)).build())
                .build().create(Api::class.java)
    }


}