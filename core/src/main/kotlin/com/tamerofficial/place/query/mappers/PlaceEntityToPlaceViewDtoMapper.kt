package com.tamerofficial.place.query.mappers

import com.tamerofficial.common.Location
import com.tamerofficial.infra.entity.PlaceEntity
import com.tamerofficial.place.query.dto.Address
import com.tamerofficial.place.query.dto.Area
import com.tamerofficial.place.query.dto.PlaceViewDto
import com.tamerofficial.place.query.dto.SubArea

object PlaceEntityToPlaceViewDtoMapper {
    fun PlaceEntity.toDto() : PlaceViewDto {
        return PlaceViewDto(
            placeId= this.placeId!!,
            name = this.name,
            address = Address(this.address1,this.address2),
            area = Area(areaId = 0L, name = ""),
            subArea = SubArea(subAreaId = this.subAreaId, name = this.subAreaName),
            location = Location(lat = this.lat, lon = this.lon)
        )
    }
}