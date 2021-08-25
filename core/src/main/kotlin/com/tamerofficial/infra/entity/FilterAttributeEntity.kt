package com.tamerofficial.infra.entity

import com.tamerofficial.common.utils.safeValueOf
import com.tamerofficial.place.query.dto.FilterAttributeDto
import com.tamerofficial.place.query.dto.FilterType
import org.apache.logging.log4j.util.Strings
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "place_filter_attributes")
data class FilterAttributeEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val filterAttrId: Long? = null,

    @Column(name = "filter_name")
    val name : String,

    @Column(name = "filter_type")
    val type : String,

    @Column(name = "display_name")
    val displayName : String,

    @Column(name = "createdAt")
    val createdAt : LocalDateTime?,

    @Column(name = "updatedAt")
    val updatedAt : LocalDateTime?
){
    fun toDto() = FilterAttributeDto(
        filterAttrId = this.filterAttrId ?: 0,
        displayName = this.displayName,
        name = this.name,
        type =  safeValueOf<FilterType>(this.type)?.name ?: Strings.EMPTY
    )
}