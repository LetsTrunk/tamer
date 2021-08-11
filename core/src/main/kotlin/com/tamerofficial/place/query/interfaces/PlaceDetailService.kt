package com.tamerofficial.place.query.interfaces

import com.tamerofficial.place.infra.entity.PlacesView
import reactor.core.publisher.Mono

interface PlaceDetailService {
    suspend fun searchPlaceDetail(placeId : Long) : Mono<PlacesView>
    suspend fun addPlaceDetailViewCount(placeId: Long): Mono<Void>
}