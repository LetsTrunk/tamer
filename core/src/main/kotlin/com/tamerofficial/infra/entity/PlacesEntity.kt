package com.tamerofficial.infra.entity

import kotlinx.coroutines.flow.Flow
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

//projection 용 entity로 새로 정의해야 할 듯
@Table("places")
data class PlacesEntity(
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
    var lat : Long,

    @Column("longitude")
    var lon : Long,

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

    @Column("createdAt")
    var createdAt : LocalDateTime?,
    @Column("updatedAt")
    var updatedAt : LocalDateTime?,

    @Column("score")
    var score : Double,

    @Column("view_count")
    var viewCount : Long
)

