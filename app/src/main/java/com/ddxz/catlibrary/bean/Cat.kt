package com.ddxz.catlibrary.bean

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Cat(val name: String)