package com.tamerofficial.place.infra.dao

import com.tamerofficial.place.infra.entity.FilterAttributeEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FilterAttributesRepository  : ReactiveCrudRepository<FilterAttributeEntity, Long>