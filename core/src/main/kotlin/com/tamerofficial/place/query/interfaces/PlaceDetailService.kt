package com.tamerofficial.place.query.interfaces

import com.tamerofficial.place.query.dto.PlaceViewDto
import reactor.core.publisher.Mono

interface PlaceDetailService {
    suspend fun searchPlaceDetail(placeId : Long) : Mono<PlaceViewDto>
    suspend fun addPlaceDetailViewCount(placeId: Long): Mono<Void>
}