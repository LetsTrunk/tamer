package com.tamerofficial.place.query.interfaces

import com.tamerofficial.place.query.dto.PlaceViewDto

interface PlaceDetailService {
    fun searchPlaceDetail(placeId : Long) : PlaceViewDto
    fun addPlaceDetailViewCount(placeId: Long)
}