package com.tamerofficial.infra.entity

import javax.persistence.*

@Entity
@Table(name="reviews")
data class ReviewEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var reviewId: Long? = null,
)