package com.tamerofficial.app.places

import com.tamerofficial.common.ResponseEntity
import com.tamerofficial.common.SuccessStatus
import com.tamerofficial.place.query.PlaceDetailServiceImplV1
import com.tamerofficial.place.query.interfaces.PlaceDetailService
import com.tamerofficial.place.query.mappers.PlaceToPlaceDetailMapper
import com.tamerofficial.place.query.pages.Place
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/places/detail")
@RestController
class PlaceDetailApiController(
    private val placesDetailService : PlaceDetailService
) {
    @GetMapping("/{placeId}")
    suspend fun getPlaceDetail(@PathVariable("placeId") placeId : Long) : ResponseEntity<Place?> {
        return ResponseEntity(
            SuccessStatus.statusCode,
            SuccessStatus.statusMessage,
            placesDetailService.searchPlaceDetail(placeId)
                .map { PlaceToPlaceDetailMapper.toPlaceDetail(it) }
                .awaitFirstOrNull()
        )
    }
}