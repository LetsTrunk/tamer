package com.tamerofficial.infra.entity

import com.tamerofficial.common.Location
import com.tamerofficial.place.query.Address
import com.tamerofficial.place.query.Area
import com.tamerofficial.place.query.PlaceViewDto
import com.tamerofficial.place.query.SubArea
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import java.math.BigDecimal
import java.time.LocalDateTime

data class PlacesView(
    @Id
    @Column("place_id")
    val placeId: Long? = null,

    @Column("place_name")
    val name : String,
    @Column("place_desc")
    val desc : String,

    @Column("latitude")
    val lat : BigDecimal,
    @Column("longitude")
    val lon : BigDecimal,

    @Column("address1")
    val address1: String,
    @Column("address2")
    val address2: String,

    @Column("area_id")
    val areaId : Long = 0,

    @Column("area_name")
    val areaName : String,

    @Column("subarea_id")
    val subareaId : Long = 0,

    @Column("subarea_name")
    val subareaName : String,

    @Transient
    var scores : ScoreAttributeEntity? = null,

    @Column("createdAt")
    val createdAt : LocalDateTime?,
    @Column("updatedAt")
    val updatedAt : LocalDateTime?
){
    fun toDto() : PlaceViewDto {
        return PlaceViewDto(
            placeId= this.placeId!!,
            name = this.name,
            address = Address(this.address1,this.address2),
            area = Area(areaId = 0L, name = ""),
            subArea = SubArea(subAreaId = this.subareaId, name = this.subareaName),
            location = Location(lat = this.lat, lon = this.lon),
            scoreAttribute = this.scores?.toDto()
        )
    }
}