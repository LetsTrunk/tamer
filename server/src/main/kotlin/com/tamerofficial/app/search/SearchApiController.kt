package com.tamerofficial.app.search

import com.tamerofficial.common.Log
import com.tamerofficial.common.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/search")
@RestController
class SearchApiController {
    companion object : Log

    /**
     * 장소 키워드 검색
     */
    @GetMapping("/{keyword}/places")
    suspend fun search(@PathVariable("keyword") keyword : String) : ResponseEntity<List<Any>> {
        logger.debug("[Search Ctrl] keyword is $keyword")
        return ResponseEntity("","",emptyList())
    }
}