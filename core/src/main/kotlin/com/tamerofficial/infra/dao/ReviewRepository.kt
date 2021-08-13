package com.tamerofficial.infra.dao

import com.tamerofficial.infra.entity.ReviewEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ReviewRepository : ReactiveCrudRepository<ReviewEntity, Long> {
}