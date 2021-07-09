package com.ddxz.catlibrary.net

import com.ddxz.catlibrary.constant.Domain
import com.ddxz.catlibrary.util.logD
import com.ddxz.catlibrary.util.printExceptionInfo
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.URLDecoder

object ApiService {

    const val TAG = "ApiService"

    val api: Api by lazy {

        Retrofit.Builder()
                .baseUrl(Domain.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor(
                    HttpLoggingInterceptor { message ->
                        try {
                            logD(TAG, URLDecoder.decode(message.replace("%(?![0-9a-fA-F]{2})".toRegex(), "%25"), "UTF-8"))
                        }
                        catch (e: Exception) {
                            printExceptionInfo(e)
                        }
                    }.setLevel(HttpLoggingInterceptor.Level.BASIC)).build())
                .build().create(Api::class.java)
    }


}