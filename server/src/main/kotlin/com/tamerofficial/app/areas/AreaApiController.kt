package com.tamerofficial.app.areas

import com.tamerofficial.common.ResponseEntity
import com.tamerofficial.domain.places.Area
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AreaApiController {

    /**
     * 행정구역 목록
     */
    @GetMapping
    suspend fun listAreas() : ResponseEntity<List<Area>> {
        return ResponseEntity("","", emptyList())
    }
}