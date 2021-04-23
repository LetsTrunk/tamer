package com.tamerofficial

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController() {
    // Mono -> awaitSingle
    // Flux -> asFlow
    @GetMapping("/hello")
    suspend fun hello(): String {
        return "hello"
    }

}