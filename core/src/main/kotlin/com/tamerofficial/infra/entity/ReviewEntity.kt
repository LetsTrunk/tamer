package com.tamerofficial.infra.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column

data class ReviewEntity(
    @Id
    @Column("review_id")
    var reviewId: Long? = null,
)