package com.ddxz.catlibrary

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ddxz.catlibrary.bean.Cat
import com.ddxz.catlibrary.net.ApiService
import com.ddxz.catlibrary.util.printExceptionInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    val cats: MutableLiveData<List<Cat>> = MutableLiveData<List<Cat>>()

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