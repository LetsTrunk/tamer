package com.tamerofficial.infra.dao

import com.tamerofficial.infra.entity.FilterAttributeEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FilterAttributesRepository  : CrudRepository<FilterAttributeEntity, Long>