package com.tamerofficial.app.places

import com.tamerofficial.app.places.dto.AreaBaseSearchCondition
import com.tamerofficial.app.places.dto.LocationBaseSearchCondition
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
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service

//검색 조건에 따라서 쿼리가 바뀐다.
//Repository에 호출 하는 레이어에서는 조건을 명시적으로 사용해서 조회를 시도하고,
//조회를 하는 쪽에서는 동적으로 결과를 호출하는 메서드를 바꿀 수 있도록 하고싶다.
//repository + repository (entity, entity, entity) 조합을 통해서 결과를 조회 할 수 있는 경우도 해당 복잡도를 감추고 싶다.

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
    suspend fun listPlaceViewBy(areaBaseSearchCondition: AreaBaseSearchCondition) : Flow<PlacesView> = coroutineScope {
        //반경 목록 갯수, 조회
        return@coroutineScope placesProjectionRepository.findByArea(areaBaseSearchCondition.areaCode!!,0,300).map{
            val result = scoreAttributeRepository.findByPlaceId(it.placeId!!).toList()
            it.scores = it.scores + result
            it
        }
    }
}

data class PlacePage(
    val areas: List<Area>,
    val banners: List<Any>,
    val places: List<Place>
)