package com.tamerofficial.domain.places.infra

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.util.*

@Repository
interface FilterAttributesRepository  : ReactiveCrudRepository<FilterAttributeEntity, Long>

@Table("place_filter_attributes")
class FilterAttributeEntity(
    @Id
    @Column("filter_attr_id")
    var filterAttrId: Long? = null,
    @Column("filter_name")
    val name : String? = null,

//    @Column("createdAt")
//    val createdAt : LocalDateTime?,
//
//    @Column("updatedAt")
//    val updatedAt : LocalDateTime?
)