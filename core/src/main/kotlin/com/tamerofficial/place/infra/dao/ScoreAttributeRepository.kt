package com.tamerofficial.place.infra.dao

import com.tamerofficial.place.infra.entity.ScoreAttributeEntity
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface ScoreAttributeRepository : ReactiveCrudRepository<ScoreAttributeEntity, Long>{
    @Query("select * from place_score_attributes where place_id = :placeId")
    fun findByPlaceId(placeId:Long) : Mono<ScoreAttributeEntity>
}