package com.tamerofficial.app.places

import com.tamerofficial.common.Log
import com.tamerofficial.common.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/places")
@RestController
class PlacesApiController {
    companion object : Log

    @GetMapping
    suspend fun listPlaces() : ResponseEntity<List<Any>> {
        return ResponseEntity("","", emptyList())
    }

    @GetMapping("/detail/{placeId}")
    suspend fun detailPlaces(@PathVariable("placeId") placeId : Long) : ResponseEntity<Any> {
        return ResponseEntity("","", "")
    }
}