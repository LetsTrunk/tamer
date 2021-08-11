package com.tamerofficial.place.infra.dao

import com.tamerofficial.place.infra.entity.PlacesEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface PlaceDetailEditRepository : ReactiveCrudRepository<PlacesEntity,Long>{
}