package com.tamerofficial.infra.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDateTime

@Table("places")
data class PlacesListView(
    @Id
    @Column("place_id")
    val placeId: Long? = null,

    @Column("is_trunk")
    val isTrunk : Boolean = false,

    @Column("place_name")
    val name : String,
    @Column("place_desc")
    val desc : String,

    @Column("latitude")
    val lat : BigDecimal,

    @Column("longitude")
    val lon : BigDecimal,

    val distance : Long?,

    @Column("address1")
    val address1: String,
    @Column("address2")
    val address2: String,

    @Column("area_id")
    val areaId : Long = 0,

    @Column("area_name")
    val areaName : String,
    @Column("subarea_id")
    val subAreaId : Long = 0,

    @Column("subarea_name")
    val subAreaName : String,

    @Column("createdAt")
    val createdAt : LocalDateTime?,
    @Column("updatedAt")
    val updatedAt : LocalDateTime?
)
