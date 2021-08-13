package com.tamerofficial.app.places


import com.tamerofficial.app.places.dto.AreaBaseSearchRequest
import com.tamerofficial.app.places.dto.LocationBaseSearchRequest
import com.tamerofficial.common.Log
import com.tamerofficial.common.ResponseEntity
import com.tamerofficial.common.SuccessStatus
import com.tamerofficial.infra.entity.PlaceEntity
import com.tamerofficial.place.query.*
import com.tamerofficial.place.query.dto.*
import com.tamerofficial.place.query.interfaces.PlaceDetailService
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.web.bind.annotation.*

@RequestMapping("/places")
@RestController
class PlacesApiController(
    private val placeService: PlaceService,
    private val placeDetailService: PlaceDetailService,
    private val filterQueryService: FilterQueryService
    ) {
    companion object : Log

    /**
     * 초기 정보 제공
     */
    @GetMapping
    suspend fun listPlaces() : ResponseEntity<PlacePage> {
        val filterList = listOf(
            FilterAttributeDto(
                filterAttrId = 0,
                displayName = "차박",
                name = "CAR",
                type = "CAMPING_TYPE"
            ),
            FilterAttributeDto(
                filterAttrId = 1,
                displayName = "차크닉",
                name = "CAR_PICNIC",
                type = "CAMPING_TYPE"
            ),
            FilterAttributeDto(
                filterAttrId = 2,
                displayName = "오토캠핑",
                name = "AUTO_CAMPING",
                type = "CAMPING_TYPE"
            )
        )

        val bannerList = listOf(
            Banner(
                id = 0,
                name = "첫번째 배너",
                imageUrl = "https://s.pstatic.net/shopping.phinf/20210805_11/705c5b1a-017a-4059-bce6-169555b9b287.jpg"
            ),
            Banner(
                id = 1,
                name = "두번째 배너",
                imageUrl = "https://s.pstatic.net/shopping.phinf/20210721_26/856c2c02-b974-4dc5-aab0-8006c60aaa2b.jpg"
            ),
        )

        //목록, 배너, 장소, 필터
        return ResponseEntity(
            SuccessStatus.statusCode,
            SuccessStatus.statusMessage,
            PlacePage(
                filterList = filterList,
                bannerList = bannerList,
                orderList = listOf(
                    Order("SCORE", "평점순"),
                    Order("DISTANCE", "거리순")
                ),
                placeList = listOf(
                    Place(
                        id = 0,
                        score = 4.3,
                        isTrunk = true,
                        title = "강동 그린웨이 가족 캠핑장0",
                        areaName = "서초구",
                        scrapCount = 34,
                        viewCount = 1280,
                        reviewCount = 20,
                        location = LatLon(0.toBigDecimal(),0.toBigDecimal())
                    ),
                    Place(
                        id = 1,
                        score = 4.3,
                        isTrunk = true,
                        title = "강동 그린웨이 가족 캠핑장1",
                        areaName = "서초구",
                        scrapCount = 34,
                        viewCount = 1280,
                        reviewCount = 20,
                        location = LatLon(0.toBigDecimal(),0.toBigDecimal())
                    ),
                    Place(
                        id = 2,
                        score = 4.3,
                        isTrunk = true,
                        title = "강동 그린웨이 가족 캠핑장2",
                        areaName = "서초구",
                        scrapCount = 34,
                        viewCount = 1280,
                        reviewCount = 20,
                        location = LatLon(0.toBigDecimal(),0.toBigDecimal())
                    ),
                    Place(
                        id = 3,
                        score = 4.3,
                        isTrunk = true,
                        title = "강동 그린웨이 가족 캠핑장3",
                        areaName = "서초구",
                        scrapCount = 34,
                        viewCount = 1280,
                        reviewCount = 20,
                        location = LatLon(0.toBigDecimal(),0.toBigDecimal())
                    )
                )
            )
        )
    }

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
    @GetMapping("/list/{areaId}/page/{pageNo}")
    suspend fun listPlacesByArea(
        @PathVariable("areaId") areaId: Long,
        @PathVariable("pageNo") pageNo: Int,
    ) : ResponseEntity<List<Place>> {

        logger.info("areaId is $areaId, pageNo is $pageNo")

        return ResponseEntity(
            SuccessStatus.statusCode,
            SuccessStatus.statusMessage,
            listOf(
                Place(
                    id = 0,
                    score = 4.3,
                    isTrunk = true,
                    title = "강동 그린웨이 가족 캠핑장0",
                    areaName = "서초구",
                    scrapCount = 34,
                    viewCount = 1280,
                    reviewCount = 20,
                    location = LatLon(0.toBigDecimal(),0.toBigDecimal())
                ),
                Place(
                    id = 1,
                    score = 4.3,
                    isTrunk = true,
                    title = "강동 그린웨이 가족 캠핑장1",
                    areaName = "서초구",
                    scrapCount = 34,
                    viewCount = 1280,
                    reviewCount = 20,
                    location = LatLon(0.toBigDecimal(),0.toBigDecimal())
                ),
                Place(
                    id = 2,
                    score = 4.3,
                    isTrunk = true,
                    title = "강동 그린웨이 가족 캠핑장2",
                    areaName = "서초구",
                    scrapCount = 34,
                    viewCount = 1280,
                    reviewCount = 20,
                    location = LatLon(0.toBigDecimal(),0.toBigDecimal())
                ),
                Place(
                    id = 3,
                    score = 4.3,
                    isTrunk = true,
                    title = "강동 그린웨이 가족 캠핑장3",
                    areaName = "서초구",
                    scrapCount = 34,
                    viewCount = 1280,
                    reviewCount = 20,
                    location = LatLon(0.toBigDecimal(),0.toBigDecimal())
                )
            )
        )
    }

    /**
     * 선택된 지역 별로 검색 조건에 맞는 장소 목록을 주기 위함
     * 검색 조건 : 지역 기준 (area(single), subArea(multi))
     * 공통 조건 : 정렬
     */
//    @PostMapping("/list/filteredBy/area")
//    suspend fun listPlacesByFilteredBy(@RequestBody request: AreaBaseSearchRequest) : ResponseEntity<List<Place>>{
//        val searchCondition = AreaBaseSearchCondition(
//            request.areaCode,
//            request.subAreas,
//            DistanceFrom(request.currentLocation,request.distance),
//            request.sortBy
//        )
//        return ResponseEntity(SuccessStatus.statusCode,SuccessStatus.statusMessage, placeService.listPlaceViewBy(searchCondition).toList())
//    }

    /**
     * 선택된 지역 별로 검색 조건에 맞는 장소 목록을 주기 위함
     * 검색 조건 : 지역 기준 (area(single), subArea(multi))
     * 공통 조건 : 정렬
     */
    @PostMapping("/list/filteredBy/areaTest")
    suspend fun listPlacesByFilteredByTest(@RequestBody request: AreaBaseSearchRequest) : ResponseEntity<List<PlaceEntity>>{
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
    suspend fun listPlacesByFilteredBy(@RequestBody request: LocationBaseSearchRequest) : ResponseEntity<List<PlaceEntity>>{
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
//        return ResponseEntity("","", placeDetailService.searchPlaceDetail(placeId).awaitSingle())
//    }
}