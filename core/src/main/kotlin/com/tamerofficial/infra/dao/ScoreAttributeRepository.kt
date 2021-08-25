package com.tamerofficial.infra.dao

import com.tamerofficial.infra.entity.ScoreAttributeEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ScoreAttributeRepository : CrudRepository<ScoreAttributeEntity, Long>{
    fun findByPlaceId(placeId:Long) : ScoreAttributeEntity
}