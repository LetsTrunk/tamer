package com.tamerofficial.infra.dao

import com.tamerofficial.infra.entity.ReviewEntity
import org.springframework.data.repository.CrudRepository

interface ReviewRepository : CrudRepository<ReviewEntity, Long> {
}