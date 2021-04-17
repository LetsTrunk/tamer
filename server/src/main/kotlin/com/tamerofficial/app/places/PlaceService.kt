package com.tamerofficial.app.places

import com.tamerofficial.app.places.dto.LocationBaseSearchCondition
import com.tamerofficial.app.places.dto.PlaceSearchCriteria
import com.tamerofficial.domain.places.Area
import com.tamerofficial.domain.places.AreasApp
import com.tamerofficial.domain.places.Place
import com.tamerofficial.domain.places.Places
import com.tamerofficial.domain.places.infra.FilterAttributesRepository
import com.tamerofficial.domain.places.infra.PlacesProjectionRepository
import com.tamerofficial.domain.places.infra.PlacesView
import com.tamerofficial.domain.places.infra.ScoreAttributeRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactive.asFlow
import org.springframework.stereotype.Service

@Service
class PlaceService(
    private val placeApp: Places,
    private val areasApp: AreasApp,
    private val filterRepository: FilterAttributesRepository,
    private val placesProjectionRepository: PlacesProjectionRepository,
    private val scoreAttributeRepository: ScoreAttributeRepository
    ) {

    suspend fun placePage(): PlacePage = coroutineScope {
        val areas = async { areasApp.listAreas() }
        val places = async { placeApp.listPlaces(Area(name="서울특별시",areaCode="SEOUL",areaId=1L, subAreas = emptyList())) }
        PlacePage(areas.await().toList(), emptyList(), places.await().toList())
    }

    suspend fun listPlaceViewBy(locationBaseSearchCondition: LocationBaseSearchCondition) : Flow<PlacesView> = coroutineScope {
        //반경 목록 갯수, 조회
        return@coroutineScope placesProjectionRepository.findByDistanceIn(locationBaseSearchCondition.distanceFrom!!.distance,0,300).map{
            val result = scoreAttributeRepository.findByPlaceId(it.placeId!!).toList()
            it.scores = it.scores + result
            it
        }
    }

    /**
     * 위치, 지역 기반 검색 조건을 갖고, 검색 수행한다.
     */
    suspend fun listPlaces(searchCriteria: PlaceSearchCriteria) : Flow<Places> {
        // db 에서 조회 하는 쿼리 만들기
        // 검색 조건에 따라서 테이블 정규화 고민하기


        return emptyFlow()
    }
}

data class PlacePage(
    val areas: List<Area>,
    val banners: List<Any>,
    val places: List<Place>
)