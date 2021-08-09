package com.tamerofficial.place.query

import com.tamerofficial.place.infra.dao.PlacesDetailRepository
import com.tamerofficial.place.infra.entity.PlacesDetailView
import com.tamerofficial.place.infra.entity.PlacesView
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class PlaceDetailService(
    private val placesDetailRepository: PlacesDetailRepository
) {
    suspend fun searchPlaceDetail(placeId : Long) : Mono<PlacesView> {
        return placesDetailRepository.findById(placeId)
    }
}