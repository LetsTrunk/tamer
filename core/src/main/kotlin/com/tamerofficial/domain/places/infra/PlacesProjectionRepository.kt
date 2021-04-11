package com.tamerofficial.domain.places.infra

import com.tamerofficial.domain.places.infra.entity.PlacesEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PlacesProjectionRepository : ReactiveCrudRepository<PlacesEntity,Long>{
}