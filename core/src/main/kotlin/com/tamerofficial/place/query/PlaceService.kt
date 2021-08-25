package com.tamerofficial.place.query

import com.tamerofficial.infra.PlaceViewQueryFuncFactory
import com.tamerofficial.infra.dao.FilterAttributesRepository
import com.tamerofficial.infra.dao.PlacesListViewRepository
import com.tamerofficial.infra.dao.ScoreAttributeRepository
import com.tamerofficial.infra.entity.PlaceEntity
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service

//검색 조건에 따라서 쿼리가 바뀐다.
//Repository에 호출 하는 레이어에서는 조건을 명시적으로 사용해서 조회를 시도하고,
//조회를 하는 쪽에서는 동적으로 결과를 호출하는 메서드를 바꿀 수 있도록 하고싶다.
//repository + repository (entity, entity, entity) 조합을 통해서 결과를 조회 할 수 있는 경우도 해당 복잡도를 감추고 싶다.

@Service
class PlaceService(
    private val queryFuncFactory: PlaceViewQueryFuncFactory,
    private val filterRepository: FilterAttributesRepository,
    private val placesListViewRepository: PlacesListViewRepository,
    private val scoreAttributeRepository: ScoreAttributeRepository
    ) {

//    suspend fun listPlaceViewBy(locationBaseSearchCondition: LocationBaseSearchCondition) : Flow<PlaceEntity> = coroutineScope {
//        //반경 목록 갯수, 조회
//        val queryFunc = queryFuncFactory.search(locationBaseSearchCondition.distanceFrom!!.distance)
//        return@coroutineScope queryFunc(0,300,locationBaseSearchCondition.distanceFrom.currentLocation)
//    }

    /**
     * 위치, 지역 기반 검색 조건을 갖고, 검색 수행한다.
     */
//    suspend fun listPlaceViewBy(areaBaseSearchCondition: AreaBaseSearchCondition) : Flow<PlaceEntity> = coroutineScope {
//        //반경 목록 갯수, 조회
//        val queryFunc = queryFuncFactory.search(areaBaseSearchCondition.areaCode)
//        return@coroutineScope queryFunc(0,300,areaBaseSearchCondition.distanceFrom!!.currentLocation)
//    }

    /**
     * 위치, 지역 기반 검색 조건을 갖고, 검색 수행한다.
     */
//    suspend fun listPlaceViewByTest(areaBaseSearchCondition: AreaBaseSearchCondition) : Flow<PlaceEntity> = coroutineScope {
//        //반경 목록 갯수, 조회
//        return@coroutineScope placesListViewRepository.findByArea(areaBaseSearchCondition.areaCode!!,0,300,areaBaseSearchCondition.distanceFrom!!.currentLocation)
//    }
}



