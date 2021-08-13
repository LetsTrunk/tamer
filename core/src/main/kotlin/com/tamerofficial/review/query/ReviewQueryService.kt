package com.tamerofficial.review.query

import com.tamerofficial.infra.dao.ReviewRepository
import com.tamerofficial.review.query.dto.Review
import com.tamerofficial.review.query.interfaces.ReviewQuery
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class ReviewQueryService(
    val reviewRepository: ReviewRepository
) : ReviewQuery {
    override suspend fun listReviewBy(placeId: Long): Mono<Review> {
        return Mono.empty()
    }
}