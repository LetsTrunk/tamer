package com.tamerofficial.app.home

import com.tamerofficial.common.Log
import com.tamerofficial.common.ResponseEntity
import com.tamerofficial.domain.home.Home
import com.tamerofficial.domain.home.dto.Location
import com.tamerofficial.domain.home.dto.NearByPlace
import com.tamerofficial.domain.home.dto.RecommendKnowHow
import kotlinx.coroutines.flow.toList
import org.springframework.web.bind.annotation.*

@RequestMapping("/home")
@RestController
class HomeApiController(private val home:Home) {
    companion object : Log

    @PostMapping("nearby-me")
    suspend fun listNearByMe(@RequestBody location:Location) : ResponseEntity<List<NearByPlace>> {
        val results = home.listNearByPlace(location).toList()
        return ResponseEntity(
            "200",
            "Success",
            results
        )
    }

    @GetMapping("recommend-knowhow")
    suspend fun listRecommendKnowHow() : ResponseEntity<List<RecommendKnowHow>> {
        val loginId = "test" // get from security context
        val results = home.listRecommendKnowHow(loginId).toList()
        return ResponseEntity(
            "200",
            "Success",
            results
        )
    }
}