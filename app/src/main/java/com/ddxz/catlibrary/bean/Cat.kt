package com.ddxz.catlibrary.bean

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Cat(
    val name: String?,
    val id: String?,
    val image: Image?
    )

@JsonClass(generateAdapter = true)
data class Image(
    val url: String?,
    val width: Int,
    val height: Int
                )
