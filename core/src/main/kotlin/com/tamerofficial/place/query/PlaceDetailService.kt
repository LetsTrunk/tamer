package com.tamerofficial.place.query

import com.tamerofficial.place.infra.dao.PlacesDetailRepository
import com.tamerofficial.place.infra.entity.PlacesDetailView
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.stereotype.Service

@Service
class PlaceDetailService(
    private val placesDetailRepository: PlacesDetailRepository
) {
    suspend fun searchPlaceDetail(placeId : Long) : PlacesDetailView? {
        return placesDetailRepository.findById(placeId).awaitFirstOrNull()
    }
}