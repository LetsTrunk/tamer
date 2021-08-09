package com.tamerofficial.place.query.mappers

import com.tamerofficial.place.infra.entity.PlacesView
import com.tamerofficial.place.query.pages.LatLon
import com.tamerofficial.place.query.pages.Place

object PlaceToPlaceDetailMapper {
    fun toPlaceDetail(orig: PlacesView) : Place {
        return Place(
            id = orig.placeId.let { it } ?: 0,
            title = orig.name,
            isTrunk = orig.isTrunk,
            score =  orig.score,
            areaName = orig.areaName,
            scrapCount = 0,
            viewCount = 0,
            reviewCount = 0,
            location = LatLon(orig.lat,orig.lon)
        )
    }
}