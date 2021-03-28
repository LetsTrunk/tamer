package com.tamerofficial.app.knowhow

import com.tamerofficial.common.Log
import com.tamerofficial.common.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/knowhow")
@RestController
class KnowhowApiController {
    companion object : Log

    @GetMapping("/list/category")
    suspend fun listKnowhowCategory() : ResponseEntity<List<Any>> {
        return ResponseEntity("","", emptyList())
    }

    @GetMapping("/list")
    suspend fun listKnowhow() : ResponseEntity<List<Any>> {
        return ResponseEntity("","", emptyList())
    }

    @GetMapping("/detail/{knowhowId}")
    suspend fun detailKnowhow(@PathVariable("knowhowId") knowhowId : Long) : ResponseEntity<List<Any>> {

        return ResponseEntity("","", emptyList())
    }
}