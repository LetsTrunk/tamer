package com.tamerofficial.app.places

import com.tamerofficial.config.SecurityConfig
import io.kotest.core.spec.style.FunSpec
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient

@ExtendWith(SpringExtension::class)
@WebFluxTest(PlacesApiController::class)
@Import(SecurityConfig::class)
class PlacesApiControllerTest  : FunSpec() {

    @Autowired
    private lateinit var webClient : WebTestClient


}