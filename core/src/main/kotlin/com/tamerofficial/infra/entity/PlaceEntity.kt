package com.tamerofficial.infra.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDateTime

@Table("places")
data class PlaceEntity(
    @Id
    @Column("place_id")
    var placeId: Long? = null,

    @Column("is_trunk")
    var isTrunk : Boolean = false,

    @Column("place_name")
    var name : String,
    @Column("place_desc")
    var desc : String,

    @Column("latitude")
    var lat : BigDecimal,

    @Column("longitude")
    var lon : BigDecimal,

    var distance : Long?,

    @Column("address1")
    var address1: String,
    @Column("address2")
    var address2: String,

    @Column("area_id")
    var areaId : Long = 0,

    @Column("area_name")
    var areaName : String,

    @Column("subarea_id")
    var subAreaId : Long = 0,

    @Column("subarea_name")
    var subAreaName : String,

    @Column("view_cnt")
    var viewCount : Long,

    @Column("score")
    var score : Double,

    @Column("createdAt")
    var createdAt : LocalDateTime?,
    @Column("updatedAt")
    var updatedAt : LocalDateTime?,
)
