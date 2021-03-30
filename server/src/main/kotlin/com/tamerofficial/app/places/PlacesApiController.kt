package com.tamerofficial.app.places

import com.tamerofficial.common.Log
import com.tamerofficial.common.ResponseEntity
import com.tamerofficial.domain.common.Location
import com.tamerofficial.domain.places.Place
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/places")
@RestController
class PlacesApiController(private val placeService: PlaceService) {
    companion object : Log

    @GetMapping
    suspend fun placesPage() : ResponseEntity<PlacePage> {
        val placePage = placeService.placePage()
        return ResponseEntity("","",placePage)
    }

    @GetMapping("list/places/{areaId}")
    suspend fun listPlaces(@PathVariable("areaId") areaId: Long) : ResponseEntity<List<Place>> {
        return ResponseEntity("","", emptyList())
    }

    @GetMapping("/detail/{placeId}")
    suspend fun detailPlaces(@PathVariable("placeId") placeId : Long) : ResponseEntity<Place> {
        return ResponseEntity("","", Place(name="김동원집앞",1L,1L, Location(1,2),"서울특별시 강남구 대치동","xxx-xx", true))
    }
}