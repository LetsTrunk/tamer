package com.tamerofficial.infra

import com.tamerofficial.infra.entity.ScoreAttributeEntity
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ScoreAttributeRepository : ReactiveCrudRepository<ScoreAttributeEntity, Long>{
    fun findByPlaceId(placeId:Long) : Flow<ScoreAttributeEntity>
}