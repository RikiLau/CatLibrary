package com.ddxz.catlibrary.base

import androidx.appcompat.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() {

    companion object {
        val TAG: String by lazy { BaseActivity::class.java.simpleName }
    }
}