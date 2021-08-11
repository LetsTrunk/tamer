package com.tamerofficial.place.query

import com.tamerofficial.place.infra.dao.PlaceDetailEditRepository
import com.tamerofficial.place.infra.dao.PlacesDetailViewRepository
import com.tamerofficial.place.infra.entity.PlacesView
import com.tamerofficial.place.query.interfaces.PlaceDetailService
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class PlaceDetailServiceImplV1(
    private val placesDetailViewRepository: PlacesDetailViewRepository,
    private val placesDetailEditRepository: PlaceDetailEditRepository
) : PlaceDetailService {
    override suspend fun searchPlaceDetail(placeId : Long) : Mono<PlacesView> {
        return placesDetailViewRepository.findById(placeId)
    }

    override suspend fun addPlaceDetailViewCount(placeId: Long): Mono<Void> {
        val placeMono = placesDetailEditRepository.findById(placeId)
        return placeMono.flatMap {
            it.viewCount++
            placesDetailEditRepository.save(it)
        }.then()
    }
}