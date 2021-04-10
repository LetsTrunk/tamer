package com.tamerofficial.app.places


import com.tamerofficial.app.places.dto.PlaceSearchConditions
import com.tamerofficial.common.Log
import com.tamerofficial.common.ResponseEntity
import com.tamerofficial.common.StatusCode.TK_PL_00100
import com.tamerofficial.common.SuccessStatus
import com.tamerofficial.domain.places.FilterAttribute
import com.tamerofficial.domain.places.Place
import com.tamerofficial.domain.places.infra.FilterAttributeEntity
import com.tamerofficial.domain.places.infra.FilterAttributesRepository
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RequestMapping("/places")
@RestController
class PlacesApiController(
    private val placeService: PlaceService,
    private val filterRepository: FilterAttributesRepository
    ) {
    companion object : Log

    @GetMapping("/test")
    suspend fun test() : FilterAttributeEntity {
        return filterRepository.save(FilterAttributeEntity(name = "test")).awaitSingle()
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
    @GetMapping("list/places/{areaId}")
    suspend fun listPlacesByArea(@PathVariable("areaId") areaId: Long) : ResponseEntity<List<Place>> {
        return ResponseEntity("","", emptyList())
    }

    /**
     * 선택된 지역 별로 검색 조건에 맞는 장소 목록을 주기 위함
     */
    @PostMapping("list/places")
    suspend fun listPlacesByConditions(@RequestBody placeSearchCondition: PlaceSearchConditions) : ResponseEntity<List<Place>> {
        return ResponseEntity(TK_PL_00100,"요청 정상 수신", emptyList())
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