package com.ddxz.catlibrary

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ddxz.catlibrary.bean.Cat
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val cats: MutableLiveData<List<Cat>> = MutableLiveData<List<Cat>>()

    fun fetchCatsList () {
        viewModelScope.launch {

        }
    }
}