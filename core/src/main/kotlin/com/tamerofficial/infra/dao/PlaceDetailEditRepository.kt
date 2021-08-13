package com.tamerofficial.infra.dao

import com.tamerofficial.infra.entity.PlacesEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface PlaceDetailEditRepository : ReactiveCrudRepository<PlacesEntity,Long>{
}