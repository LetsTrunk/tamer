package com.tamerofficial.app.banner

import com.tamerofficial.common.Log
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/banner")
@RestController
class BannerApiController(
    private val bannerApp: Any
) {
    companion object : Log

    @GetMapping("/{type}")
    suspend fun listBanner(@PathVariable("type")type: String) {

    }
}