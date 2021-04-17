package com.tamerofficial.app.places


import com.tamerofficial.app.places.dto.AreaBaseSearchCondition
import com.tamerofficial.app.places.dto.LocationBaseSearchCondition
import com.tamerofficial.common.Log
import com.tamerofficial.common.ResponseEntity
import com.tamerofficial.common.SuccessStatus
import com.tamerofficial.domain.places.FilterAttribute
import com.tamerofficial.domain.places.Place
import com.tamerofficial.domain.places.infra.FilterAttributesRepository
import com.tamerofficial.domain.places.infra.PlacesProjectionRepository
import com.tamerofficial.domain.places.infra.PlacesView
import com.tamerofficial.domain.places.infra.ScoreAttributeRepository
import com.tamerofficial.domain.places.infra.entity.FilterAttributeEntity
import com.tamerofficial.domain.places.infra.entity.PlacesEntity
import com.tamerofficial.domain.places.infra.entity.ScoreAttributeEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitSingle
import kotlinx.coroutines.reactive.collect
import org.springframework.web.bind.annotation.*

@RequestMapping("/places")
@RestController
class PlacesApiController(
    private val placeService: PlaceService,
    private val filterRepository: FilterAttributesRepository,
    private val placesProjectionRepository: PlacesProjectionRepository,
    private val scoreAttributeRepository: ScoreAttributeRepository
    ) {
    companion object : Log

    /**
     * R2DBC 테스팅
     */
    @GetMapping("/test")
    suspend fun test() : FilterAttributeEntity {
        return filterRepository.save(FilterAttributeEntity(name = "test")).awaitSingle()
    }

    @GetMapping("/test2")
    suspend fun test2() : PlacesView {
        return placesProjectionRepository.findAll().awaitSingle()
    }

    /**
     * 처음페이지 로딩할때 초기 데이터 한번에 주기 위한 용도
     */
    @GetMapping
    suspend fun placesPage() : ResponseEntity<PlacePage> {
        val placePage = placeService.placePage()
        return ResponseEntity("","",placePage)
    }

    /**
     * 필터 정보를 주기 위함
     */
    suspend fun listFilters() : ResponseEntity<List<FilterAttribute>>{
        return ResponseEntity(SuccessStatus.statusCode, SuccessStatus.statusMessage, emptyList())
    }

    /**
     * 선택된 지역단위 장소 목록을 주기 위함
     *
     */
    @GetMapping("/list/{areaId}")
    suspend fun listPlacesByArea(@PathVariable("areaId") areaId: Long) : ResponseEntity<List<Place>> {
        return ResponseEntity("","", emptyList())
    }

    /**
     * 선택된 지역 별로 검색 조건에 맞는 장소 목록을 주기 위함
     * 검색 조건 : 지역 기준 (area(single), subArea(multi))
     * 공통 조건 : 정렬
     */
    @PostMapping("/list/filteredBy/area")
    suspend fun listPlacesByFilteredBy(@RequestBody areaBaseSearchCondition: AreaBaseSearchCondition) : ResponseEntity<List<Place>>{
        return ResponseEntity(SuccessStatus.statusCode,SuccessStatus.statusMessage)
    }

    /**
     * 현재 위치 별로 검색 조건에 맞는 장소 목록을 주기 위함
     * 검색 조건 : 현재 위치 반경 기준
     * 반경 조회
     * 공통 조건 : 정렬
     */
    @PostMapping("/list/filteredBy/location")
    suspend fun listPlacesByFilteredBy(@RequestBody locationBaseSearchCondition: LocationBaseSearchCondition) : ResponseEntity<List<PlacesView>>{
        return ResponseEntity(SuccessStatus.statusCode,SuccessStatus.statusMessage,placeService.listPlaceViewBy(locationBaseSearchCondition).toList() )
    }

    /**
     * 선택된 장소의 상세 정보를 조회 하기 위함
     * param : placeId
     */
    @GetMapping("/detail/{placeId}")
    suspend fun detailPlaces(@PathVariable("placeId") placeId : Long) : ResponseEntity<Place> {
        return ResponseEntity("","")
    }
}