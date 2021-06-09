package com.tamerofficial.app.places

import com.tamerofficial.common.ResponseEntity
import com.tamerofficial.common.SuccessStatus
import com.tamerofficial.place.infra.entity.PlacesDetailView
import com.tamerofficial.place.query.PlaceDetailService
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
    suspend fun getPlaceDetail(@PathVariable("placeId") placeId : Long) : ResponseEntity<PlacesDetailView?> {
        return ResponseEntity(SuccessStatus.statusCode, SuccessStatus.statusMessage, placesDetailService.searchPlaceDetail(placeId))
    }
}