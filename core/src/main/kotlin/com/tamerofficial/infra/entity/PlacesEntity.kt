package com.tamerofficial.infra.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

//projection 용 entity로 새로 정의해야 할 듯
@Table("places")
data class PlacesEntity(
    @Id
    @Column("place_id")
    val placeId: Long? = null,

    @Column("place_name")
    val name : String,
    @Column("place_desc")
    val desc : String,

    @Column("latitude")
    val lat : Long,

    @Column("longitude")
    val lon : Long,

    @Column("address1")
    val address1: String,
    @Column("address2")
    val address2: String,

    @Column("area_id")
    val areaId : Long = 0,

//    @Column("area_name")
//    val areaName : String,
    @Column("subarea_id")
    val subAreaId : Long = 0,

//    @Column("subarea_name")
//    val subAreaName : String,

    @Column("createdAt")
    val createdAt : LocalDateTime?,
    @Column("updatedAt")
    val updatedAt : LocalDateTime?
)
