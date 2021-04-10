package com.tamerofficial.domain.common

data class Review(
    val title: String,
    val content:String,
    val comments : List<Comment>
)