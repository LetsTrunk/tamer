package com.tamerofficial.place.query

import com.tamerofficial.infra.dao.PlaceRepository
import com.tamerofficial.infra.dao.PlacesDetailViewRepository
import com.tamerofficial.place.query.dto.PlaceViewDto
import com.tamerofficial.place.query.interfaces.PlaceDetailService
import com.tamerofficial.place.query.mappers.PlaceEntityToPlaceViewDtoMapper.toDto
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class PlaceDetailServiceImplV1(
//    private val placesDetailViewRepository: PlacesDetailViewRepository,
//    private val placeRepository: PlaceRepository
    //리뷰 repo 추가 할 것
) : PlaceDetailService {

    override suspend fun searchPlaceDetail(placeId: Long): Mono<PlaceViewDto> {
        TODO("Not yet implemented")
    }

    override suspend fun addPlaceDetailViewCount(placeId: Long): Mono<Void> {
        TODO("Not yet implemented")
    }
}