package com.tamerofficial.app.places


import com.tamerofficial.app.places.dto.AreaBaseSearchRequest
import com.tamerofficial.app.places.dto.LocationBaseSearchRequest
import com.tamerofficial.common.Log
import com.tamerofficial.common.ResponseEntity
import com.tamerofficial.common.SuccessStatus
import com.tamerofficial.place.infra.entity.PlacesListView
import com.tamerofficial.place.query.*
import kotlinx.coroutines.flow.toList
import org.springframework.web.bind.annotation.*

@RequestMapping("/places")
@RestController
class PlacesApiController(
    private val placeService: PlaceService,
    private val filterQueryService: FilterQueryService
    ) {
    companion object : Log

    /**
     * 필터 정보를 주기 위함
     */
    @GetMapping("/list/filter")
    suspend fun listFilters() : ResponseEntity<List<FilterAttributeDto>>{
        return ResponseEntity(SuccessStatus.statusCode, SuccessStatus.statusMessage, filterQueryService.listFilterAttributes().toList())
    }

    /**
     * 선택된 지역단위 장소 목록을 주기 위함
     *
     */
    @GetMapping("/list/{areaId}")
    suspend fun listPlacesByArea(@PathVariable("areaId") areaId: Long) : ResponseEntity<List<PlaceViewDto>> {
        return ResponseEntity("","", emptyList())
    }

    /**
     * 선택된 지역 별로 검색 조건에 맞는 장소 목록을 주기 위함
     * 검색 조건 : 지역 기준 (area(single), subArea(multi))
     * 공통 조건 : 정렬
     */
    @PostMapping("/list/filteredBy/area")
    suspend fun listPlacesByFilteredBy(@RequestBody request: AreaBaseSearchRequest) : ResponseEntity<List<PlacesListView>>{
        val searchCondition = AreaBaseSearchCondition(
            request.areaCode,
            request.subAreas,
            DistanceFrom(request.currentLocation,request.distance),
            request.sortBy
        )
        return ResponseEntity(SuccessStatus.statusCode,SuccessStatus.statusMessage, placeService.listPlaceViewBy(searchCondition).toList())
    }

    /**
     * 선택된 지역 별로 검색 조건에 맞는 장소 목록을 주기 위함
     * 검색 조건 : 지역 기준 (area(single), subArea(multi))
     * 공통 조건 : 정렬
     */
    @PostMapping("/list/filteredBy/areaTest")
    suspend fun listPlacesByFilteredByTest(@RequestBody request: AreaBaseSearchRequest) : ResponseEntity<List<PlacesListView>>{
        val searchCondition = AreaBaseSearchCondition(
            request.areaCode,
            request.subAreas,
            DistanceFrom(request.currentLocation,request.distance),
            request.sortBy
        )
        return ResponseEntity(SuccessStatus.statusCode,SuccessStatus.statusMessage, placeService.listPlaceViewByTest(searchCondition).toList())
    }

    /**
     * 현재 위치 별로 검색 조건에 맞는 장소 목록을 주기 위함
     * 검색 조건 : 현재 위치 반경 기준
     * 반경 조회
     * 공통 조건 : 정렬
     */
    @PostMapping("/list/filteredBy/location")
    suspend fun listPlacesByFilteredBy(@RequestBody request: LocationBaseSearchRequest) : ResponseEntity<List<PlacesListView>>{
        val searchCondition = LocationBaseSearchCondition(
            DistanceFrom(request.currentLocation,request.distance),
            request.sortBy
        )
        return ResponseEntity(SuccessStatus.statusCode,SuccessStatus.statusMessage,placeService.listPlaceViewBy(searchCondition).toList() )
    }

//    /**
//     * 선택된 장소의 상세 정보를 조회 하기 위함
//     * param : placeId
//     */
//    @GetMapping("/detail/{placeId}")
//    suspend fun detailPlaces(@PathVariable("placeId") placeId : Long) : ResponseEntity<PlaceViewDto> {
//        return ResponseEntity("","")
//    }
}