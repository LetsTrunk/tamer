package com.tamerofficial.infra.entity

import com.tamerofficial.common.utils.safeValueOf
import com.tamerofficial.place.query.dto.FilterAttributeDto
import com.tamerofficial.place.query.dto.FilterType
import org.apache.logging.log4j.util.Strings
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime


@Table("place_filter_attributes")
data class FilterAttributeEntity(
    @Id
    @Column("filter_attr_id")
    val filterAttrId: Long? = null,

    @Column("filter_name")
    val name : String,

    @Column("filter_type")
    val type : String,

    @Column("display_name")
    val displayName : String,

    @Column("createdAt")
    val createdAt : LocalDateTime?,

    @Column("updatedAt")
    val updatedAt : LocalDateTime?
){
    fun toDto() = FilterAttributeDto(
        filterAttrId = this.filterAttrId ?: 0,
        displayName = this.displayName,
        name = this.name,
        type =  safeValueOf<FilterType>(this.type)?.name ?: Strings.EMPTY
    )
}