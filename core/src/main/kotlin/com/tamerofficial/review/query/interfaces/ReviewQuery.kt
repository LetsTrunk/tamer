package com.tamerofficial.review.query.interfaces

import com.tamerofficial.review.query.dto.Review
import reactor.core.publisher.Mono

interface ReviewQuery {
    suspend fun listReviewBy(placeId : Long) : Mono<Review>
}