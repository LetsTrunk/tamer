package com.tamerofficial

import com.tamerofficial.domain.home.dto.Location
import com.tamerofficial.domain.home.dto.NearByPlace
import com.tamerofficial.entity.MapData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class HomeApplication{

    suspend fun listNearByMe() : Flow<NearByPlace> {
        return Flux.fromIterable(listOf(
            NearByPlace(
            1,
            "test",
            "descTest",
            "https://www.naver.com",
            Location(1,1),
            emptyList(),
            emptyList()
        )
        )).asFlow()
    }

}