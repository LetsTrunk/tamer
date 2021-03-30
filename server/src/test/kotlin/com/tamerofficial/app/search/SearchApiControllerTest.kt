package com.tamerofficial.app.search

import com.tamerofficial.common.ResponseEntity
import com.tamerofficial.config.SecurityConfig
import io.kotest.core.spec.style.FunSpec
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.context.annotation.Import
import org.springframework.core.ParameterizedTypeReference
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient

@ExtendWith(SpringExtension::class)
@WebFluxTest(SearchApiController::class)
@Import(SecurityConfig::class)
class SearchApiControllerTest : FunSpec(){

    @Autowired
    private lateinit var webClient : WebTestClient

    @Test
    fun `search Api Should Return Results`(){
        val result = webClient.get()
            .uri("/search/서울캠핑장/places")
            .exchange()
            .expectStatus().isOk
            .expectBody(object: ParameterizedTypeReference<ResponseEntity<List<Any>>>(){})
    }
}