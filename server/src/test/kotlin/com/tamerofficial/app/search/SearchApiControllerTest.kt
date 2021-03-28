package com.tamerofficial.app.search

import com.ninjasquad.springmockk.MockkBean
import com.tamerofficial.common.ResponseEntity
import com.tamerofficial.config.SecurityConfig
import com.tamerofficial.domain.home.Home
import com.tamerofficial.domain.home.dto.Location
import com.tamerofficial.domain.home.dto.NearByPlace
import io.kotest.core.spec.style.FunSpec
import io.mockk.coEvery
import kotlinx.coroutines.flow.asFlow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.context.annotation.Import
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.BodyInserters

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