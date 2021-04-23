package com.tamerofficial.infra.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table


@Table("place_filter_attributes")
data class FilterAttributeEntity(
    @Id
    @Column("filter_attr_id")
    val filterAttrId: Long? = null,

    @Column("filter_name")
    val name : String? = null,

//    @Column("createdAt")
//    val createdAt : LocalDateTime?,
//
//    @Column("updatedAt")
//    val updatedAt : LocalDateTime?
){

}