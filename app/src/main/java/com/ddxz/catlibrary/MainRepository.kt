package com.ddxz.catlibrary

import android.os.Looper
import com.ddxz.catlibrary.bean.Cat
import com.ddxz.catlibrary.net.ApiService
import com.ddxz.catlibrary.util.logD
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository {

    suspend fun fetchCatList (): List<Cat> {
        logD("riki", "1当前线程:${Thread.currentThread().name} 主线程:${Looper.getMainLooper().thread.name}")
        return withContext(Dispatchers.IO) {
            logD("riki", "2当前线程:${Thread.currentThread().name} 主线程:${Looper.getMainLooper().thread.name}")
            ApiService.api.fetchCatList()
        }
    }
}