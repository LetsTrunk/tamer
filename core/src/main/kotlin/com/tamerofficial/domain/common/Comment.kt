package com.tamerofficial.domain.common

import java.time.LocalDateTime

data class Comment(
    val content:String,
    val createdBy: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)