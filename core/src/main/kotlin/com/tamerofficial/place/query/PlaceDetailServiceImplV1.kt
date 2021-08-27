package com.tamerofficial.place.query

import com.tamerofficial.infra.dao.PlaceRepository
import com.tamerofficial.infra.dao.PlacesDetailViewRepository
import com.tamerofficial.place.query.dto.PlaceViewDto
import com.tamerofficial.place.query.interfaces.PlaceDetailService
import com.tamerofficial.place.query.mappers.PlaceEntityToPlaceViewDtoMapper.toDto
import org.springframework.stereotype.Service

@Service
class PlaceDetailServiceImplV1(
    private val placesDetailViewRepository: PlacesDetailViewRepository,
    private val placeRepository: PlaceRepository
    //리뷰 repo 추가 할 것
) : PlaceDetailService {

    override fun searchPlaceDetail(placeId: Long): PlaceViewDto {
        return placeRepository.findById(placeId).get().toDto()
    }

    override fun addPlaceDetailViewCount(placeId: Long){
        TODO("Not yet implemented")
    }
}