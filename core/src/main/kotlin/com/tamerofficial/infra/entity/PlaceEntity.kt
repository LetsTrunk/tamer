package com.tamerofficial.infra.entity

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="places")
data class PlaceEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var placeId: Long? = null,

    @Column(name = "is_trunk")
    var isTrunk : Boolean = false,

    @Column(name = "place_name")
    var name : String,
    @Column(name = "place_desc")
    var desc : String,

    @Column(name = "latitude")
    var lat : BigDecimal,

    @Column(name = "longitude")
    var lon : BigDecimal,

    var distance : Long?,

    @Column(name = "address1")
    var address1: String,

    @Column(name = "address2")
    var address2: String,

    @Column(name = "area_id")
    var areaId : Long = 0,

    @Column(name = "area_name")
    var areaName : String,

    @Column(name = "subarea_id")
    var subAreaId : Long = 0,

    @Column(name = "subarea_name")
    var subAreaName : String,

    @Column(name = "view_cnt")
    var viewCount : Long,

    @Column(name = "score")
    var score : Double,

    @Column(name = "createdAt")
    var createdAt : LocalDateTime?,
    @Column(name = "updatedAt")
    var updatedAt : LocalDateTime?,
)
